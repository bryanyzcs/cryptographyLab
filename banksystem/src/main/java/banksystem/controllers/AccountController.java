package banksystem.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.awt.image.PackedColorModel;

@Controller
@RequestMapping("/account")
public class AccountController {

    @RequestMapping(params="method=index")
    public String index(HttpSession session){
        return "account";
    }

    @RequestMapping(params="method=accountinfo")
    public String accountInfo(HttpSession session){



        return "accountinfo";
    }

    @RequestMapping(params="method=deposit")
    public String deposit(HttpSession session){
       return "account";
    }

    @RequestMapping(params="method=transfer")
    public String transfer(HttpSession session){
        return "transfer";
    }
}
