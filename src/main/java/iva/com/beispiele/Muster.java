package iva.com.beispiele;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.text.Collator;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;


public class Muster {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyFunctionalInterface<Integer> mi=new MyFunctionalInterface<Integer>(){
			public void myfunction(Integer T){
				System.out.println("Funktion"+T);
			}
		};
		mi.myfunction(5);
		
		MyFunctionalInterface<Integer> mi1 = (T) -> {System.out.println("Lambda"+T);};
		mi1.myfunction(5);
		
		try{
		Class c22 = Class.forName("Customer");
		Object o = c22.newInstance();	
		((Customer)o).getName();
		}catch(Exception e){}
		
		
		
		Class<Customer> gastroclass= Customer.class;
		//Customer oo= gastroclass.newInstance();
		Customer obj = new Customer();
		
		try{
		java.lang.reflect.Field feld=gastroclass.getDeclaredField("name");
		feld.setAccessible(true);
		feld.set(obj, "Erna");
		System.out.println("Reflection... "+feld.get(obj)+ " "+feld.getType().getName());
		
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		Class<?> ca = java.text.SimpleDateFormat.class;
		System.out.println( "class " + ca.getName() + " {" );
		for ( Field publicField : ca.getFields() ) {
		  String fieldName = publicField.getName();
		  String fieldType = publicField.getType().getName();
		  System.out.printf( "  %s %s %n", fieldType, fieldName );
		}
		System.out.println( "}" );

		for ( Method method : gastroclass.getDeclaredMethods() ) {
			
			System.out.println(method.getReturnType().getName()+" "+ method.getName());
		}
	for ( TypeVariable method : gastroclass.getTypeParameters() ) {
			
			System.out.println("*  "+method.getName());
		}
	
		
		
		Collator col = Collator.getInstance(Locale.GERMAN);
		System.out.println("------Collator "+col.compare("F�lle", "FAlle"));
		String[] iva = new String[10];
		String[] er = {"2","3"};
		String[] iva2 = new String[] {"3"};
		
//FACTORY-Pattern
		FactoryAbstract factabst= new FactoryKoncret();
		System.out.println("FACTORY_PATTERN: "+factabst.createProduct("iva").getName());
		
		
		
		Muster muster = new Muster();
		muster.nutzeSingelton();

		try {
			RandomAccessFile f = new RandomAccessFile("duke.gif", "r");
			f.seek(6);

			System.out.printf("%s x %s Pixel%n", f.read() + f.read() * 256,
					f.read() + f.read() * 256);
			f.close();
		}
		// catch ( FileNotFoundException e )
		// {
		// System.err.println( "Datei ist nicht vorhanden!" );
		// }
		// catch ( IOException e )
		// {
		//
		// System.err.println( "Allgemeiner Ein-/Ausgabefehler!" );
		// }
		catch (Exception e) {
			System.err.println("Allgemeiner Ein-/Ausgabefehler!");
		}

	}

	private void nutzeSingelton() {
		String imput = "mamma";
		switch (imput) {
		case "iva":
			break;
		case "oli":
			break;
		default:
			System.out.println(imput);

		}
		
		//---------------
		System.out.println("______JAVAHOME= "+System.getProperty("java.version"));
		System.out.println("______JAVAHOME= "+System.getProperty("os.name"));
		System.out.println("______JAVAHOME= "+System.getProperty("file.separator"));
		
		//----------------

		// /////////
		try {
			List<String> myList = Arrays.asList("Hello", "Java", "MEINE");
			long countLongStrings = myList.stream()
					.filter(element -> element.length() > 4).count();
			System.out.println("countLongStrings= " + countLongStrings);

			myList.forEach((String element) -> System.out.println("forEach->"+element));
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.addAll(Arrays.asList(4, 5, 7));
			
			list.removeIf(p -> p % 2 ==0);
			list.forEach(p->System.out.println("forEachRest->"+p));
		
			int an=7;
			list.removeIf(p -> p ==an);
			list.forEach(p->System.out.println("forEachRest1->"+p));
			LocalTime time = LocalTime.of(20, 15);
			LocalDate date = LocalDate.of(2015, 6, 20);
			LocalDateTime t = LocalDateTime.of(date, time);
			System.out.println(t);

			RandomAccessFile f = new RandomAccessFile("duke.gif", "r");
			f.seek(6);

			System.out.printf("%s x %s Pixel%n", f.read() + f.read() * 256,
					f.read() + f.read() * 256);
			f.close();
			
		} catch (FileNotFoundException e) {
			System.err.println("Datei ist nicht vorhanden!");
		} catch (IOException e) {

			System.err.println("Allgemeiner Ein-/Ausgabefehler!");
		} catch (Exception e) {

			System.err.println("Allgemeiner Fehler!");
		}

	}

}
