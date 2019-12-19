package banksystem.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/pay")
public class PayController {

    @RequestMapping("/")
    String pay(ModelMap model, @RequestParam String orderMsg, @RequestParam String orderNum, @RequestParam Double totalMoney){

        model.addAttribute("orderMsg", orderMsg);
        model.addAttribute("orderNum", orderNum);

        model.addAttribute("totalMoney", totalMoney);

        return "paymsg";
        //订单信息， 订单号，商品总价

    }

}
