package ecommerce.pojo;

public class UserInfo {

    private String userName;
    private String password;

    public String getUsername(){
        return userName;
    }

    public void setUsername(String userName){
        this.userName = userName;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public String toString() {
        return userName;
    }
}
