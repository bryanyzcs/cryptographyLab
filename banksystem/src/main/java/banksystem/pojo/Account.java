package banksystem.pojo;

public class Account {
    private String name;
    private String cardtype;
    private String cardid;
    private double balance;
    private String passwd;

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype){
        this.cardtype = cardtype;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardtid){
        this.cardid = cardtid;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd){
        this.passwd= passwd;
    }


    @Override
    public String toString(){
        return name + balance;
    }
}
