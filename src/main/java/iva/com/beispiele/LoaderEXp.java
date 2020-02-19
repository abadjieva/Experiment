package iva.com.beispiele;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import javax.xml.parsers.DocumentBuilderFactory;

public class LoaderEXp {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		LoaderEXp exp = new LoaderEXp();
		exp.test1();
	}

	private void test() {
		System.out.println("CLL= "
				+ Thread.currentThread().getContextClassLoader() + "  "
				+ String.class.getClassLoader());
		System.out.println(System.getProperty("java.ext.dirs"));
		ClassLoader l = getClass().getClassLoader();
		ClassLoader lp = l.getParent();

		ClassLoader ll = LoaderEXp.class.getClassLoader();
		System.out.println(ll);

		System.out.println(l);
		System.out.println(lp);

		try {
			System.out.println("0");
			Class<?> lc = l.loadClass("iva.com.beispiele.LoaderMy");
			System.out.println("1");
			LoaderMy lm = (LoaderMy) lc.newInstance();
			lm = (LoaderMy) lc.newInstance();
			System.out.println("2");
			lm.test();
			System.out.println("3");
			System.out.println(lm.getClass() + " "
					+ lm.getClass().getSuperclass().getName());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void test1() throws Exception {
		
		LoaderMy lm0 = new LoaderMy();
		LoaderMy lm00 = new LoaderMy();
		Class<?> cl0 = lm0.getClass().getClassLoader().loadClass("iva.com.beispiele.LoaderMy");
		LoaderMy my0 = (LoaderMy)cl0.newInstance();
		if(lm0.equals(my0)){
			System.out.println("OK1");
		}else{
			System.out.println("NO1");	
		}
		if(lm00.equals(lm0)){
			System.out.println("OK2");
		}else{
			System.out.println("NO2");	
		}
		
		String url23 = "file:/C:/workspace-java8/Experiment/Dokumente/test.txt"; 
		URL url3 = new URL(url23);
		URLConnection utz=  url3.openConnection();
		InputStream ist = utz.getInputStream();
		InputStreamReader riis = new InputStreamReader(ist, StandardCharsets.UTF_8);
		Properties pr = new Properties();
		pr.load(riis);
		String strMy = (String) pr.get("jdbc.url");
		byte[] bs = strMy.getBytes(StandardCharsets.UTF_8);
		String myw = new String(bs);
		System.out.println(myw);
		
		
		URLClassLoader cll = (URLClassLoader) LoaderEXp.class.getClassLoader();
		URL urll = cll.findResource("META-INF/MANIFEST.MF");
		Manifest manifest = new Manifest(urll.openStream());
		Attributes attr = manifest.getMainAttributes();
		System.out.println(manifest.getMainAttributes().getValue("Implementation-Title"));
		attr.put(Attributes.Name.MANIFEST_VERSION, "1.0");
	
		
		String url2 = "file:/C:/workspace-java8/Experiment/build/classes/iva/com/beispiele/LoaderMy.class"; 
		URL url = new URL(url2);
		URLClassLoader loader = new URLClassLoader(new URL[]{url});
		Class<?> cl =loader.loadClass("iva.com.beispiele.LoaderMy");
		LoaderMy my = (LoaderMy)cl.newInstance();
		my.test();
		System.out.println("333 "+my.getClass().getClassLoader());
		System.out.println(loader);
		
		if(my0.equals(my)){
			System.out.println("OK");
		}else{
			System.out.println("NO");	
		}
		
		//-----------------
		String url33 = "file:/C:/workspace-java8/Experiment/build/classes/iva/com/beispiele/LoaderMy.class"; 
		URL url333 = new URL(url33);
		URLConnection con = url333.openConnection();
		InputStream iss = con.getInputStream();
		BufferedInputStream   bis = new BufferedInputStream(iss);
	
		//File file = new File("C:\\workspace-java8\\Experiment\\build\\classes\\iva\\com\\beispiele\\LoaderMy.class");
		//FileInputStream fis = new FileInputStream(file);
		//BufferedInputStream   bis = new BufferedInputStream(fis);
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		int temp;
		while((temp = bis.read()) != -1){
			byteArrayOutputStream.write(temp);
		}
		byte[] byteCode = byteArrayOutputStream.toByteArray();
		
		
		MaLoader mal = new MaLoader();
		Class<?> mclass = mal.findClass("iva.com.beispiele.LoaderMy",byteCode);
		System.out.println("1 "+mclass.getClassLoader());
		System.out.println(mclass.newInstance().getClass().getName());
		Object inst2 = mclass.newInstance();
		
		Method m = mclass.getMethod("test");  // Parameters optional
		m.invoke(inst2);  // Ditto
		
        for (Method mm: mclass.getMethods()){
        	System.out.println(mm.getReturnType().getName() + " "+ mm.getName());
        }
       Field a1= mclass.getDeclaredField("a");
       a1.setAccessible(true);
       a1.set(inst2, 20);
       System.out.println("a= "+a1.get(inst2) + " " +a1.getName()+ " " +a1.getType().getTypeName()+ " "+a1.getModifiers());
       if (java.lang.reflect.Modifier.isStatic(a1.getModifiers())) {}
       System.out.println("STATIC");
      mclass.getConstructor().newInstance();
      Method ma= mclass.getDeclaredMethod("testPrivate");
      ma.setAccessible(true);
      String ret = (String)ma.invoke(inst2);
      
      System.out.println("Return= "+ret);
      
      //DocumentBuilderFactory df = DocumentBuilderFactory.newInstance("Customer.class");
      
	}
	
	public class MaLoader extends ClassLoader{
		
			public Class <? > findClass(String str, byte[] byteCode ){
				
				 Class<?> c = findLoadedClass("iva.com.beispiele.LoaderMy");
			        if (c == null) {
			        	System.out.println("NOCH NICH GELADEN");
			        }
			        
			        Class <? > cc=    defineClass(str, byteCode, 0, byteCode.length );
			        
			        Class<?> c1 = findLoadedClass("iva.com.beispiele.LoaderMy");
			        if (c1 != null) {
			        	System.out.println("GELADEN");
			        }
				return cc;
		}
	}
}
