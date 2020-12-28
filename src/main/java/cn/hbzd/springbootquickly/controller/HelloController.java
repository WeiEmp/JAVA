package cn.hbzd.springbootquickly.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: CodeEmp
 * @time: 2020/12/22 16:05
 */
/* 这个类的所有方法返回的数据直接写给浏览器（如果是对象转为json数据）*/
/* @ResponseBody
@Controller */
@RestController
public class HelloController {
    @Value("${person.last-name}")
    private String name;

    @RequestMapping("/hello")
    public String hello() {
        return "hello wordl quickly";
    }

    @RequestMapping("/sayHello")
    public String sayHello() {
        return "Hello " + name;
    }
}
