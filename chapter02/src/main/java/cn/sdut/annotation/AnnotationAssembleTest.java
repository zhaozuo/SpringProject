package cn.sdut.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationAssembleTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("beans6.xml");
        UserController userController = (UserController) applicationContext.getBean("userController");
        userController.save();
    }
}
