package cn.hbzd.springboot.config;

import cn.hbzd.springboot.component.LoginHandlerInterceptor;
import cn.hbzd.springboot.component.MyLocaleResolver;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

/**
 * @description:
 * @author: CodeEmp
 * @time: 2020/12/24 10:53
 */

//使用WebMvcConfigurerAdapter可以来扩展SpringMVC的功能
//@EnableWebMvc 不要接管SpringMVC
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/hbzd").setViewName("index");
//    }



    // 所有的WebMvcConfigurer组件都会一起起作用
    @Bean //将组件注册到容器
    public WebMvcConfigurer webMvcConfigurer() {
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index").setViewName("login");
                registry.addViewController("/main").setViewName("dashboard");
            }

//            注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //静态资源： *.css  *.js
//                SpringBoot已经做好了静态资源映射
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns(Arrays.asList("/index", "/", "/user/login", "/asserts/**", "/webjars/bootstrap/4.5.3/**"));
            }

//            @Override
//            public void addResourceHandlers(ResourceHandlerRegistry registry) {
//
//                //需要配置1：----------- 需要告知系统，这是要被当成静态文件的！
//                //第一个方法设置访问路径前缀，第二个方法设置资源路径
//                registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//            }

        };
        return webMvcConfigurer;
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }


}
