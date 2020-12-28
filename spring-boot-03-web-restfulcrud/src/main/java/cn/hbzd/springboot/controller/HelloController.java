package cn.hbzd.springboot.controller;

import cn.hbzd.springboot.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author: CodeEmp
 * @time: 2020/12/24 10:51
 */
@Controller
public class HelloController {
    @RequestMapping("/")
    public String index() {
        return "login";
    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user) {
        if(user.equals("aaa")) {
            throw new UserNotExistException("wjeif");
        }
        return "";
    }
}
