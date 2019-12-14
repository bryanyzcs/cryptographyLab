package banksystem.mapper;

import banksystem.pojo.User;

public interface UserMapper {


    public User selectUseByName(String usrName);
    public boolean addUser(User user);

}
