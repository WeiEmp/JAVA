package cn.hbzd.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: CodeEmp
 * @time: 2020/12/25 16:38
 */
@Controller
public class HelloController {
    @RequestMapping("hello")
    public String hello(Model model) {
        model.addAttribute("msg", "您好");
        return "success";
    }
}
