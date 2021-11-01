package com.wust.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * servlet生命周期：
 * 1、构造器
 * 2、init
 * 3、service
 * 4、destroy
 */
public class HelloServlet extends HttpServlet {
    public HelloServlet() {
        System.out.println("HelloServlet()");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("init()");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        String name = servletContext.getInitParameter("name");
        System.out.println(name);
        PrintWriter writer = resp.getWriter();
        writer.println("hello,servlet");
        //获取ServletConfig
        ServletConfig servletConfig = getServletConfig();
        //1、获取当前servlet的别名
        String servletName = servletConfig.getServletName();
        System.out.println(servletName);
        //2、获取当前servlet的初始化参数
        String job = servletConfig.getInitParameter("job");
        System.out.println(job);
        //3、获取ServletContext对象
        ServletContext context = servletConfig.getServletContext();
        System.out.println(context);

    }

    @Override
    public void destroy() {
        System.out.println("destroy()");
    }
}
