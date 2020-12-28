package cn.hbzd.springboot.controller;

import cn.hbzd.springboot.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: CodeEmp
 * @time: 2020/12/25 13:24
 */
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(UserNotExistException.class)
    public String handleException(UserNotExistException e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap();
        request.setAttribute("javax.servlet.error.status_code", 400);
        map.put("code", "user.notexist");
        map.put("message", e.getMessage());
        request.setAttribute("ext", map);
        //转发到/error
        return "forward:/error";
    }
}
