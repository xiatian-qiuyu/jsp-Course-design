package com.huangmaohua.lab2;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
//todo 1: map this filter for -1./lab2/validation.jsp and /lab2/welcome.jsp
@WebFilter(filterName = "LoginFilter",urlPatterns = {"/lab2/validation.jsp","/lab2/welcome.jsp"})
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //todo 2: System out print i am in LoginFilter--init()
        System.out.println("i am in LoginFilter--init()");
    }

    @Override
    public void destroy() {
        //todo 3: System out print i am in LoginFilter--destroy()
        System.out.println("i am in LoginFilter--destroy()!");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //todo 4: System out print i am in LoginFilter--doFilter()-- request before chain
        System.out.println("i am in LoginFilter--doFilter()-- request before chain!");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        //todo 6: if(session not new){
        if(req.getSession().getAttribute("username")!=null){
            //todo 7: forward to lab2/welcome.jsp
            String username = (String) req.getSession().getAttribute("username");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/lab2/welcome.jsp").forward(req,resp);
            //todo 8: else{redirect to login.jsp}
        }else{
            req.getRequestDispatcher("/lab2/login.jsp").forward(req,resp);
        }
        filterChain.doFilter(servletRequest,servletResponse);
        //todo 5: System out print i am in LoginFilter--destroy()-- response after chain
        System.out.println("i am in LoginFilter--doFilter()-- response after chain!");
    }


}