package banksystem.controllers;


import banksystem.ResponseResult;
import banksystem.dao.AccountDaoImpl;
import banksystem.pojo.Account;
import banksystem.pojo.OrderPayRecord;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
//@RequestMapping("/pay")
public class PayController {

    @Resource
    private AccountDaoImpl accountService = new AccountDaoImpl();
    @RequestMapping(value = "/pay", params = "method=order")
    String pay(ModelMap model, @RequestParam String orderMsg, @RequestParam String orderNum, @RequestParam Double totalMoney, HttpSession session){

        model.addAttribute("orderMsg", orderMsg);
        model.addAttribute("orderNum", orderNum);
        model.addAttribute("totalMoney", totalMoney);

        Account recvAccount = accountService.findAccountByCardId("523526");
        OrderPayRecord orderPayRecord = new OrderPayRecord();
        orderPayRecord.setOrderMsg(orderMsg);
        orderPayRecord.setOrderNum(orderNum);
        orderPayRecord.setOrderPayMoney(totalMoney);
        orderPayRecord.setOrderPayDate(new Date());
        orderPayRecord.setRecvAccount(recvAccount);

        session.setAttribute("orderRecord", orderPayRecord);
        return "paymsg";
        //订单信息， 订单号，商品总价
    }
    @RequestMapping(value = "/pay",params="method=paycommit")
    public ResponseResult paycommit(Model model, String payAccountNum, String payName, String passwd, HttpSession session) {

        Account payAccount = accountService.findAccountByCardId(payAccountNum);
        if(payAccount == null)
            return ResponseResult.createErrMessage("卡号不存在");
        else if (!payAccount.getName().equals(payName)){
            return ResponseResult.createErrMessage("卡号和姓名不匹配");
        }
        else if(!payAccount.getPasswd().equals(passwd))
            return ResponseResult.createErrMessage("密码错误");
        OrderPayRecord  orderPayRecord = (OrderPayRecord) session.getAttribute("orderRecord");
        orderPayRecord.setPayAccount(payAccount);
        double balance = payAccount.getBalance();
        payAccount.setBalance(balance - orderPayRecord.getOrderPayMoney());
        Account recvAccount = orderPayRecord.getRecvAccount();
        balance = recvAccount.getBalance();
        recvAccount.setBalance(balance + orderPayRecord.getOrderPayMoney());
        accountService.updateBalance(payAccount.getBalance(),payAccount.getName(),payAccount.getCardid());
        accountService.updateBalance(recvAccount.getBalance(),recvAccount.getName(),recvAccount.getCardid());
        return ResponseResult.createOk(null);
    }

    @RequestMapping(value = "/pay",params="method=showreturn")
    public String showretrun(Model model){
        model.addAttribute("msg", "返回商家");
        model.addAttribute("returnURL", "http://192.168.137.108:8080/Ecommerce");
        return "transferResult";
    }


    @RequestMapping(value = "/pay",params="method=payreturn")
    public String payreturn(){
        return "redirect:http://192.168.137.108:8080/Ecommerce";
    }
}
