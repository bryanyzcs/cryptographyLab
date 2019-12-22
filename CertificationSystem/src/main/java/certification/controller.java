package certification;

import certification.certificate.CaPrivateKey;
import certification.certificate.DigitalCertificate;
import certification.certificate.SignAlgorithm;
import certification.core.*;
import certification.core.query.PathQuery;
import certification.core.query.Query;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class controller {

    @RequestMapping("/")
    public String getHome(Model model){
        Handler handler = new Handler();
        handler.timeoutHandler();
        return "redirect:index.html";
    }

    /**
     *上传文件 ,用@RequestParam注解来指定表单上的file为MultipartFile
     */
    @RequestMapping(value = "/keyUpload", method = RequestMethod.POST)
    public String handleFormUpload(@RequestParam MultipartFile file) throws IOException {

        if (!file.isEmpty()) {
            byte[] bytes = file.getBytes();
            // store the bytes somewhere
            String fileName = file.getOriginalFilename();
            System.out.println(fileName);
            String path = PathQuery.democaPath+ PathQuery.privatePath+fileName;
            File fileWriteTo = new File(path);
            if(!fileWriteTo.exists()) {
                fileWriteTo.createNewFile();
            }
            FileOutputStream out = new FileOutputStream(fileWriteTo);
            out.write(bytes);
            out.close();

            Source.pkPathList.add(path);//pk path
            Source.pkListLastSize++;
            //Generate a certificate
            GenCer genCer = new GenCer();
            System.out.println("Pk Path : "+Source.pkPathList.get(Source.pkListLastSize));
            System.out.println("Request : "+Source.request.constructBodyName());
            DigitalCertificate digitalCertificate = new DigitalCertificate(Source.request.constructBodyName());
            String returnValue = generateCert(Source.pkPathList.get(Source.pkListLastSize),digitalCertificate);
            System.out.println("return value : "+returnValue);
            if (returnValue.equals("Reject!")){
                return "redirect:generateFailure.html";
            }
            Source.filePath = returnValue;
            return "redirect:requestDispose.html";
        }

        return "redirect:uploadFailure.html";
    }


    @RequestMapping(value = "/gencer",method = RequestMethod.GET)
    public String genCerHandle(HttpServletRequest request){
        String info =  request.getQueryString();
        String tok = null;
        try {
            tok = URLDecoder.decode(info,"utf-8");
            System.out.println(tok);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String[] split = tok.split("&");
        List<String> paramList = new ArrayList<>();
        for(String string:split){
            String[] splits = string.split("=");
            paramList.add(splits[1]);
        }
        int i = 0;
        Source.request = new Request(paramList.get(i),paramList.get(i+1),paramList.get(i+2),paramList.get(i+3),paramList.get(i+4),paramList.get(i+5),paramList.get(i+6));
        return "redirect:upload.html";
    }

    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request) throws IOException {
        String filePath = Source.filePath;
        if (filePath == null){
            return null;
        }
        System.out.println(filePath);
        File file = new File(filePath);
        byte[] body = null;
        InputStream is = new FileInputStream(file);
        body = new byte[is.available()];
        is.read(body);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attchement;filename=" + file.getName());
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
        return entity;
    }

    @RequestMapping("/downloadCRL")
    public ResponseEntity<byte[]> downloadCRL(HttpServletRequest request) throws IOException {
        String filePath = PathQuery.crlPath;
        System.out.println(filePath);
        File file = new File(filePath);
        byte[] body = null;
        InputStream is = new FileInputStream(file);
        body = new byte[is.available()];
        is.read(body);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attchement;filename=" + file.getName());
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
        return entity;
    }

    @RequestMapping("/downloadCA")
    public ResponseEntity<byte[]> downloadCA(HttpServletRequest request) throws IOException {
        String filePath = PathQuery.democaPath+PathQuery.certsPath+"ca.txt";
        System.out.println(filePath);
        File file = new File(filePath);
        byte[] body = null;
        InputStream is = new FileInputStream(file);
        body = new byte[is.available()];
        is.read(body);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attchement;filename=" + file.getName());
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
        return entity;
    }

    @RequestMapping("/revoke")
    public Map<String,String> revoke(HttpServletRequest request){
        String[] split = request.getQueryString().split("=");
        String serial = split[1].split("&")[0];
        String commonName = split[2];
        if(serial.length()==1){
            serial = "0" +serial;
        }
        String query = new Query().queryCertificate(serial);
        String param = null;
        Map<String ,String> map = new HashMap<>();
        if (query == null){
            param = "Certificate of this serial number was not published.";
            map.put("key1",param);
        } else if (query.equals("Revoked!")){
            param = "Certificate of this serial number has been revoked.";
            map.put("key1",param);
        } else {
            CRL crl = new CRL();
            param = crl.doRequestCRL(serial,commonName);
            if(param.contains("Error")){
                param = "Failed to Revoke!";
                map.put("key1",param);
            } else if(param.contains("Not")) {
                map.put("key1",param);
            } else {
                map.put("key1","The Certificate Serial Numeber = "+serial+" Now Has Been Revoked!\nWe Will Release New CRL,Please Notice Us. ");
            }
            //update crl,read from file.
        }
        return map;
    }

    @RequestMapping(value = "/inquiry",method = RequestMethod.GET)
    public Map<String,String> inquiry(HttpServletRequest request){
        String input = request.getQueryString();
        String serial = input.substring(7);
        if(serial.length()==1){
            serial = "0" +serial;
        }
        System.out.println(serial);
        String query = new Query().queryCertificate(serial);
        String param = null;
        Map<String ,String> map = new HashMap<>();
        Source.filePath = null;
        if (query == null) {
            param = "Certificate of this serial number was not published.";
            map.put("key1",param);
        } else if (query.equals("Revoked!")){
            param = "Certificate of this serial number has been revoked.";
            map.put("key1",param);
        } else {
            param = query;
            map.put("key1","Serial Numeber = "+serial+" ,Common Name = "+param);
            Source.filePath = PathQuery.democaPath+ PathQuery.certsPath+serial+".txt";
        }

        //return "redirect:inquiryConsequence.jsp";
        return map;
    }

    public String generateCert(String pubkeyPath, DigitalCertificate digitalCertificate){
        String publickey = null;
        SignAlgorithm signAlgorithm = new SignAlgorithm();
        //公钥提取
        publickey = signAlgorithm.getKey(pubkeyPath);
        //publickey = new CaPrivateKey().pk;

        digitalCertificate.setPublicKey(publickey);
        String info = digitalCertificate.getinfo();
        String signature = null;
        String caPrivateKeyPath = PathQuery.caPrivateKey;
        //String caPrivateKey = signAlgorithm.getKey(caPrivateKeyPath);
        String caPrivateKey = CaPrivateKey.caPrivateKey;
        //hash
        //rsa
        System.out.println("info = "+info);
        try {
            signature  = signAlgorithm.signNew(info.getBytes(),caPrivateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Signature="+signature);
        if (signature==null){
            return "Reject!";
        }
        digitalCertificate.setSign(signature);
        return digitalCertificate.genCertificate();

    }

}
