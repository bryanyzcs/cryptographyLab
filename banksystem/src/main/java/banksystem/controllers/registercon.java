package banksystem.controllers;

import banksystem.dao.UserDao;
import banksystem.dao.UserDaoImpl;
import banksystem.pojo.User;
import org.apache.ibatis.jdbc.Null;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.ModelMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.security.PrivateKey;
import java.sql.DriverManager;
import java.sql.SQLException;

@Controller

public class registercon {
    @RequestMapping("/register")
    public String getRegister() {
        return "register";
    }
}

