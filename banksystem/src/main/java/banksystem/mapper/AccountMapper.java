package banksystem.mapper;

import banksystem.pojo.Account;
import org.apache.ibatis.annotations.Param;

public interface AccountMapper {

    public Account selectAccountByName(String name);

    public Account selectAccountByCardId(String cardId);

    public void updateBalance(@Param("balance") Double balance, @Param("name") String name, @Param("cardid") String cardid);
    //public boolean insertUserInfo(Account userInfo);
}
