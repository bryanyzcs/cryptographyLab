package banksystem.controllers;

import banksystem.ResponseResult;
import banksystem.dao.AccountDao;
import banksystem.dao.AccountDaoImpl;
import banksystem.pojo.Account;
import banksystem.pojo.TransferRecord;
import banksystem.security.Keys;
import banksystem.security.Rsa;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.ModelMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class controller {



    @Resource
    private AccountDaoImpl accountService = new AccountDaoImpl();

    @RequestMapping("/")
    public String getIndex(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model){
        return "login";
    }

    @RequestMapping(value="/login-form", produces="application/json; charset=UTF-8")
    @ResponseBody
    public ResponseResult logFrom(@RequestParam String cardId, @RequestParam String rsapwd, HttpSession session) throws Exception {
        Rsa rsa= new Rsa();
        String priKeyStr = Keys.getRsaPrivateKey();
        rsa.loadPrivateKey(priKeyStr);
        String pwd = new String(rsa.decrypt(rsa.base64Decode(rsapwd)));
        Account logAccount = accountService.findAccountByCardId(cardId);
        if(logAccount == null){
            return ResponseResult.createErrMessage("您输入的用户名不存在");
        }
        else if(logAccount.getPasswd().equals(pwd) == false){
            return ResponseResult.createErrMessage("您输入的用户名和密码不匹配，请重新输入");
        }
        session.setAttribute("loginAccount", logAccount);
        return ResponseResult.createOk(null);
    }

    @RequestMapping("/logout")
    public String logout(Model model, HttpSession session){
        session.setAttribute("loginAccount", null);
        return "index";
    }

    @RequestMapping(value="/transfer-form", produces="application/json; charset=UTF-8")
    @ResponseBody
    public ResponseResult transferForm(@RequestParam String payPasswd,@RequestParam String payAccount, @RequestParam String payMoney,
                                       @RequestParam String recvName, @RequestParam String recvAccount, HttpSession session){
        double money = Double.valueOf(payMoney);
        Account currentAccount = (Account)session.getAttribute("loginAccount");
        if(payAccount.equals(currentAccount.getCardid()) == false){
            return ResponseResult.createErrMessage("付款账户不是您所登陆的当前账户");
        }
        if(money > currentAccount.getBalance()){
            return ResponseResult.createErrMessage("您的余额不足");
        }
        if(!payPasswd.equals(currentAccount.getPasswd())){
            return ResponseResult.createErrMessage("wrong passwd!");
        }
        Account recvAccountInfo = accountService.findAccountByCardId(recvAccount);
        if(recvAccountInfo == null || recvAccountInfo.getName().equals(recvName) == false){
            return ResponseResult.createErrMessage("收款账户信息不正确，请核实");
        }
        TransferRecord record = new TransferRecord();
        record.setPayAccount(currentAccount);
        record.setRecvAccount(recvAccountInfo);
        record.setTransferDate(new Date());
        record.setTransferMoney(money);
        record.setTransferNumber("33333333");
        session.setAttribute("transferRecord", record);
        return ResponseResult.createOk(null);
    }
    @RequestMapping("/transfer-confirm")
    public String transferConfirm(HttpSession session){

        return "transferconfirm";
    }

    @RequestMapping("/transfer")
    public String transfer(Model model, HttpSession session, HttpServletRequest request){
        TransferRecord record = (TransferRecord)session.getAttribute("transferRecord");
        if(record == null){
            return null;
        }
        Account payAccount = record.getPayAccount();
        Account recvAccount = record.getRecvAccount();
        double money = record.getTransferMoney();
        double payBalance = payAccount.getBalance();
        payAccount.setBalance(payBalance-money);
        double recvBalance = recvAccount.getBalance();
        recvAccount.setBalance(recvBalance + money);
        accountService.updateBalance(payBalance-money, payAccount.getName(), payAccount.getCardid());
        accountService.updateBalance(recvBalance+money, recvAccount.getName(), recvAccount.getCardid());
        session.setAttribute("transferRecord", null);
        model.addAttribute("msg", "返回首页");
        model.addAttribute("returnURL", "/banksystem/account?method=index");
        return "transferResult";
    }
}
