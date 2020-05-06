package cn.sdut.controller;

import cn.sdut.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.time.LocalDate;
import java.util.Map;

@Controller
@RequestMapping("/annotation")
@SessionAttributes({"msg"})
public class AnnotationController {
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam("name") String username){
        System.out.println(username);
        return "success";
    }

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println(body);
        return "success";
    }

    @RequestMapping("/testPathVariable/{uid}")
    public String testPathVariable(@PathVariable("uid") String id){
        System.out.println(id);
        return "success";
    }

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc") User user){
        System.out.println(user);
        return "success";
    }

    /**
     * 该方法先执行，模拟查询数据库返回指定User对象
     * @param username
     * @return
     */
    @ModelAttribute
    public void showUser(String username, Map<String, User> map){
        User user = new User();
        user.setUsername(username);
        user.setAge(20);
        user.setDate(LocalDate.now());
        map.put("abc", user);
    }

    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model){
        // 此时在request域中已经有msg对象了
        model.addAttribute("msg","美美");
        return "success";
    }

    @RequestMapping("/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap){
        System.out.println(modelMap.get("msg"));
        return "success";
    }

    @RequestMapping("/delSessionAttributes")
    public String delSessionAttributes(SessionStatus status){
        status.setComplete();
        return "success";
    }
}
