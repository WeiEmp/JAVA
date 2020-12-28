package cn.hbzd.springboot.config;

import cn.hbzd.springboot.filter.MyFilter;
import cn.hbzd.springboot.listener.MyListener;
import cn.hbzd.springboot.servlet.myServlet;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

/**
 * @description:
 * @author: CodeEmp
 * @time: 2020/12/25 14:10
 */
@Configuration
public class MyServerConfig {
    //注册三大组件
    @Bean
    public ServletRegistrationBean myServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new myServlet(), "/myServlet");
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean() {
        ServletListenerRegistrationBean<MyListener> myListenerServletListenerRegistrationBean = new ServletListenerRegistrationBean<>(new MyListener());
        return myListenerServletListenerRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/hello", "/myServlet"));
        return filterRegistrationBean;
    }

    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> embeddedServletContainerCustomizer() {
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                factory.setPort(1010);
            }

        };
    }


}
