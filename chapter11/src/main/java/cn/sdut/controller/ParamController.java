package cn.sdut.controller;

import cn.sdut.domain.Account;
import cn.sdut.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
public class ParamController {
    @RequestMapping("/testParams")
    public String testParams(HttpServletRequest request){
        String username = request.getParameter("username");
        System.out.println(username);
        return "success";
    }

    @RequestMapping("/saveAccount")
    public String saveAccount(Account account){
        System.out.println(account);
        return "success";
    }

    @RequestMapping("/saveUser")
    public String saveUser(User user){
        System.out.println(user);
        return "success";
    }
}
