package cn.yiran.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "ImagesServlet",value = "/ImagesServlet")
public class ImagesServlet extends HttpServlet {
    private ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.config = config;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 随机字符串
        String randomString = getRandomString();

        // 将字符串存入session中
        HttpSession session = request.getSession();
        session.setAttribute("code",randomString);

        // 随机颜色 背景色
        Color c = getRandomColor();

        // 反色 用于前景色
        Color reverse = getReverColor(c);

        // 创建一个彩色图片，根据BufferedImage(长度，宽度，生成类型)
        BufferedImage bi = new BufferedImage(100,30,BufferedImage.TYPE_INT_RGB);
        // 获取绘图对象，画笔
        Graphics g = bi.getGraphics();
        // 设置字体
        g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        // 设置字体的颜色
        g.setColor(reverse);
        // 绘制背景
        g.fillRect(0,0,100,30);
        // 设置背景颜色
        g.setColor(c);
        // 绘制随机数字
        g.drawString(randomString,18,20);

        // 加噪点
        for (int i = 0,n = random.nextInt(100);i < n;i++){
            g.drawRect(random.nextInt(100),random.nextInt(30),1,1);
        }

        // 输出图片
        ImageIO.write(bi,"jpg",response.getOutputStream());
    }

    // 1.定义一个随机字符串
    public static final char[] chars = {'1','2','3','4','5','6','7','8','9','0',
            'A','B','C','D','E','F','G','H','I','J',
            'K','L','M','N','O','P','Q','R','S','T',
            'U','V','W','X','Y','Z'};

    // 2.定义生成随机数
    private static Random random = new Random();

    // 3.获取随机4个字符
    public static String getRandomString(){
        // 使用可变字符串进行拼接
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < 4;i++){
            // 每次获取一个随机的字符
            sb.append(chars[random.nextInt(chars.length)]);
        }
        // 转成String 返回
        return sb.toString();
    }

    // 4.工具方法 -- 获取一个颜色，分别用于前景色(文字颜色)和背景色
    public static Color getRandomColor(){
        return new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
    }

    // 获取随机颜色的反色
    public static Color getReverColor(Color c){
        return new Color(255-c.getRed(),255-c.getGreen(),255-c.getBlue());
    }
}