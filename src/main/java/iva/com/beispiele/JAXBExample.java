package iva.com.beispiele;

import java.io.File;
import java.io.FileReader;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.App;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class JAXBExample {

	public static void main(String[] args) {
		JAXBExample ex = new JAXBExample();

		App.main(null);

		Thread t = Thread.currentThread();
		System.out.println("Name = " + t.getName());
		System.out.println("Id = " + t.getId());
		System.out.println("Priorität = " + t.getPriority());
		System.out.println("Zustand = " + t.getState());

		int my = 5;
		int mmy = my++;
		System.out.println("my: " + my + ", mmy= " + mmy);

		int ia = 4;
		int j;

		j = ia-- - ia;
		System.out.println("ia: " + ia + ", j= " + j);

		ia = 4;
		j = ia-- - ia + ++ia - ia--;
		System.out.println("ia: " + ia + ", j= " + j);

		Random r = new Random();
		int min = 2;
		int max = 7;
		int range = (max - min) + 1;
		int zz = r.nextInt(range) + min;
		int zz1 = (int) (Math.random() * range) + min;
		System.out.println("RANDOM= " + zz);
		System.out.println("" + zz1);

		Customer customer = new Customer();
		customer.setId(100);
		customer.setName("mkyong");
		customer.setAge(29);
		Customer customer2 = new Customer();
		customer2.setId(101);
		customer2.setName("songiva");
		customer2.setAge(52);
		Customer customer21 = new Customer();
		customer21.setId(1021);
		customer21.setName("aongiva");
		customer21.setAge(55);

		// Copy-Beispiel
		Customer customer3 = customer.clone();
		System.out.println("CLONE:");
		System.out.println(customer.getName());
		System.out.println(customer3.getName());
		customer3.setName("Iva");
		System.out.println(customer3.getName());

		@SuppressWarnings("rawtypes")
		Class myc = customer.getClass();
		try {
			Field field = myc.getDeclaredField("name");
			field.setAccessible(true);
			String gefName = (String) field.get(customer);
			System.out.println("ReflName= " + gefName);
			String gefName1 = (String) field.get(customer3);
			System.out.println("ReflName= " + gefName1);

			@SuppressWarnings("unchecked")
			Method met = myc.getDeclaredMethod("getNamePrint");
			met.setAccessible(true);
			met.invoke(customer);

			Method met1 = myc.getDeclaredMethod("getName");
			met1.setAccessible(true);
			String temp = (String) met1.invoke(customer);
			System.out.println("Invoke..." + temp);

		} catch (Exception e) {
			e.printStackTrace();
		}

		// Sortieren der Namen
		Set<Customer> menge = new TreeSet<Customer>();
		menge.add(customer);
		menge.add(customer2);
		menge.add(customer21);
		System.out.println("sortierte Menge:");
		for (Customer o : menge) {
			System.out.println(o.getName());
		}

		Iterator it = menge.iterator();
		while (it.hasNext()) {
			Object or = it.next();
			if (or instanceof Customer) {
				// System.out.println(((Customer)or).getName());
				if (((Customer) or).getName().equals("mkyong")) {
					it.remove();
				}
				System.out.println("mit delete" + ((Customer) or).getName());
			}
			// System.out.println(((Customer)it.next()).getName());
		}
		System.out.println("sortierte Menge nacg dem DELETE:");
		for (Customer o : menge) {
			System.out.println(o.getName());
		}

		Customer[] customers = new Customer[2];
		customers[0] = customer;
		customers[1] = customer2;
		Arrays.sort(customers);
		System.out.println("ARRAYS:");
		for (Customer cus : customers) {
			System.out.println(cus.getName());
		}
		System.out.println(customers.length);
		for (int i = 0; i < customers.length; i++) {
			System.out.println(customers[i].getName());
		}
		// /

		List<Customer> l1 = Arrays.asList(customers);
		//l1.add(customer3);  UnsupportedOperationException
		// /////////////
		Status statusStart = Status.START;
		System.out.println("STATUS_ENUM:   " + statusStart + "  "
				+ Status.START.getGo() + " " + Status.STOP.getGoo());
		for (Status st : Status.values()) {
			System.out.println(st + " " + st.getGoo());
		}

		CustomerList clist = new CustomerList();
		clist.getList().add(customer);
		clist.getList().add(customer2);

		try {
			System.out.println("SEPARATOR-File:  " + File.separatorChar);

			File fileneu = new File(
					"C:\\workspace-java8\\Experiment\\Dokumente\\DOK-NEU\\");
			fileneu.mkdir();
			File file = new File("Dokumente\\file.xml");
			System.out.println(file.getAbsoluteFile());
			File file1 = new File("Dokumente-IVA\\ROLLE-IVA");
			file1.mkdir();
			if (file1.exists()) {

				// file1.delete();
			}
			try {
				System.out.println(file.getCanonicalFile());
			} catch (Exception e) {
			}
			System.out.println(file.getAbsoluteFile().isDirectory());
			System.out.println(file.getAbsolutePath());
			System.out.println("parent =" + file.getParent());
			System.out.println(file.getParentFile().isFile());
			System.out.println(file1.getParentFile());
			// String[] entries = new File( "Dokumente\\..\\Dokumente-IVA"
			// ).list();
			String[] entries = new File(".").list();
			System.out.println(Arrays.toString(entries));
			File[] entries1 = new File(".").listFiles();
			System.out.println(Arrays.toString(entries1));
			
			// JAXBContext jaxbContext =
			// JAXBContext.newInstance(Customer.class);
			JAXBContext jaxbContext = JAXBContext
					.newInstance(CustomerList.class);

			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// jaxbMarshaller.marshal(customer, file);
			// jaxbMarshaller.marshal(customer, System.out);
			jaxbMarshaller.marshal(clist, file);
			jaxbMarshaller.marshal(clist, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

		try {
			Pattern pat = Pattern.compile(".+\\.(de)?-[a-c]{2}");
			Matcher ma =pat.matcher("iva_abadjieva.de-aa");
			if(ma.matches())
				System.out.println("Matches.ok.......");
			
			
			DocumentBuilder builder;
			DocumentBuilderFactory docFactory = DocumentBuilderFactory
					.newInstance();

			// StringReader reader = new StringReader(xml);
			File file = new File("Dokumente\\file.xml");
			FileReader reader = new FileReader(file);
			InputSource source = new InputSource(reader);

			builder = docFactory.newDocumentBuilder();
			Document doc = builder.parse(source);
			
			XPathFactory fac = XPathFactory.newInstance();
			XPath xpath = fac.newXPath();

			String age = "20";
			XPathExpression expr = xpath
					.compile("//customerList/customer[age>" + age + "]/name");
			// xpath.compile("//customerList/customer/name/text()");

			NodeList nodes = (NodeList) expr.evaluate(doc,
					XPathConstants.NODESET);
			for (int i = 0; i < nodes.getLength(); i++)
				System.out.println(nodes.item(i).getTextContent()); // .getNodeValue

			// -----
			String id = "100";
			javax.xml.xpath.XPathExpression expr1 = xpath
					.compile("//customerList/customer[@id=" + id + "]/name");
			// xpath.compile("//customerList/customer/name/text()");

			NodeList nodes1 = (NodeList) expr1.evaluate(doc,
					XPathConstants.NODESET);
			for (int i = 0; i < nodes1.getLength(); i++)
				System.out.println(nodes1.item(i).getTextContent()); // .getNodeValue()

			// String name = (String) expr.evaluate(doc, XPathConstants.STRING);
			// System.out.println(name);

			//
			NodeList ndl= (NodeList)xpath.evaluate("/Customer",doc, XPathConstants.NODESET);
			for(int i=0; i<ndl.getLength(); i++){
				Node node = ndl.item(i);
				System.out.println("NodeName= "+node.getNodeName());
				Element elem= (Element)node;
				System.out.println("ElementArg= "+node.getAttributes().getNamedItem("ID"));
				System.out.println("ElementArg1= "+node.getAttributes().getNamedItem("name"));
			}
			
			//eineMethode1();

		} catch (Exception e) {
			System.out.println("3");

			// System.out.println(e.getCause().toString());
			System.out.printf("%60s\n", e.getCause().toString());

			System.out.println("4");
			e.printStackTrace();
		}

	}

	public static void eineMethode1() {
			eineMethode();
	}

	public static void eineMethode() {
		try {
			System.out.println("***--------------------------------");
			int a=5,i;

			i=++a + ++a + a++; // 6 +7 +7
			System.out.println("i= " +i);
			System.out.println("a= " +a);
			i=a++ + ++a + ++a; // 8 + 10 +11
			System.out.println("i= " +i);
			System.out.println("a= " +a);
			a=++a + ++a + a++; //12+13+13
			System.out.println("a= " +a);
			a= a++ -38 + a++ +1; //38-38 +40
			System.out.println("a= " +a);
			
			System.out.println("***--------------------------------");
			
			System.out.println("1");
			String s = "   \tSprich zu der Handß.\n ";
			System.out
			.println("'" +"EXPERIMENT UPPER:  "+ s.trim().toUpperCase()+ "'");
			System.out
					.println("'" + s.trim().toUpperCase().toLowerCase() + "'");
			// System.out.println(s);
			System.out.println("ENDE");

			// throw new Exception("ORIGINAL EXEPTION");
			// List<String> list = new ArrayList<String> ();
			// System.out.println("size="+list.size()/0);

			// System.out.println(((String)null).length());
			Integer in = Integer.parseInt("i");

		} catch (Exception e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
			// throw e;

		}

	}

	public int getInt() {
		int temp = 2;
		return temp;
	}

}