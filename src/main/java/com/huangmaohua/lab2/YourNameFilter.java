package com.huangmaohua.lab2;

import jakarta.servlet.*;
import java.io.IOException;

public class YourNameFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        System.out.println("YourNameFilter--before chain!");
        chain.doFilter(servletRequest,servletResponse);
        System.out.println("YourNameFilter--after chain!");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
