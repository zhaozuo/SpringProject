package cn.sdut.controller;

import cn.sdut.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString方法执行了...");
        //模拟从数据库中获取User对象
        User user = new User();
        user.setUsername("美美");
        user.setPassword("123");
        user.setAge(22);
        model.addAttribute("user", user);
        return "success";
    }

    @RequestMapping("/testVoid")
    public void testVoid(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        System.out.println("testVoid方法执行了...");
        // 请求转发，此时不能使用视图解析器
        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);

        // 重定向，不能访问WEB-INF的内容
        // response.sendRedirect(request.getContextPath()+"/index.jsp");

        // 使用输出流，不推荐
        // response.setContentType("text/html;charset=UTF-8");
        // response.getWriter().print("你好");
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        System.out.println("testModelAndView方法执行了...");
        ModelAndView modelAndView = new ModelAndView();
        //模拟从数据库中获取User对象
        User user = new User();
        user.setUsername("小风");
        user.setPassword("456");
        user.setAge(30);
        // 默认把对象存入request域
        modelAndView.addObject("user", user);
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("testForwardOrRedirect方法执行了...");
        // 请求转发，此时不能使用视图解析器
        // return "forward:/WEB-INF/pages/success.jsp";
        // 重定向，不能访问WEB-INF的内容
        return "redirect:/index.jsp";
    }

    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testAjax方法执行了...");
        System.out.println(user);
        // 模拟查询数据库
        user.setUsername("haha");
        user.setPassword("456");
        user.setAge(13);
        return user;
    }

    @RequestMapping(value = "/ajax")
    public @ResponseBody Map<String, String> sayHello(@RequestParam String inputName){
        System.out.println("sayHello执行了....");
        System.out.println("name是"+inputName);

        String helloSentence = "你好，" + inputName + "同学！";
        Map<String, String> result= new HashMap<>();
        result.put("hello",helloSentence);
        return result;
    }
}
