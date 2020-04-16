package cn.sdut.jdbc;

import java.util.List;

public interface AccountDao {
    int addAccount(Account account);

    int updateAccount(Account account);

    int deleteAccount(int id);

    Account findAccountById(int id);

    List<Account> findAllAccount();

    void transfer(String outUser, String inUser, Double money);
}
