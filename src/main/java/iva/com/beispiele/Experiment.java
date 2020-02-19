package iva.com.beispiele;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.sound.sampled.AudioFormat.Encoding;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Experiment implements ExperimentInterface {
	int i = 19;

	public Experiment(int i, String[] args) {
		this.i = i;
		System.out.println("i= " + i + " this.i=  " + this.i);

		Integer[] arr = new Integer[3];
		Arrays.fill(arr, 10);
		Integer[] arr1 = Arrays.copyOf(arr, arr.length + 1);
		Integer[] arr2 = Arrays.copyOfRange(arr, 1, 3);
		Arrays.fill(arr2, 0, 1, 50);

		System.out.printf("hier: %1$s %2$-3d%n", Arrays.toString(arr),
				arr.length);
		System.out.println(Arrays.toString(arr) + arr.length + " "
				+ Arrays.toString(arr1) + " " + arr1.length
				+ Arrays.toString(arr2) + " " + Arrays.toString(args));
		if (Arrays.equals(arr, arr1)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

	public void zeige() {

		System.out.println("\nEXPeriment......");
			System.setProperty("file.encoding", "UTF-8");
			System.out.println("Default Locale:   " + Locale.getDefault());
			System.out.println("Default Charset:  " + Charset.defaultCharset());
			System.out.println("file.encoding;    "
					+ System.getProperty("file.encoding"));
		int i1 = 128;
		System.out.println("I1= " + (short) i1);
		float fl0 = 1.00f;
		float fl1 = 3;
		float fl = fl0 / 3f;
		System.out.println(fl0 + " " + fl);

		byte val = (byte) 0x82;
		int i = val;
		System.out.println("value: " + val);
		System.out.println("binary: " + Integer.toBinaryString(i));

		int a = -1;
		System.out.println("binary1: " + Integer.toHexString(a));
		byte ba = (byte) a;
		int c = ba;
		System.out.println("byte ToString= " + Byte.toString(ba) + " "
				+ Byte.toUnsignedInt(ba) + " " + c);
		Integer n = 20;
		System.out.println("N " + n.intValue());

		int bbs;
		int bbb = (ba & 0x7f);
		int bbb2 = 0x80;
		if (ba < 0) {
			bbs = bbb + bbb2;
			System.out.println("1 " + String.valueOf(+bbs));
		}
		int bi = (int) ba & 0xff;

		int baa = 0x7f;
		baa ^= 0x02;
		System.out.println("BITOPERATION "+baa);
		
		int bar = 72;
		bar >>= 3;
		System.out.println("BITOPERATION "+bar);
		
		int bar1 = 72;
		bar1 = bar1 >> 3;
		System.out.println("BITOPERATION "+bar1);
		
		System.out.println("2 " + String.valueOf(bi));

		try {
			
			
			String str = "\u00BE\u00F5häßlich&таблици\u0030\u0444";
			//String str= "Категория: Кодови таблици & IVA";
			//String str = "olga";
			//String str = "\u0444";
			System.out.println("STR= " + str);
			byte[] bt = str.getBytes("UTF-8");
			int len = bt.length;
			System.out.println("Lenght= " + len);
			// byte[] bt = str.getBytes("Windows-1251");

			// byte[] bt1 = str.getBytes("ISO-8859-1");
			//byte[] bt1 = str.getBytes("UTF-8");
			// byte[] bt1 = str.getBytes("Windows-1251");
			// byte[] bt1 = new byte []{(byte)228,(byte)232};

			ByteArrayInputStream bais = new ByteArrayInputStream(bt);
			InputStreamReader ii = new InputStreamReader(bais, Charset.forName("UTF-8"));
			int ia;
			// read byte by byte until end of stream
			while ((ia = ii.read()) != -1) {
				System.out.println("ZURÜCK: " + (char)ia);
			
			}
			
			
			FileOutputStream fo = new FileOutputStream("Dokumente\\experiment1");
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			baos.write(bt);
			baos.writeTo(fo);
			OutputStreamWriter osr = new OutputStreamWriter(fo, Charset.forName("UTF-8"));
			//osr.write(str);
			osr.close();
			
			FileInputStream fi = new FileInputStream("Dokumente\\experiment1");
			InputStreamReader isr = new InputStreamReader(fi, Charset.forName("UTF-8"));
			while ((ia = isr.read()) != -1) {
				System.out.println("ZURÜCK-1: " + (char) ia);
				
			}

			System.out.println("Default Locale:   " + Locale.getDefault());
			System.out.println("Default Charset:  " + Charset.defaultCharset());
			System.out.println("file.encoding;    "
					+ System.getProperty("file.encoding"));
			System.out.println("os.name: " + System.getProperty("os.name"));
			System.out.println("lineSeparator    " + System.lineSeparator());
			// System.out.println("Default Encoding: " + getEncoding());
		} catch (Exception e) {

		}

		try {
			DataOutputStream out = new DataOutputStream(
					new BufferedOutputStream(new FileOutputStream(
							"Dokumente\\test.txt")));
			out.writeInt(1);
			out.writeInt(-1);
			out.writeDouble(Math.PI);
			out.writeUTF("häßliches");
			out.writeUTF("Entlein");
			out.writeUTF("таблици");
			out.close();
		} catch (IOException e) {
			System.err.println(e.toString());
		}

		try {
			DataInputStream out = new DataInputStream(new BufferedInputStream(
					new FileInputStream("Dokumente\\test.txt")));
			System.out.println(out.readInt());
			System.out.println(out.readInt());
			System.out.println(out.readDouble());
			System.out.println(out.readUTF());
			System.out.println(out.readUTF());
			System.out.println(out.readUTF());
			out.close();

			String str = "iva 0ÈQф";
			// String str= "Категория: Кодови таблици & IVA";
			// String str = "тест";
			// String str = "ф";
			System.out.println("STR= " + str);
			//byte[] bt = str.getBytes("ISO-8859-5");
			byte[] bt = str.getBytes("utf-8");
			StringBuilder sb = new StringBuilder();
			for (byte b : bt) {
				sb.append(String.format("%02x", b));

			}
			System.out.println(sb.toString());

		} catch (IOException e) {
			System.err.println(e.toString());
		}

		String[] arr = { "iva", "erna", "Zadoijko" };
		Stream<String> stream = Arrays.stream(arr);
		Predicate<String> pred = e -> {
			return e.length() > 3;
		};
		String temp = stream.filter(pred).collect(Collectors.joining(" "));
		// String temp = stream.filter(e ->
		// e.length()>3).collect(Collectors.joining(" "));
		// String temp = stream.filter(new Predicate<String>(){
		// public boolean test(String e){
		// return e.length()>=3;
		// }
		// }
		// ).collect(Collectors.joining(" "));
		Character cc = temp.charAt(0);
		Character ccc = Character.toUpperCase(cc);
		String temp1 = ccc + temp.substring(1);
		System.out.printf("Stream collect: %5s / %5s%n", temp1,
				temp.toUpperCase());

		Double d = 37.8d;
		BigDecimal bd = new BigDecimal(d);
		System.out.println("BigDecimal from Double 37.8= " + bd + "   "
				+ BigDecimal.valueOf(d));

		String stt = Double.toString(d);
		System.out.println("BigDecimal from String 37.8= " + stt);

		BigDecimal bd1 = new BigDecimal("37.8");
		System.out.println("BigDecimal from '37.8'= " + bd1);

		// ///////////////
		System.out.printf("%f", 11234.);
		System.out.println();
		System.out.printf("%f", 11234.12);
		System.out.println();
		System.out.printf("%,.3f", 11234.12);
		System.out.println();
		System.out.printf("%.1f", 11234.12);
		System.out.println();
		System.out.printf("%.3f", 11234.12);
		System.out.println();
		System.out.println("zahl " + 11234.12);

		Callable<String> call = () -> {
			try {
				// TODO Auto-generated method stub
				System.out.println("Call im C ausgeführt: ");
				//System.out.println(1 / 0);
				// Thread.sleep(10000);
				TimeUnit.MILLISECONDS.sleep(10000);
				// Integer i = 1/0;
				return Thread.currentThread().getName();
			} catch (Exception e) {
				System.out.println("Exc im Call...");
				throw e;
			}

		};

		ExecutorService executor = Executors.newCachedThreadPool();
		ExecutorService executor1 = Executors.newCachedThreadPool();
		Future<String> future = executor.submit(call);
		Future<String> future1 = executor1.submit(call);
		try {
			List<Callable<String>> liste = Arrays.asList(call, call);
			List<Future<String>> listFutures = executor.invokeAll(liste);
			for (Future<String> f : listFutures) {
				System.out.println("my: " + f.get());
			}
		} catch (InterruptedException | ExecutionException e) {
			System.out.println("Exception..."+ e.getMessage());
		}

		long t1 = System.currentTimeMillis();
		try {
			while (!future.isDone()) {
				System.out.println("Task is still not done...");
				TimeUnit.SECONDS.sleep(2);
				future1.cancel(true);
			}

			try {
				System.out.println("RESULT1= "
						+ future.get(17, TimeUnit.SECONDS));
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (!future1.isCancelled()) {
				System.out.println("RESULT2= " + future1.get());
			} else {
				System.out.println("Task 1 was cancelled");
			}
			long t2 = System.currentTimeMillis() - t1;
			System.out.println("ZEIT= " + t2);
			System.out.println("IS DONE " + future.isDone() + " "
					+ future.get());
			System.out.println("IS DONE1 " + future1.isDone());
			executor.shutdown();
			executor1.shutdown();
			
			CompletableFuture<?> cf = CompletableFuture.runAsync(()->{
					System.out.println("Anfang....");
					Thread.currentThread().getName();});
			cf.whenComplete((v,e)->{
				if(e !=null ){
					System.out.println("Exception"+e);
				}
				else{System.out.println("OK");};
				
			});
			
			///////////////
			StringBuilder sb = new StringBuilder();
			URLConnection urlConn = null;
			InputStreamReader in = null;
			String myURL = "https://cdn.crunchify.com/wp-content/uploads/code/json.sample.txt";
			
			try {
				URL url = new URL(myURL);
				
				urlConn = url.openConnection();
				if (urlConn != null)
					urlConn.setReadTimeout(60 * 1000);
				if (urlConn != null && urlConn.getInputStream() != null) {
					in = new InputStreamReader(urlConn.getInputStream(),
							Charset.defaultCharset());
					
					BufferedReader bufferedReader = new BufferedReader(in);
					if (bufferedReader != null) {
						String cp;
						while ((cp = bufferedReader.readLine()) != null) {
							sb.append(cp).append("\n");
						}
						bufferedReader.close();
					}
				}
			in.close();
			
			
			} catch (Exception e) {
				throw new RuntimeException("Exception while calling URL:"+ myURL, e);
			} 
	 
			System.out.println("-------------------\n");
			System.out.println(sb.toString());
			
/////////////////////////
			
int aa = 0;
int bb = aa++;
System.out.println("bb=" + bb + "\naa=" + aa);
aa=0;
int ca = ++aa;
System.out.println("ca=" + ca + "\naa=" + aa);

int x = 0;
x = x++ + 1 + x;        // evaluates to x = 0 + 1 + 1
x++;                    // adds 1
System.out.println(x);  // prints 3 
for(int iz=0; iz<=10;iz++){
	System.out.println("i= "+iz);	
}
////////////////////
File fll = new File(".\\Dokumente\\ivaMy.txt");
boolean cr = fll.createNewFile();
if(cr){
	System.out.println("erstellt "+fll.getCanonicalPath());
}else{
	System.out.println("Bereits erstellt ");
}


Period duration = Period.between( LocalDate.of( 1973, 2, 3 ), LocalDate.now() );

Date dat = new Date();
Instant start=dat.toInstant();
//Instant start = Instant.now();
//System.out.println("Instant: "+start.atZone(ZoneId.of("Europe/Berlin")));
System.out.println("Instant: "+start.atZone(ZoneId.systemDefault()));

LocalDate lcd= LocalDate.now();
Instant myi=lcd.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
Date ne = Date.from(myi);

LocalDateTime ldt = LocalDateTime.now();
ZonedDateTime zdt = ZonedDateTime.of(ldt, ZoneId.of("Europe/Berlin"));
ZonedDateTime zdt1 =zdt.withZoneSameInstant(ZoneId.of("Europe/Sofia"));

Instant end = Instant.now();

System.out.println("DURATION: "+Duration.between(start, end).toMillis()+ " "+start.until(end, ChronoUnit.MILLIS));

LocalDateTime ld1 = zdt1.toLocalDateTime();
System.out.printf("%40s Time in Sofia: %10s\n",zdt, zdt1);
System.out.println("LocalTime in Sofia "+ld1);
Date da= new Date();


Path dire= Paths.get(".\\Dokumente\\Iva1.xml");
if(!Files.exists(dire)){
Files.createFile(dire);
}
//System.out.println(dire.toAbsolutePath().normalize());
System.out.println(dire.toAbsolutePath());

Path dir= Paths.get(".\\Dokumente");
System.out.println("Owner= "+Files.getOwner(dir));
System.out.println(dir.toAbsolutePath().normalize().toString());
DirectoryStream<Path> ds =Files.newDirectoryStream(dir);
System.out.println("\\Dokumente:");
for(Path p :ds){
	if(Files.isDirectory(p)){
		System.out.println("DIR= "+p.getFileName());
	}else
	{System.out.println(p.getFileName().toString());}
}
Iterable<Path> list =FileSystems.getDefault().getRootDirectories();
long bte = 1024*1024*1024;
for(Path p : list){
	try{
	FileStore fs=Files.getFileStore(p);
	System.out.println(fs.toString());
	long b = fs.getUsableSpace();
	System.out.println(fs.toString()+ " "+ b/bte);
	}catch(Exception e){
		
	}
}

try (Stream<Path> walk = Files.walk(Paths.get(".\\Dokumente"))) {

	Predicate<Path> predd = pa->{return Files.isRegularFile(pa);};
	Function<Path, String> func = p -> {if(p.getFileName().toString().endsWith(".xml")==true){
		return "file: "+ p.getFileName().toString();
	}
	else return null;
	};

	List<String> result = walk.filter(predd).map(func).collect(Collectors.toList());

	result.forEach(p -> {if (p!=null )System.out.println(p);});

} catch (IOException e) {
	e.printStackTrace();
}

///////////////////

Path di = Paths.get(".\\Dokumente");
Path iv= Files.createTempFile(di, "temp_", ".dat");
System.out.println("TempFile: "+iv.toAbsolutePath().normalize());
/////
			
			GsonBuilder gb = new GsonBuilder();
			Gson gs = gb.create();
			JsonObj jo = new JsonObj(100, "kein");
			List<JsonObj> lis = new LinkedList<JsonObj>();
			lis.add(jo);
			jo = new JsonObj(200, "Error101");
			lis.add(jo);
			String js = gs.toJson(lis);
			System.out.println("JSON= "+js);
			//
			
			String js1 = gs.toJson(jo);
			System.out.println("JSON1= "+js1);
			JsonObj newObj = gs.fromJson(js1, JsonObj.class);
			
			System.out.println("Aus dem Object: " +newObj.getLis().get(0)+ " "+newObj.getLis().get(1));
			System.out.println("Aus dem Map: " +newObj.getMap().get("Fehler1"));
		} catch (final Exception e) {
			e.printStackTrace();
		}
		/////////////

	}
}
