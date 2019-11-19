package ecommerce.dao;


import ecommerce.mapper.UserMapper;
import ecommerce.pojo.UserInfo;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service("userDaoImpl")
@Scope("prototype")
public class UserDaoImpl implements UserDao{

    @Resource
    private UserMapper userMapper;

    @Override
    public UserInfo findUserByName(String userName){
        UserInfo user = userMapper.selectUseByName(userName);
        return user;
    }

    @Override
    public boolean insertUserInfo(UserInfo userInfo){
        return userMapper.insertUserInfo(userInfo);
    }
}
