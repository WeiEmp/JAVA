package cn.hbzd.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @description:
 * @author: CodeEmp
 * @time: 2020/12/24 13:15
 */
@Controller
public class LoginController {
//    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map,
                        HttpSession session) {
        System.out.println(username + password);
        if(!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)) {
            session.setAttribute("user", username);
            return "redirect:/main";
        } else {
            System.out.println("失败过");
            map.put("msg", "错误");
            return "login";
        }
    }
}
