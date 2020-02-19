package iva.com.beispiele;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

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
import org.xml.sax.InputSource;

public class ExpEnum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExpEnum obj = new ExpEnum(); 
		obj.enumExp();
		obj.parseExp();
		obj.fileExp();

	}
	
	void enumExp(){
		Status stat = Status.STOP;
		System.out.println(stat.toString());
		
		for(Status st :Status.values()){
			System.out.println(st.toString() + " "+st.getTemp());
		}
		
		
	}
	
	void parseExp(){
		try {
			System.out.println("------parseExp");
			DocumentBuilder builder;
			DocumentBuilderFactory docFactory = DocumentBuilderFactory
					.newInstance();

			// StringReader reader = new StringReader(xml);
			File file = new File("Dokumente\\file1.xml");
		//FileInputStream im = new FileInputStream(file);
			FileReader reader = new FileReader(file);
			InputSource source = new InputSource(reader);

			builder = docFactory.newDocumentBuilder();
			Document doc = builder.parse(source);
			
			
			XPathFactory fac = XPathFactory.newInstance();
			XPath xpath = fac.newXPath();

			
			// -----
			NodeList ndl= (NodeList)xpath.evaluate("//topic",doc, XPathConstants.NODESET);
			for(int i=0; i<ndl.getLength(); i++){
				Node node = ndl.item(i);
				Element elem = (Element)node;
				System.out.println("NodeName= "+elem.getNodeName());
				System.out.println("ElementArg= "+elem.getAttribute("name"));
					
				//System.out.println(elem.getElementsByTagName("url").item(0).getTextContent());
				NodeList nd2= elem.getElementsByTagName("url");
				for(int j=0;j<nd2.getLength(); j++){
					Node node1 = nd2.item(j);
					Element elem1 = (Element)node1;
					System.out.println(elem1.getTextContent());
					
				}
				
				NodeList nd3= elem.getElementsByTagName("base");
				for(int jj=0;jj<nd3.getLength(); jj++){
					Node node3 = nd3.item(jj);
					Element elem3 = (Element)node3;
					System.out.println(elem3.getTextContent());
					
				}
				
				//System.out.println(elem.getElementsByTagName("age").item(0).getTextContent());
				

			}
			
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void fileExp(){
		System.out.println("---------------fileExpr");
		File file = new File("Dokumente\\file1.xml");
		System.out.println(file.getPath());
		System.out.println(file.getAbsolutePath());
		
		File fi = new File ("Dokumente");
		String[] liste = fi.list();
		for(String f :liste){
			System.out.print(f+" ");
		}
		System.out.println();
		File[] lisFile= fi.listFiles();
		for(File ff :lisFile){
			if(ff.isDirectory())
			System.out.print(ff.getName()+" ");
		}
		//////
		System.out.println("IVA -------------------------");
		try{
		byte[] b = {(byte)0xe1};
	    String s= new String(b, "UTF-8"); 
	    String s1= new String(b, "ISO-8859-1"); 
	    System.out.println("UTF...ISO "+s+" "+s1);
	    
	    String lit1 = "�\n";
	    byte[] lb= lit1.getBytes(lit1);
	    System.out.println(lb.toString());
	    ByteArrayOutputStream ba = new ByteArrayOutputStream();
	    ba.write(lb);
	    System.out.println(ba.toString());
	    
		}catch(Exception e){
		System.out.println("EXEPTION...");	
		}
	    
		String read;
		try(FileReader fr = new FileReader(file);){
		
		BufferedReader br = new BufferedReader(fr);
		while((read = br.readLine()) != null){
			System.out.println(read);
		}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		System.out.println("-------------------------");
		File out = new File("Dokumente\\mein.log.0");
		double \u03C0 = 3.141592653589793;
		String \u00d6\u00df = "\'1234\"";
		System.out.println("Zeichen : \u03C0="+\u03C0 + " Satz: \u00d6\u00df= "+ \u00d6\u00df);
		
		String temp= "abad\u03C0iva"+'\n'+"ßö&Ä"+"\n"+"\u00d6\u00df\u00fcerna"+0xc3b4+"\u00fb";
		byte[] bab = temp.getBytes();
		InputStreamReader isr;
		ByteArrayInputStream is = new ByteArrayInputStream(bab);
		try{
		isr = new InputStreamReader(is);
		
		File out1 = new File("Dokumente\\mein.log.0.1");
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		
		Collator col = Collator.getInstance(new Locale("GERMAN", "GERMANY"));
		String str1 = "aQueu";
		String str2 = "iva";
		int info =col.compare(str1, str2);
		System.out.println("Vergleich= "+info);
		
		String read1;
		try(BufferedReader br1 = new BufferedReader(isr); FileOutputStream fos = new FileOutputStream(out);){
			
			//1
			bo.write(bab);
			System.out.println("ByteArrayOutputStream: "+bo.toString());
			FileOutputStream fos1 = new FileOutputStream(out1);
			bo.writeTo(fos1);
			
			//2
			OutputStreamWriter os = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw = new BufferedWriter(os);
		    while((read1=br1.readLine())!=null){
			 System.out.println(read1);
			 bw.write(read1);
			 bw.write("\n");
		    }
		    bw.close();
		    
		    
		}catch(Exception e){
			
		}
}catch(Exception e){
			
		}
		
	}
	
	enum Status {
		STOP("Stopen"),START("Starten");
	
		String temp;
		
		Status(String temp){
			this.temp = temp;
		}

		public String getTemp() {
			return temp;
		}
		
	}

}
