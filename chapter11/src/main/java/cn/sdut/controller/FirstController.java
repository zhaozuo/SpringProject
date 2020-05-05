package cn.sdut.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class FirstController {

    @RequestMapping(path = "/hello")
    public String sayHello() {
        return "success";
    }
}
