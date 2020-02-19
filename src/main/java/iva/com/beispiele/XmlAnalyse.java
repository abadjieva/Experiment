package iva.com.beispiele;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlAnalyse {


public static void main (String [] arg){
	
	XmlAnalyse analyse = new XmlAnalyse();
	analyse.myAnalise();
	analyse.myStream();
	
}

private void myAnalise(){
	String file = "Dokumente\\file.xml"; 
	try{
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	DocumentBuilder builder = factory.newDocumentBuilder();
	Document doc = builder.parse(file);
	
	XPathFactory fact = XPathFactory.newInstance();
	XPath xpath= fact.newXPath();
	NodeList nodes = (NodeList)xpath.evaluate("//Customer", doc, XPathConstants.NODESET );
	for(int i=0;i<nodes.getLength(); i++){
		Node node = nodes.item(i);
		if(node.getNodeType() == Node.ELEMENT_NODE){
			Element elem = (Element)node;
			System.out.println(elem.getNodeName());
			System.out.println(elem.getAttribute("ID"));
			System.out.println(elem.getElementsByTagName("name").item(0).getTextContent());
			System.out.println(elem.getElementsByTagName("age").item(0).getTextContent());
			System.out.println("");
		}
	}
	
	
	
	
	
	}catch(Exception e){
		
	}
}
 
void myStream(){

	String[] arr = {"All", "Beta"};
	
	Stream<String> stream1 = Arrays.stream(arr);
	
	List<String> listeMy = Arrays.asList("Iva","Elen", "Olga", "Olga");
	Stream<String> stream = listeMy.stream();
	Predicate<String> predicate = (p)->p.length()>3;
	Function<String,String>function = (p) -> { String b=p.concat("_>3"); return b; };
	Consumer<String> consumer = (p) -> System.out.println(p);

	stream.distinct().filter(predicate).map(function).forEach(consumer);
	
	
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

}