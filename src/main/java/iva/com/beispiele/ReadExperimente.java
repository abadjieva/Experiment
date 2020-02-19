package iva.com.beispiele;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Collator;
import java.util.Locale;

public class ReadExperimente {

	public static void main (String[] args){
		ReadExperimente re = new ReadExperimente();
		re.test();
	}
	private void test(){
		//Locale loc =Locale.getDefault();
		//System.out.println(loc.getCountry());
		String str = "Tßast";
		//Collator coll = Collator.getInstance(Locale.getDefault());
		Collator coll = Collator.getInstance(Locale.GERMAN);
		int vergl = coll.compare(str, "Tßast");
		int vergl1 = str.compareTo("Töast");
		System.out.println(vergl+ " " +vergl1);
		/////
		System.out.println(getClass().getName());
		try{
			Class<?> cl1 = Class.forName("iva.com.beispiele.Experiment");
			Customer customer = new Customer();
			Class<?> cl =customer.getClass();
			customer.setName("IVA");
			Method met1 = cl.getDeclaredMethod("getName");
			met1.setAccessible(true);
			String temp = (String) met1.invoke(customer);
			System.out.println("Invoke..." + temp);
			System.out.println("-------");
			System.out.println("ENDE");
			
			ClassLoader l = cl.getClassLoader();
			ClassLoader l1 = cl1.getClassLoader();
			System.out.println(l.toString()+ " " + l1.toString());
			
			String url2 = "file:/C:/workspace-java8/Experiment/build/classes/iva/com/beispiele/LoaderMy.class"; 
			URL url = new URL(url2);
			URLClassLoader ucl = new URLClassLoader(new URL[]{url});
			Class<?>myclass=ucl.loadClass("iva.com.beispiele.LoaderMy");
			myclass.newInstance();
			///////////////////
			
			File p = new File(".\\Dokumente\\file.xml");
			ByteArrayOutputStream bs= new ByteArrayOutputStream();
			
			FileInputStream fis = new FileInputStream(p);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			
			int by;
			while((by = fis.read()) != -1){
				bs.write(by);
			}
			System.out.println(bs.toString());
			bs.close();
			//FileOutputStream fo = new FileOutputStream(bs);
			
			
		}catch(Exception e){
			System.out.println("-------EXC");
			e.printStackTrace();
		}
		
	}}
	
