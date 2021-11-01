package com.wust.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

public class DownloadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取要下载的文件
        String prefix = "/img/";
        String filename = "b站.png";
        //2、获取下载文件的文件类型
        ServletContext servletContext = getServletContext();
        String mimeType = servletContext.getMimeType(prefix + filename);
        System.out.println("下载的文件类型： " + mimeType);
        //3、告诉浏览器下载文件的类型
        resp.setContentType(mimeType);
        //4、告诉浏览器文件是附件，需要下载的；如果下载文件的名字是中文还需要进行URL编码
        //resp.setHeader("Content-Disposition","attachment;filename=" + file);
        //设置附件的格式是固定的，如下所示
        resp.setHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(filename,"utf-8"));
        //5、将要下载的文件内容回传给客户端
        InputStream resourceAsStream = servletContext.getResourceAsStream(prefix + filename);
        ServletOutputStream outputStream = resp.getOutputStream();
        IOUtils.copy(resourceAsStream,outputStream);
    }
}
