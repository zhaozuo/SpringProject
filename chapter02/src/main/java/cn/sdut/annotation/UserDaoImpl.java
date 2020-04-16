package cn.sdut.annotation;

import org.springframework.stereotype.Repository;

@Repository("userDao")//相当于<bean id="userDao" class="cn.sdut.annotation.UserDaoImpl" />
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("userDao...save...");
    }
}
