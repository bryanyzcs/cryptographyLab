package banksystem.dao;

import banksystem.mapper.AccountMapper;
import banksystem.pojo.Account;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("AccountDaoImpl")
@Scope("prototype")
public class AccountDaoImpl implements AccountDao{

    @Resource
    private AccountMapper accountMapper;


    @Override
    public Account findAccountByName(String name) {
        return accountMapper.selectAccountByName(name);
    }

    @Override
    public Account findAccountByCardId(String cardId) {
        return accountMapper.selectAccountByCardId(cardId);
    }

    @Override
    public void updateBalance(Double balance, String name, String cardid) {
        accountMapper.updateBalance(balance, name, cardid);
        return;
    }


}
