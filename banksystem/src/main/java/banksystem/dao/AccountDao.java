package banksystem.dao;

import banksystem.pojo.Account;

public interface AccountDao {

    public Account findAccountByName(String name);

    public Account findAccountByCardId(String carId);

    public void updateBalance(Double balance, String name, String cardid);
}
