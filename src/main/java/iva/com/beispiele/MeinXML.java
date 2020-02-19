package iva.com.beispiele;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class MeinXML {

	Logger logg =Logger.getLogger(getClass().getName());

	public static void main(String[] args) {
		MeinXML mein = new MeinXML();
		mein.xmlTest();
	}

	public void xmlTest(){
	try{	
		File inputFile = new File("Dokumente\\file.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;

        dBuilder = dbFactory.newDocumentBuilder();

        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();

        XPath xPath =  XPathFactory.newInstance().newXPath();

        String expression = "//Customer";

        XPathExpression expr =  xPath.compile(expression);
        NodeList nodeList = (NodeList) expr.evaluate(
           doc, XPathConstants.NODESET);

        List<Customer> liste = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
        	Customer cust= new Customer();
           Node nNode = nodeList.item(i);
           
           logg.log(Level.INFO,"\nCurrent Element :" + nNode.getNodeName());
           
                 
           if (nNode.getNodeType() == Node.ELEMENT_NODE) {
              Element eElement = (Element) nNode;
              logg.log(Level.INFO,"ID: " + eElement.getAttribute("ID"));
              int id = Integer.parseInt(eElement.getAttribute("ID"));
              cust.setId(id);
              
              logg.log(Level.INFO, "First Name: " 
                 + eElement
                 .getElementsByTagName("name")
                 .item(0)
                 .getTextContent());
              cust.setName(eElement.getElementsByTagName("name").item(0)
                      .getTextContent());
              
              logg.log(Level.INFO, "Alter: " 
                      + eElement
                      .getElementsByTagName("age")
                      .item(0)
                      .getTextContent());
             
              int age = Integer.parseInt(eElement
                      .getElementsByTagName("age")
                      .item(0)
                      .getTextContent());
              cust.setAge(age);
              liste.add(cust);
           }
        }
        
    	
        logg.log(Level.INFO, "\nAus der Liste:");
        for(Customer c :liste){
        	logg.log(Level.INFO, "customer ID= " +c.getId()+ " " + c.getName());
        }
	
	}catch(Exception e){
		logg.log(Level.SEVERE, e.getMessage());
	}
}
}
