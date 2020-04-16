package cn.sdut.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class jdbcTemplateTest {
    public static void main(String[] args) {

    }

    @Test
    public void addAccountTest(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountDao accountDao = applicationContext.getBean("accountDao",AccountDao.class);
        Account account = new Account();
        account.setUsername("Tom");
        account.setBalance(1000.00);
        int num = accountDao.addAccount(account);
        if (num > 0){
            System.out.println("成功插入了"+num+"条数据！");
        }
        else{
            System.out.println("插入操作执行失败！");
        }
    }

    @Test
    public void updateAccountTest(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountDao accountDao = applicationContext.getBean("accountDao",AccountDao.class);
        Account account = new Account();
        account.setId(1);
        account.setUsername("Tom");
        account.setBalance(2000.00);
        int num = accountDao.updateAccount(account);
        if (num > 0){
            System.out.println("成功修改了"+num+"条数据！");
        }
        else{
            System.out.println("修改操作执行失败！");
        }
    }

    @Test
    public void deleteAccountTest(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountDao accountDao = applicationContext.getBean("accountDao",AccountDao.class);

        int num = accountDao.deleteAccount(1);
        if (num > 0){
            System.out.println("成功删除了"+num+"条数据！");
        }
        else{
            System.out.println("删除操作执行失败！");
        }
    }

    @Test
    public void findAccountByIdTest(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountDao accountDao = applicationContext.getBean("accountDao", AccountDao.class);
        Account account = accountDao.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void findAllAccountTest(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountDao accountDao = applicationContext.getBean("accountDao", AccountDao.class);
        List<Account> accountList = accountDao.findAllAccount();
        for (Account account: accountList){
            System.out.println(account);
        }
    }
}
