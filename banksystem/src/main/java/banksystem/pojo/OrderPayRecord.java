package banksystem.pojo;

import java.util.Date;

public class OrderPayRecord {
    private String orderPayNumber;
    private Account payAccount;
    private Account recvAccount;
    private Date orderPayDate;
    private String orderMsg;
    private String orderNum;
    private double orderPayMoney;

    public String getOrderPayNumber() {
        return orderPayNumber;
    }

    public void setOrderPayNumber(String orderPayNumber) {
        this.orderPayNumber = orderPayNumber;
    }

    public Account getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(Account payAccount) {
        this.payAccount = payAccount;
    }

    public Account getRecvAccount() {
        return recvAccount;
    }

    public void setRecvAccount(Account recvAccount) {
        this.recvAccount = recvAccount;
    }

    public Date getOrderPayDate() {
        return orderPayDate;
    }

    public void setOrderPayDate(Date orderPayDate) {
        this.orderPayDate = orderPayDate;
    }

    public String getOrderMsg() {
        return orderMsg;
    }

    public void setOrderMsg(String orderMsg) {
        this.orderMsg = orderMsg;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public double getOrderPayMoney() {
        return orderPayMoney;
    }

    public void setOrderPayMoney(double orderPayMoney) {
        this.orderPayMoney = orderPayMoney;
    }
}
