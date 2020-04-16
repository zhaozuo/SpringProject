package cn.sdut.annotation;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource(name="userDao")//相当于<property name="userDao" ref="userDao" />
    private UserDao userDao;

    /**
     * 用于autowire(自动装配)
     */
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        this.userDao.save();
        System.out.println("userService...save...");
    }
}
