package cn.sdut.dao;

import cn.sdut.domain.Account;

import java.util.List;

public interface AccountDao {
    List<Account> findAll();
    Account findAccountById(Integer id);
    int addAccount(Account account);
    List<Account> findAccountByName(String name);
    int findTotal();
}
