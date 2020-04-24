package cn.sdut.jdbc;

import cn.sdut.jdbc.AccountDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionTest {
    @Test
    public void xmlTest() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountDao accountDao = applicationContext.getBean("accountDao", AccountDao.class);
        accountDao.transfer("Jack", "Rose", 100.00);
        System.out.println("转账成功!");
    }

    @Test
    public void annotationTest() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext-annotation.xml");
        AccountDao accountDao = applicationContext.getBean("accountDao", AccountDao.class);
        accountDao.transfer("Rose", "Jack", 100.0);
        System.out.println("转账成功!");
    }
}
