package cn.sdut.jdk;

public class JdkTest {
    public static void main(String[] args) {
        JdkProxy jdkProxy = new JdkProxy();
        UserDaoImpl userDao = new UserDaoImpl();
        UserDao userDao1 = (UserDao) jdkProxy.createProxy(userDao);
        userDao1.addUser();
        userDao1.deleteUser();
    }
}
