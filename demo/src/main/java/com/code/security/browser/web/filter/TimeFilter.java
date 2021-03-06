package com.code.security.browser.web.filter;


import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * com.code.web.filter
 *
 * @Auther: shenc
 * @Date: 2018/9/2 10:43
 * @Description:
 */
//@Component
public class TimeFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("time filter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("time filter start");
        long  start = new Date().getTime();
        chain.doFilter(request, response);
        System.out.println("time filter 耗时:"+ (new Date().getTime() - start));
        System.out.println("time filter finish");
    }

    @Override
    public void destroy() {
        System.out.println("time filter destroy");
    }
}
