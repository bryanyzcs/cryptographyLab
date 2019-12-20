package banksystem.controllers;


import banksystem.dao.AccountDaoImpl;
import banksystem.pojo.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.awt.image.PackedColorModel;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Resource
    private AccountDaoImpl accountService = new AccountDaoImpl();

    @RequestMapping(params="method=index")
    public String index(HttpSession session){
        if(ifmodify(session))
            return "redirect:login";
        return "account";
    }

    public Boolean ifmodify(HttpSession session){
        Account curAccount = (Account) session.getAttribute("loginAccount");
        if(curAccount == null){
            return true;
        }
        curAccount = accountService.findAccountByCardId(curAccount.getCardid());
        session.setAttribute("loginAccount", curAccount);
        return false;
    }
    @RequestMapping(params="method=accountinfo")
    public String accountInfo(HttpSession session){
        if(ifmodify(session))
            return "redirect:login";
        return "accountinfo";
    }

    @RequestMapping(params="method=deposit")
    public String deposit(HttpSession session){
        if(ifmodify(session))
            return "redirect:login";
       return "account";
    }

    @RequestMapping(params="method=transfer")
    public String transfer(HttpSession session){
        if(ifmodify(session))
            return "redirect:login";
        return "transfer";
    }
}
