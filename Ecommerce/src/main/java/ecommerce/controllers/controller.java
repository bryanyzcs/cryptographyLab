package ecommerce.controllers;

import ecommerce.ResponseResult;
import ecommerce.dao.UserDaoImpl;
import ecommerce.pojo.UserInfo;
import ecommerce.security.Keys;
import ecommerce.security.Rsa;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


@Controller
public class controller {

    @Resource
    private UserDaoImpl user = new UserDaoImpl();

    @RequestMapping(value="/findUser",method = RequestMethod.GET)
    public String getUser(Model model){
        UserInfo userInfo = user.findUserByName("li");
        model.addAttribute("password", /*userInfo.getPassword()*/ "hello");
        return "findUser";
    }


    @RequestMapping("/")
    public String getHome(Model model){
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model){
        return "login";
    }

    @RequestMapping(value="/login-form", produces="application/json; charset=UTF-8")
    @ResponseBody
    public ResponseResult logFrom(@RequestParam String logName, @RequestParam String rsapwd) throws Exception {
        Rsa rsa= new Rsa();
        String priKeyStr = Keys.getRsaPrivateKey();
        rsa.loadPrivateKey(priKeyStr);
        String pwd = new String(rsa.decrypt(rsa.base64Decode(rsapwd)));
        UserInfo logUser = user.findUserByName(logName);
        if(logUser == null){
            return ResponseResult.createErrMessage("您输入的用户名不存在");
        }
        else if(logUser.getPassword().equals(pwd) == false){
            return ResponseResult.createErrMessage("您输入的用户名和密码不匹配，请重新输入");
        }
        else {
            return ResponseResult.createOk(null);
        }
    }

    @RequestMapping(value="/register-form", produces="application/json; charset=UTF-8")
    @ResponseBody
    public ResponseResult regForm(@RequestParam String regName, @RequestParam String rsapwd) throws Exception {
        Rsa rsa= new Rsa();
        String priKeyStr = Keys.getRsaPrivateKey();
        rsa.loadPrivateKey(priKeyStr);
        String pwd = new String(rsa.decrypt(rsa.base64Decode(rsapwd)));
        if(user.findUserByName(regName) != null) {
            return ResponseResult.createErrMessage("账户已存在");
        }
        else{
            UserInfo userInfo = new UserInfo();
            userInfo.setUsername(regName);
            userInfo.setPassword(pwd);
            user.insertUserInfo(userInfo);
            return ResponseResult.createOkMessage("账户注册成功");
        }
    }

    @RequestMapping("/register")
    public String register(Model model){
        return "register";
    }


    @RequestMapping("/cert")
    @ResponseBody
    public String cert() throws IOException {
        String certPem = "";
        String str;
        BufferedReader reader= new BufferedReader(new FileReader("D://project/web project/cryptographyLab/Ecommerce/src/main/java/ecommerce/data/cert.cer"));
        while((str = reader.readLine()) != null){
            certPem += str.replace("\n", "");
        }
        return certPem;
    }
}
