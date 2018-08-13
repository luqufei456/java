package cn.yiran.web.utils;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class MailUtils {
    // 参数为，发送地址，接收地址，标题，内容
    public static void sendMail(String from,String to,String subject,String msgText){
        Properties props = new Properties();
        // 存放目标邮箱服务器的host
        props.put("mail.smtp.host","smtp.qq.com");
        // 开启debug
        props.put("mail.debug","true");
        // 开启授权，可以不输入密码，而是授权码
        props.put("mail.smtp.auth","true");
        // 存放目标邮箱服务器的端口号
        props.put("mail.smtp.port","587");

        Session session = Session.getInstance(props,null);
        // 取消debug
        session.setDebug(false);
        try {
            // 邮件信息
            MimeMessage msg = new MimeMessage(session);
            // 设置发送人
            msg.setFrom(new InternetAddress(from));
            // 创建接收人信息
            InternetAddress[] addresses = {new InternetAddress(to)};
            // 设置收件人
            msg.setRecipients(Message.RecipientType.TO,addresses);
            // 设置发送标题
            msg.setSubject(subject);
            // 设置发送时间
            msg.setSentDate(new Date());
            // 设置发送内容
            msg.setText(msgText);
            // 设置邮件信息，用户名，密码，相当于使用用户名密码登录，将该邮件发送
            // 因为开启了授权，所以这里可以用授权码
            Transport.send(msg,"1976967579","cbilrklpeleibbje");
        } catch (Exception e){
            System.out.println("出现异常了");
            e.printStackTrace();
        }
    }
}
