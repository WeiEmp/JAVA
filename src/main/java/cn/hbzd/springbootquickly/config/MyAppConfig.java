package cn.hbzd.springbootquickly.config;

import cn.hbzd.springbootquickly.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: CodeEmp
 * @time: 2020/12/23 10:31
 */
/*
* @Configuration：指明当前类是一个配置类 替代之前的spring配置文件
* 在配置文件中用<bean></bean>标签添加组件 这里使用方法 + 注解 */
@Configuration
public class MyAppConfig {
    //将方法的返回值添加到容器中 容器中默认id为方法名
    @Bean
    public HelloService helloService() {
        System.out.println("fjwi");
        return new HelloService();
    }

}
