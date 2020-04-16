package cn.sdut.ioc;

public class UserServiceImpl implements UserService {
    //声明UserDao属性
    private UserDao userDao;
    //添加setter属性，用于实现依赖注入
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void say() {
        this.userDao.say();
        System.out.println("userService say hello world!");
    }
}
