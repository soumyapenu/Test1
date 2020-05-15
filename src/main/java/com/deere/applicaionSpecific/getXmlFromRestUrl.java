package com.deere.applicaionSpecific;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.testng.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import static com.deere.global.GlobalThings.*;

import com.deere.global.CommonFunctions;



public class getXmlFromRestUrl {
          
          private static File file = null;
              private static File db2ResponseFile = null;
              
             // public static String Test_url1 =  "http://qualapp101.tal.deere.com/moci/services/jdsc/basecode?baseCode=1927E &currency=AUD";
             // public static String Test_url2 =  "https://mamosservices.deere.com/api/deviceStateReports?terminalId=397257,144512&fromDate=2016-04-08T21:31:05.000Z&toDate=2016-04-11T02:04:03.000Z";
              public static String method_name = "GET";
              public static String xml = null;
              public String xml1 = null ;
              public static Integer Count = 0, nextPageCount = 0, previousPageCount = 0, node_Cnt_xml = 0, node_Cnt_xml1 = 0;
              public static String Result, Actual_Result = null;
              public static NodeList nList, nList1 = null;
              public static String TagName1 = "deviceStateReport", TagName2 = "link";
              public static String  ServiceName = "MultipleMachines", ServiceType = "Terminal";
          
    public void executeMamosServiceWithRest(String urlBasecodeOrAttachment , String encryCredentials , String xmlFileFromApp) throws ProtocolException, IOException, SAXException, ParserConfigurationException, TransformerException {
        URL url = get_url(urlBasecodeOrAttachment);
        HttpURLConnection conn = rest_Authentication(url , encryCredentials);
        get_Response_Code(conn, "FirstXML" , xmlFileFromApp);
        getXmlFromRestUrl compare = new getXmlFromRestUrl();
         //read_XML(System.getProperty("user.dir")+"\\Drivers\\"+xmlFileFromApp+".xml", System.getProperty("user.dir")+"\\Drivers\\PostMan"+xmlFileFromApp+"_Response.xml");
        File f1 = new File(System.getProperty("user.dir")+"\\Drivers\\"+xmlFileFromApp+".xml");
         File f2 = new File(System.getProperty("user.dir")+"\\Drivers\\PostMan"+xmlFileFromApp+"_Response.xml");          
         Scanner sc = new Scanner(f1);
         Scanner sc1 = new Scanner(f2);
         Assert.assertEquals(compare.compareFiles(sc,sc1), true, "Xml generated from rest url and from application having difference");
    }
    
    public static URL get_url(String Test_URL) throws MalformedURLException {
        URL url = new URL(Test_URL);
        return url;
    }
    
    public static HttpURLConnection rest_Authentication(URL url , String encryCredentials) throws IOException, ProtocolException {
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        //byte[] authEncBytes = Base64.encodeBase64(encryCredentials.getBytes());
        String authStringEnc = new String(encryCredentials);
        set_Conn_Property(conn, authStringEnc);
        return conn;
    }
    
    public static void get_Response_Code(HttpURLConnection conn, String xml_Value , String xmlFileFromApp) throws IOException {
        if (conn.getResponseCode() == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine+"\n");
            }
            in.close();
            xml = response.toString();
            if (xml_Value.equals("FirstXML")) {
               file = new File(driversPath+"\\PostMan"+xmlFileFromApp+"_Response.xml");
                
              
            }else {
                file = new File("C://XML Comparision/responseFile/DB2_Response.xml");
            }
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(xml);
            fileWriter.flush();
            fileWriter.close();
        }
    }
    
    public static void set_Conn_Property(HttpURLConnection conn, String authStringEnc) throws ProtocolException {
        conn.setRequestProperty("Authorization", "Basic "+authStringEnc);
        conn.setRequestMethod(method_name);
        if (ServiceName == "MultipleMachines" && ServiceType == "Terminal") {
            conn.setRequestProperty("Accept", "application/xml");
            conn.setRequestProperty("Accept-Language", "en-AU");
            conn.setRequestProperty("hanaEnabled", "true");

        }else if (ServiceName == "MultipleMachines" && ServiceType == "Machine") {
            conn.setRequestProperty("Accept", "application/xml");
            conn.setRequestProperty("Accept-Language", "en-AU");
            conn.setRequestProperty("hanaEnabled", "true");
        }else {
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Accept-Language", "en-AU");
            conn.setRequestProperty("hanaEnabled", "true");
        }
    }
    
    public boolean compareFiles (Scanner file1, Scanner file2) {
        String lineA ;
        String lineB ;
        boolean diff = false;
        int x = 1;

            while (file1.hasNextLine() && file2.hasNextLine()) {
                lineA = file1.nextLine();
                lineB = file2.nextLine();

                if (!lineA.equals(lineB)) {
                    System.out.print("Diff " + x++ + "\r\n");
                    System.out.print("< " + lineA + "\r\n");
                    System.out.print("> " + lineB + "\r\n");
                    diff=true;
                }
            }
            
            if(diff==false)
                   return true;
            else
                   return false;

    }
    
    
   /* private static String read_XML(String file1 , String file2) throws SAXException, IOException, ParserConfigurationException, TransformerException {
        db2ResponseFile = new File(file1);
        node_Cnt_xml = nodeCount();
        nList = nodeList(TagName1);

        db2ResponseFile = new File(file2);
        node_Cnt_xml1 = nodeCount();
        nList1 = nodeList(TagName1);

        if (node_Cnt_xml.equals(node_Cnt_xml1)){
            System.out.println("Both the xmls have Equal Number of Nodes");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Time : " + eElement.getElementsByTagName("time").item(0).getTextContent());
                    String TS = eElement.getElementsByTagName("time").item(0).getTextContent();
                    String MachineIDString = eElement.getElementsByTagName("uri").item(0).getTextContent();
                    String[] MachineID = MachineIDString.split("/", 6);
                    for (int temp1 = 0; temp1 < nList1.getLength(); temp1++){
                        Node nNode1 = nList1.item(temp1);
                        if (nNode1.getNodeType() == Node.ELEMENT_NODE) {
                            Element eElement1 = (Element) nNode1;
                            String TS1 = eElement1.getElementsByTagName("time").item(0).getTextContent();
                            String MachineIDString1 = eElement1.getElementsByTagName("uri").item(0).getTextContent();
                            String[] MachineID1 = MachineIDString1.split("/", 6);
                            if (MachineID[5].equals(MachineID1[5])) {
                                if(TS.equals(TS1)){
                                    String lat = eElement.getElementsByTagName("lat").item(0).getTextContent();
                                    String lon = eElement.getElementsByTagName("lon").item(0).getTextContent();
                                    String lat1 = eElement.getElementsByTagName("lat").item(0).getTextContent();
                                    String lon1 = eElement.getElementsByTagName("lon").item(0).getTextContent();
                                    if(lat == lat1 && lon == lon1){
                                        Count = Count+1;
                                        System.out.println("Response as Expected"+Count);
                                    }

                                }

                            }
                        }

                    }

                }
            }
        }
        System.out.println("Nodes are not equal");
        if(Count.equals(node_Cnt_xml1)){
            Result = "Response of the XML is as Expected";
        }else {
            Result = "Response of the XML is not as Expected";
        }
        return Result;
    }*/
    
    public static Integer nodeCount() throws ParserConfigurationException, IOException, SAXException {
        nList = nodeList(TagName1);
        System.out.println(nList.getLength());
        return nList.getLength();
    }
    
    public static NodeList nodeList(String TagName) throws ParserConfigurationException, SAXException, IOException {
        String DB2FileName = db2ResponseFile.toString();
        File db2InputFile = new File(DB2FileName);
        DocumentBuilderFactory db2DbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder db2DBuilder = db2DbFactory.newDocumentBuilder();
        Document doc1 = db2DBuilder.parse(db2InputFile);
        doc1.getDocumentElement().normalize();
        return doc1.getElementsByTagName(TagName);
    }

}
