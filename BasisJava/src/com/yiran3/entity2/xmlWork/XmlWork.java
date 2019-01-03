package com.yiran3.entity2.xmlWork;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class XmlWork {
    public static void main(String[] args) {
        File file = new File("abc.xml");
        createFlightSegmentDoc(file);
        System.out.println("成功");
    }

    private static Document createFlightSegmentDoc(File file){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Document FlightSegDoc = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            FlightSegDoc = db.newDocument();
            FlightSegDoc.setXmlStandalone(true);
            // OTA_AirLowFareSearchRQ 根节点
            Element rootElement = FlightSegDoc.createElement("OTA_AirLowFareSearchRQ");
            FlightSegDoc.appendChild(rootElement);

            // OriginDestinationInformation
            Element OriginDestinationInformation1 = FlightSegDoc.createElement("OriginDestinationInformation");
            // DepartureDateTime
            Element DepartureDateTime1 = FlightSegDoc.createElement("DepartureDateTime");
            Date date = new Date();
            String nowDate = dateFormat.format(date).replace(" ", "T");
            DepartureDateTime1.appendChild(FlightSegDoc.createTextNode(nowDate));
            OriginDestinationInformation1.appendChild(DepartureDateTime1);
            // OriginLocation
            Element OriginLocation1 = FlightSegDoc.createElement("OriginLocation");
            OriginLocation1.setAttribute("CodeContext","IATA");
            OriginLocation1.setAttribute("LocationCode","PEK");
            OriginDestinationInformation1.appendChild(OriginLocation1);
            // DestinationLocation
            Element DestinationLocation1 = FlightSegDoc.createElement("DestinationLocation");
            DestinationLocation1.setAttribute("CodeContext","IATA");
            DestinationLocation1.setAttribute("LocationCode","HAK");
            OriginDestinationInformation1.appendChild(DestinationLocation1);
            // 加入到根节点
            rootElement.appendChild(OriginDestinationInformation1);

            // OriginDestinationInformation
            Element OriginDestinationInformation2 = FlightSegDoc.createElement("OriginDestinationInformation");
            // DepartureDateTime
            Element DepartureDateTime2 = FlightSegDoc.createElement("DepartureDateTime");
            String str = addHour(nowDate, 3, (int)(0.45 * 60));
            DepartureDateTime2.appendChild(FlightSegDoc.createTextNode(str));
            OriginDestinationInformation2.appendChild(DepartureDateTime2);
            // OriginLocation
            Element OriginLocation2 = FlightSegDoc.createElement("OriginLocation");
            OriginLocation2.setAttribute("CodeContext","IATA");
            OriginLocation2.setAttribute("LocationCode","HAK");
            OriginDestinationInformation2.appendChild(OriginLocation2);
            // DestinationLocation
            Element DestinationLocation2 = FlightSegDoc.createElement("DestinationLocation");
            DestinationLocation2.setAttribute("CodeContext","IATA");
            DestinationLocation2.setAttribute("LocationCode","PEK");
            OriginDestinationInformation2.appendChild(DestinationLocation2);
            // 加入到根节点
            rootElement.appendChild(OriginDestinationInformation2);

            // SpecificFlightInfo
            Element SpecificFlightInfo = FlightSegDoc.createElement("SpecificFlightInfo");
            Element BookingClassPref = FlightSegDoc.createElement("BookingClassPref");
            BookingClassPref.setAttribute("ResBookDesigCode","RT");
            SpecificFlightInfo.appendChild(BookingClassPref);
            rootElement.appendChild(SpecificFlightInfo);

            // TravelPreferences
            Element TravelPreferences = FlightSegDoc.createElement("TravelPreferences");
            TravelPreferences.setAttribute("ETicketDesired","true");
            rootElement.appendChild(TravelPreferences);

            // TravelerInfoSummary
            Element TravelerInfoSummary = FlightSegDoc.createElement("TravelerInfoSummary");
            Element SeatsRequested = FlightSegDoc.createElement("SeatsRequested");
            SeatsRequested.setAttribute("infantsOnLaps","true");
            SeatsRequested.appendChild(FlightSegDoc.createTextNode("0"));
            TravelerInfoSummary.appendChild(SeatsRequested);
            Element AirTravelerAvail = FlightSegDoc.createElement("AirTravelerAvail");
            Element PassengerTypeQuantity = FlightSegDoc.createElement("PassengerTypeQuantity");
            PassengerTypeQuantity.setAttribute("Code","ADT");
            PassengerTypeQuantity.setAttribute("Quantity","1");
            AirTravelerAvail.appendChild(PassengerTypeQuantity);
            Element PassengerTypeQuantity2 = FlightSegDoc.createElement("PassengerTypeQuantity");
            PassengerTypeQuantity2.setAttribute("Code","CHD");
            PassengerTypeQuantity2.setAttribute("Quantity","1");
            AirTravelerAvail.appendChild(PassengerTypeQuantity2);
            TravelerInfoSummary.appendChild(AirTravelerAvail);
            rootElement.appendChild(TravelerInfoSummary);

            TransformerFactory tff= TransformerFactory.newInstance();
            Transformer tf = tff.newTransformer();
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            tf.transform(new DOMSource(FlightSegDoc), new StreamResult(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return FlightSegDoc;
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
}
