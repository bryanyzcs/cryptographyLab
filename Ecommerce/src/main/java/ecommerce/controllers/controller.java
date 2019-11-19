package ecommerce.controllers;

import ecommerce.ResponseResult;
import ecommerce.dao.UserDao;
import ecommerce.dao.UserDaoImpl;
import ecommerce.mapper.UserMapper;
import ecommerce.pojo.UserInfo;
import ecommerce.security.Keys;
import ecommerce.security.Rsa;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


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
    public String login(Model model, @RequestParam String userName, @RequestParam String password){
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(userName);
        userInfo.setPassword(password);
        user.insertUserInfo(userInfo);
        UserInfo queryInfo = user.findUserByName("chen");
        model.addAttribute("password", queryInfo.getPassword());
        return "findUser";
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
}
