package cn.sdut;

import cn.sdut.dao.AccountDao;
import cn.sdut.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    public void findAllTest() throws IOException {
        // 1.读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 2.创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 3.使用SqlSessionFactory创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 4.使用SqlSession创建Dao接口的代理对象
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        // 5.执行方法
        List<Account> accounts = accountDao.findAll();
        for (Account account: accounts){
            System.out.println(account);
        }
        // 6.释放连接
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void findAccountBuyIdTest() throws IOException {
        try(InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")) {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
                AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
                System.out.println(accountDao.findAccountById(1));
            }
        }
    }

    @Test
    public void addAccountTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        Account account = new Account();
        account.setUsername("test");
        account.setBalance(500.0);
        int num;
        try {
            num = accountDao.addAccount(account);
            sqlSession.commit();
            System.out.println("成功插入"+num+"条数据");
            System.out.println("Account id:"+account.getId());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("插入数据失败");
        }
        sqlSession.close();
    }

    @Test
    public void findAccountByNameTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        List<Account> accounts = accountDao.findAccountByName("o");
        for (Account account: accounts){
            System.out.println(account);
        }
        sqlSession.close();
    }

    @Test
    public void findTotalTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        System.out.println(accountDao.findTotal());
        sqlSession.close();
    }
}
