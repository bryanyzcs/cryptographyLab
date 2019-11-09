package ecommerce.dao;

import ecommerce.pojo.User;

public interface UserDao {
    public User findUserById(int id);
}
