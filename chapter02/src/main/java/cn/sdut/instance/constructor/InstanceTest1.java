package cn.sdut.instance.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InstanceTest1 {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("beans1.xml");
        Bean1 bean1 = (Bean1) applicationContext.getBean("bean1");
        System.out.println(bean1);
    }
}
