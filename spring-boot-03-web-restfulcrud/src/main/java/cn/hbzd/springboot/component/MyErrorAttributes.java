package cn.hbzd.springboot.component;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @description:
 * @author: CodeEmp
 * @time: 2020/12/25 13:51
 */
//给容器中加入自己定义的错误属性
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);
        errorAttributes.put("company", "hbzd");
        Map<String,Object> ext = (Map<String, Object>) webRequest.getAttribute("ext", 0);
        errorAttributes.putAll(ext);
        return errorAttributes;
    }
}
