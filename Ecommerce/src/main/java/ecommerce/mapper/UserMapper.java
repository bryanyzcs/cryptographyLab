package ecommerce.mapper;

import ecommerce.pojo.UserInfo;

public interface UserMapper {

    public UserInfo selectUseByName(String userName);

    public boolean insertUserInfo(UserInfo userInfo);
}
