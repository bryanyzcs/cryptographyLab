package certification;

import certification.certificate.CaPrivateKey;
import certification.certificate.DigitalCertificate;
import certification.certificate.SignAlgorithm;
import certification.core.GenCer;
import certification.core.Request;
import certification.core.Source;
import certification.core.query.PathQuery;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Path;
import java.security.PublicKey;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;

@Controller
public class controller {

    @RequestMapping("/")
    public String getHome(Model model){
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
            String returnValue = gererateCert(Source.pkPathList.get(Source.pkListLastSize),digitalCertificate);
            System.out.println("return value : "+returnValue);
            if (returnValue.equals("Reject!")){
                return "redirect:generateFailure.html";
            }
            Source.filePath = returnValue;
            return "redirect:requestDispose.html";
        }

        return "redirect:uploadFailure.html";
    }


    @RequestMapping(value = "gencer",method = RequestMethod.GET)
    public String genCerHandle(HttpServletRequest request){
        String info =  request.getQueryString();
        System.out.println(info);
        String[] split = info.split("&");
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
        String filePath = PathQuery.caCrtPath;
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
    public String revoke(HttpServletRequest request){
        return "redirect:revokeSecquence.html";
    }

    @RequestMapping("/inquiry")
    public String inquiry(HttpServletRequest request){
        return "redirect:inquirySecquence.html";
    }

    public String gererateCert(String pubkeyPath, DigitalCertificate digitalCertificate){
        String publickey = null;
        SignAlgorithm signAlgorithm = new SignAlgorithm();
        //公钥提取
        publickey = signAlgorithm.getKey(pubkeyPath);
        digitalCertificate.setPublicKey(publickey);
        String info = digitalCertificate.getinfo();
        String signature = null;
        String caPrivateKeyPath = PathQuery.caPrivateKey;
        String caPrivateKey = signAlgorithm.getKey(caPrivateKeyPath);
        //String caPrivateKey = CaPrivateKey.rsaPrivateKey;
        //hash
        //rsa
        System.out.println("info = "+info);
        signature  = signAlgorithm.sign(caPrivateKey,info,publickey);
        System.out.println("Signature="+signature);
        if (signature==null){
            return "Reject!";
        }
        digitalCertificate.setSign(signature);
        return digitalCertificate.genCertificate();

    }

}
