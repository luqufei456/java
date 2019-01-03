package com.yiran3.entity2.xmlWork;

import com.travelsky.ibe.client.pnr.SSResult;
import com.travelsky.ibe.client.pnr.SellSeat;

public class EbuildTest {
    public static void main(String[] args) throws Exception {
        /*生成预定类对象*/
        SellSeat SellSeatexample= new SellSeat();

        /*添加旅客姓名*/
        String name="IBETESTER/IBEGROUP";
        SellSeatexample.addAdult(name);

        /*添加旅客乘坐航段信息*/
        String airNo="CA1501";
        char fltClass='Y';
        String orgCity="PEK";
        String dstCity="SHA";
        String actionCode="NN";
        int tktNum=1;
        String departureTime="2009-12-26";
        SellSeatexample.addAirSeg(airNo,fltClass,orgCity,dstCity,actionCode,tktNum,departureTime);

        /*添加旅客乘坐返程航段信息*/
        String airNo2="CA1522";
        char fltClass2='Y';
        String orgCity2="SHA";
        String dstCity2="PEK";
        String actionCode2="NN";
        int tktNum2=1;
        String departureTime2="2009-12-29";
        SellSeatexample.addAirSeg(airNo2,fltClass2,orgCity2,dstCity2,actionCode2,tktNum2,departureTime2);

        /*添加旅客身份证信息*/
        String airline="CA";
        String idtype="NI";
        String id="123456789";
        SellSeatexample.addSSR_FOID(airline,idtype,id,name);

        /*添加旅客联系组信息*/
        String contactinfo="010-84669396";
        SellSeatexample.addContact(contactinfo);

        /*添加旅客出票时限*/
        String dateLimit="2009-12-25 12:00:00";
        SellSeatexample.setTimelimit(dateLimit);

        /*完成PNR必需信息输入，递交主机，生成PNR*/
        SSResult ssr=SellSeatexample.commit1();

        /*PNR结果*/
        System.out.println(ssr.getPnrno());
    }
}
