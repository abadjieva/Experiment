package iva.com.beispiele_1;

import iva.com.beispiele.Customer;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Formatter;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;



public class ExperimentJDBC extends Customer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExperimentJDBC exp =new ExperimentJDBC();
	
		exp.beispielJDBC();
		
	}
	private void beispielJDBC(){
		
		Logger logg =Logger.getLogger(getClass().getName());
		logg.log(Level.INFO, ExperimentJDBC.class.getName());
		setName("IVA");
		
		logg.log(Level.INFO, getName());
		
		
		try{
			SimpleFormatter ft = new SimpleFormatter();
		FileHandler fh = new FileHandler("Dokumente\\mein.log", 1*1024*1024, 100, true);
		fh.setFormatter(ft);
		logg.addHandler(fh);
		
		String db="jdbc:mysql://localhost:3306/mappis_db190712_test";
		String user="root";
		String password="admin";
		String query="SELECT count(*) FROM mappis_db190712_test.partnerfirma p;";
	
	
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection con = DriverManager.getConnection(db,user,password);
		
		//PreparedStatement prs= con.prepareStatement(query);
		
		
		Statement statement = con.createStatement();
		ResultSet rs=statement.executeQuery(query);
		
		while(rs.next()){
		int anzahl = rs.getInt(1);
		String tem= String.valueOf(anzahl);
		Float da= Float.parseFloat(tem);
			
		//String anzString = String.valueOf(anzahl);
		System.out.printf("int:%4d\n", anzahl);
		System.out.printf("alle: %10.2f\n", da);
		System.out.printf("int:%4d float:%1.1f\n", anzahl, da);
		
		
		}
		con.close();
		
		
		//QUEUE
		LinkedBlockingQueue<String> q= new LinkedBlockingQueue();
		q.add("Iva1");
		q.add("Iva2");
		System.out.println(q.poll());
		System.out.println(q.take());
		//System.out.println(q.take());
		System.out.println(q.poll());
		
		LinkedList<String> str = new LinkedList<String>();
		str.add("Galja");
		System.out.println(str.poll());
		System.out.println(str.poll());
		
		
/////
		List<String> lines = Arrays.asList("The first line", "The second line");
		Path file = Paths.get("Dokumente\\the-file-name.txt");
		Files.write(file, lines, Charset.forName("UTF-8"));
		
		File fil = new File("Dokumente\\the-file-name-old.txt");
		FileOutputStream fo= new FileOutputStream(fil);
		OutputStreamWriter wr= new OutputStreamWriter(fo);
		BufferedWriter wrw= new BufferedWriter(wr);
		wrw.write("Iva");
		wrw.newLine();
		wrw.write("ABA");
		wrw.close();
		
		ByteArrayOutputStream by= new ByteArrayOutputStream();
		by.writeTo(fo);
		
	}catch( Exception e){
		System.out.printf("Fehler: %s\n", e);
	}
	}

}
