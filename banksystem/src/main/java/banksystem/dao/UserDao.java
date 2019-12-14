package banksystem.dao;

import banksystem.pojo.User;

public interface UserDao {
    public User findUsrByName(String usrName);
    public boolean addUserByreg(User user);
}
