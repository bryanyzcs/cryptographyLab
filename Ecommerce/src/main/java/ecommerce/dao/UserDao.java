package ecommerce.dao;

import ecommerce.pojo.UserInfo;

public interface UserDao {

    public UserInfo findUserByName(String userName);

    public boolean insertUserInfo(UserInfo userInfo);
}
