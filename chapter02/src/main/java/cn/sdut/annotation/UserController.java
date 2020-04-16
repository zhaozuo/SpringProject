package cn.sdut.annotation;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller("userController")//相当于<bean id="userController" class="cn.sdut.annotation.UserController" />
public class UserController {
    @Resource(name = "userService")
    private UserService userService;

    /**
     * 用于autowire(自动装配)
     */
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void save(){
        this.userService.save();
        System.out.println("userController...save...");
    }
}
