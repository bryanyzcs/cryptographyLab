package banksystem.pojo;

public class User {
    private String usrName;
    private String password;
    private int money;

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){ this.password= password; }

    public String getUsrName(){
        return usrName;
    }

    public void setUsrName(String usrName){
        this.usrName = usrName;
    }

    public int getMoney(){
        return money;
    }

    public void setMoney(Integer money){
        this.money = money;
    }

    @Override
    public String toString() {
        return "user [userName=" + usrName+", password=" +password
                + ", money=" + money + "]";
    }
}
