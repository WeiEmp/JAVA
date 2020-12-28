package cn.hbzd.springboot.filter;


import javax.servlet.*;
import java.io.IOException;

/**
 * @description:
 * @author: CodeEmp
 * @time: 2020/12/25 14:28
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter process..");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
