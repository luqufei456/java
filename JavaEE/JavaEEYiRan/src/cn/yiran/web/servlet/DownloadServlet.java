package cn.yiran.web.servlet;

import sun.misc.BASE64Encoder;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "DownloadServlet",value = "/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    private ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        // 如果init方法中使用super.init(config)初始化之后，
        // 则service方法中可以直接使用this.getServletContext()获得ServletContext对象
        super.init(config);
        this.config = config;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置字符编码格式 utf-8与gbk为常用的中文字符集
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        // 1.获取下载的文件名称
        String fileName = request.getParameter("filename");
        // 防止乱码
        fileName = new String(fileName.getBytes("iso-8859-1"),"utf-8");

        // 2.获取资源在服务器上的路径
        // 2.1 获得context容器
        ServletContext context = config.getServletContext();
        // 2.2 使用getRealPath方法获取路径
        String dir = context.getRealPath("/file");

        // 3.告知浏览器，打开下载对话框
        // 以该文件的类型打开
        response.setContentType(context.getMimeType(fileName));

        //处理中文文件名乱码
        String header = request.getHeader("User-Agent");
        if(header.contains("Firefox")){
            //表示当前是火狐
            BASE64Encoder base64Encoder = new BASE64Encoder();
            fileName = "=?utf-8?B?"	+ base64Encoder.encode(fileName.getBytes("utf-8")) + "?=";

        }else{
            //谷歌
            fileName = URLEncoder.encode(fileName,"utf-8");
        }

        // filename= 默认文件名为文件名
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);

        // 4.使用IO将数据发送
        // 4.1 利用File构造方法获取文件对象
        File file = new File(dir,fileName);
        // 4.2 获取输入流
        FileInputStream fis = new FileInputStream(file);
        // 4.3 获取输出流
        ServletOutputStream sos = response.getOutputStream();
        // 4.4 缓冲区
        byte[] bytes = new byte[8192];
        int len = 0;
        while ((len = fis.read(bytes)) != -1){
            sos.write(bytes,0,len);
        }
        fis.close();
    }
}