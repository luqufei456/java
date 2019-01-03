package com.yiran3.entity2.xmlWork;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XmlWork {
    public static void main(String[] args) {
        File file = new File("abc.xml");
        System.out.println(createFlightSegmentDoc(file).toString());
    }

    private static Document createFlightSegmentDoc(File file){
        Document FlightSegDoc = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            FlightSegDoc = db.newDocument();
            FlightSegDoc.setXmlStandalone(true);
            // FlightSegment 根节点
            Element rootElement = FlightSegDoc.createElement("FlightSegment");
            rootElement.setAttribute("ArrivalDateTime","2015-03-20T00:45:00");
            rootElement.setAttribute("DepartureDateTime","2015-03-19T22:00:00");
            rootElement.setAttribute("FlightNumber","7195");
            rootElement.setAttribute("InfoSource","Domestic");
            rootElement.setAttribute("StopQuantity","0");
            FlightSegDoc.appendChild(rootElement);
            // DepartureAirport
            Element DepAirportElement = FlightSegDoc.createElement("DepartureAirport");
            DepAirportElement.setAttribute("LocationCode","PEK");
            DepAirportElement.setAttribute("Terminal","T1");
            rootElement.appendChild(DepAirportElement);
            // ArrivalAirport
            Element ArrAirportElement = FlightSegDoc.createElement("ArrivalAirport");
            ArrAirportElement.setAttribute("LocationCode","FOC");
            ArrAirportElement.setAttribute("Terminal","--");
            rootElement.appendChild(ArrAirportElement);
            // OperatingAirline
            Element OperatingAirlineElement = FlightSegDoc.createElement("OperatingAirline");
            OperatingAirlineElement.setAttribute("Code","HU");
            rootElement.appendChild(OperatingAirlineElement);
            // Equipment
            Element EquipmentElement = FlightSegDoc.createElement("Equipment");
            EquipmentElement.setAttribute("AirEquipType","738");
            rootElement.appendChild(EquipmentElement);
            // MarketingAirline
            Element MarketingAirlineElement = FlightSegDoc.createElement("MarketingAirline");
            MarketingAirlineElement.setAttribute("Code","HU");
            rootElement.appendChild(MarketingAirlineElement);
            TransformerFactory tff= TransformerFactory.newInstance();
            Transformer tf=tff.newTransformer();
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            tf.transform(new DOMSource(FlightSegDoc), new StreamResult(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return FlightSegDoc;
    }
}
