package com.wust.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

public class ContextServlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        //ServletContext的作用
        //1、获取Context-Param
        String name = servletContext.getInitParameter("name");
        System.out.println(name);
        //2、获取web工程路径
        String contextPath = servletContext.getContextPath();
        System.out.println(contextPath);
        //3、获取web工程绝对路径
        String realPath = servletContext.getRealPath("/");
        System.out.println(realPath);
        //4、存取数据
        servletContext.setAttribute("username","李四");
        String username = (String) servletContext.getAttribute("username");
        System.out.println(username);
    }
}
