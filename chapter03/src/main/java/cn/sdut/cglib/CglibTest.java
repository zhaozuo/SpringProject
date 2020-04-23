package cn.sdut.cglib;

public class CglibTest {
    public static void main(String[] args) {
//        CglibProxy cglibProxy = new CglibProxy();
        CGLIB cglib = new CGLIB();
        UserDao userDao = new UserDao();
//        UserDao userDao1 = (UserDao) cglibProxy.createProxy(userDao);
        UserDao userDao2 = (UserDao) cglib.createProxy(userDao);

        userDao2.addUser();
        userDao2.deleteUser();
    }
}
