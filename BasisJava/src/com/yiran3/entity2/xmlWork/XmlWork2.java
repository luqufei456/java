package com.yiran3.entity2.xmlWork;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XmlWork2 {
    public static void main(String[] args) {
        editDocment();
        try {
            InputStream in = new FileInputStream("abc.xml");
            BufferedInputStream buf = new BufferedInputStream(in);

            byte[] bytes = new byte[1024];
            StringBuffer stb = new StringBuffer();
            int len;
            while ((len = buf.read(bytes)) != -1){
                stb.append(new String(bytes, 0, len));
            }
            buf.close();
            in.close();
            System.out.println(stb);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String addHour(String date, int hour, int minute) throws ParseException {
        String str = date.replace("T", " ");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateTime = format.parse(str);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dateTime);
        rightNow.add(Calendar.MINUTE, minute);
        rightNow.add(Calendar.HOUR_OF_DAY, hour);
        return format.format(rightNow.getTime()).replace(" ", "T");
    }

    private static void editDocment() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SAXReader sr = new SAXReader();
        try {
            Document document = sr.read("abc.xml");
            Element root = document.getRootElement();
            Attribute DepartureDateTime = root.attribute("DepartureDateTime");
            Attribute ArrivalDateTime = root.attribute("ArrivalDateTime");
            Date date = new Date();
            String nowDate = dateFormat.format(date).replace(" ", "T");
            DepartureDateTime.setText(nowDate);
            String str = addHour(nowDate, 3, (int)(0.45 * 60));
            ArrivalDateTime.setText(str);
            Element Equipment = root.element("Equipment");
            Attribute AirEquipType = Equipment.attribute("AirEquipType");
            AirEquipType.setText("737");
            Writer osWrite = new OutputStreamWriter(new FileOutputStream(new File("abc.xml")));
            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding("UTF-8");
            XMLWriter writer = new XMLWriter(osWrite, format);
            writer.write(document);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
