package banksystem.pojo;

import java.util.Date;

public class TransferRecord {
    private String transferNumber;
    private Account payAccount;
    private Account recvAccount;
    private Date transferDate;
    private double transferMoney;

    public String getTransferNumber() {
        return transferNumber;
    }

    public void setTransferNumber(String transferNumber) {
        this.transferNumber = transferNumber;
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

    public double getTransferMoney() {
        return transferMoney;
    }

    public void setTransferMoney(double transferMoney) {
        this.transferMoney = transferMoney;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }
}
