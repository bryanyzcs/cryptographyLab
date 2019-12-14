package banksystem.controllers;

import banksystem.ResponseResult;
import banksystem.dao.UserDao;
import banksystem.dao.UserDaoImpl;
import banksystem.pojo.User;
import org.apache.ibatis.jdbc.Null;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.DriverManager;
import java.sql.SQLException;

@Controller
public class controller {

//    @RequestMapping(value = "/findUser", method = RequestMethod.POST)
//    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
//        if (userdao.findUsrByName(username)== null)
//        {
//            model.addAttribute("msg", "用户不存在！考虑注册?");
//            return "index";
//        }
//        if (password.equals(userdao.findUsrByName(username).getPassword())) {
//            User user = userdao.findUsrByName(username);
//            model.addAttribute("msg", username);
//            model.addAttribute("msg1", user.getMoney());
//            return "findUser";
//        }
//        else {
//            model.addAttribute("msg", "密码错误！");
//            return "index";
//        }
//    }


    @Resource
    private UserDao userdao;




    @RequestMapping("/home")
    public String getIndex(){

//        String n="zhang";
//        User user = userdao.findUsrByName(n);
//        if(user == null){
//            System.out.println("can't find the user with usrName zhang");
//        }
//        else {
//            model.addAttribute("name", user.getUsrName());
//        }
        return "index";
    }
    @RequestMapping("/findUser")
    public String loginin(){
        return "findUser";
    }
    @RequestMapping(value="/register-form", produces="application/json; charset=UTF-8")
    @ResponseBody
    public ResponseResult regForm(@RequestParam String regName, @RequestParam String pwd) throws Exception {

        if(userdao.findUsrByName(regName) != null) {
            return ResponseResult.createErrMessage("账户已存在");
        }
        else{
            User user=new User();
            user.setMoney(0);
            user.setPassword(pwd);
            user.setUsrName(regName);
            boolean flag=userdao.addUserByreg(user);
            if(flag){
                return ResponseResult.createOkMessage("账户注册成功");
            }
            else
                return ResponseResult.createErrMessage("注册失败");
        }


    }
    @RequestMapping(value="/login-form", produces="application/json; charset=UTF-8")
    @ResponseBody
    public ResponseResult logForm(@RequestParam String userName, @RequestParam String password,Model model) throws Exception {

        if(userdao.findUsrByName(userName) == null) {
            return ResponseResult.createErrMessage("账户不存在");
        }
        else{
            User user=userdao.findUsrByName(userName);

            if(password.equals(user.getPassword())){

                return ResponseResult.createOk(null);
            }
            else{
                return ResponseResult.createErrMessage("密码错误");
            }

        }



    }


}
