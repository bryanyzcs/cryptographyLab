package banksystem.dao;


import banksystem.mapper.UserMapper;
import banksystem.pojo.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;

@Service("userDaoImpl")
@Scope("prototype")
public class UserDaoImpl implements UserDao{

    @Resource
    private UserMapper userMapper;

    @Override
    public User findUsrByName(String usrName){
        User user = userMapper.selectUseByName(usrName);
        //if(user == null){
            //throw new NullPointerException();
        //}
        return user;
    }

    @Override
    public boolean addUserByreg(User user) {
        boolean flag=userMapper.addUser(user);
        return flag;
    }
}
