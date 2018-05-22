package com.yiran2.entity2.iO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 字符编码问题
 *
 *  编码表:
 *  		编码表即字符与存储数据的对应关系表，每一个字符都对应一个数字。
 *  		字符 = 字节 + 编码表
 *
 *  转换的构造方法当中:
 *  		public Output StreamWriter(OutputStream out, String charsetName)
 *  		public Input StreamReader(InputStream in, String charsetName)
 *  默认都会使用GBK码表,也可以自己指定编码表
 *
 *  乱码:
 *  		用一个A编码表将字符转成字节,又用B编码表与将字节转回字符,两个码表对应的关系不同,查到了不相同的结果
 *
 *  保证不乱码的方式:编码与解码保持相同.
 *  中后期,所有的码表均为UTF-8
 *
 *      1、ASCII：一个字节中的7位表示。对应的字节都是正数：0-xxxxxxx。
 *
 *      2、ISO-8859-1：拉丁latin码表，用一个字节8位表示。1-xxxxxxx：负数。
 *
 *      3、GB2312：简体中文码表。包含6000-7000中文和符号。用两个字节表示。
 *   两个字节第一个字节是负数，第二个字节可能是正数。
 *          GBK：目前最常用的中文码表，2万的中文和符号。用两个字节表示，其中的一部分文字，
 *       第一个字节开头是1，第二字节开头是0。
 *          Big5
 *          GB18030：最新的中文码表，目前还没有正式使用。
 *
 *      4、Unicode：国际标准码表：无论是什么文字，都用两个字节存储。
 *   Java中的char类型用的就是这个码表：char c = 'a';占两个字节。
 *
 *      5、UTF-8：基于Unicode，一个字节就可以存储数据，不要用两个字节存储，
 *   而且这个码表更加的标准化，中文一般使用3个字节表示。
 *
 *  能识别中文的码表：GB2312、GBK、Unicode、UTF-8
 * */

public class CharsetDemo1 {
    public static void main(String[] args){
        String path = "staticFile\\编码测试.txt";

        //使用gbk的方式将字符输出到文件中,文件使用utf-8观看会乱码,使用gbk观看时正常的
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos,"gbk");
            osw.write("我卢本伟，没有开挂！\r\n");
            osw.write("这些操作，都是我亲手打出来的操作");
            osw.close();
        } catch (Exception e){
            System.out.println("路径有误");
            e.printStackTrace();
        }

        // 使用gbk格式写出到文件中，使用utf-8来读入，得到的是乱码，必须要是同一种编码格式
        // 这里和读取会将2字节的汉字断开的字节流不同，是编码冲突的问题。
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis,"utf-8");
            int len = -1;
            char[] chs = new char[1024];
            while ((len = isr.read(chs)) != -1){
                System.out.print(new String(chs, 0, len));
            }
        } catch (Exception e){
            System.out.println("路径有误");
            e.printStackTrace();
        }
    }
}
