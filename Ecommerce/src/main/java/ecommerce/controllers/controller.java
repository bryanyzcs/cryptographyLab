package ecommerce.controllers;

import ecommerce.dao.UserDao;
import ecommerce.dao.UserDaoImpl;
import ecommerce.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.sql.DriverManager;
import java.sql.SQLException;

@Controller
public class controller {
    @RequestMapping(value="/findUser",method = RequestMethod.POST)
    public String getUser(Model model){
        return "findUser";
    }
    @Resource
    private UserDao userdao;

    @RequestMapping("/home")
    public String getIndex(Model model){


        User user = userdao.findUserById(1);
        if(user == null){
            System.out.println("can't find the user with userId 1");
        }
        else {
            model.addAttribute("name", user.getUserAge());
        }
        return "index";
    }
}
