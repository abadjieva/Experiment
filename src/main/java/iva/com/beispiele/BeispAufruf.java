package iva.com.beispiele;

public class BeispAufruf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BeispAufruf bf = new BeispAufruf();
		bf.test();

	}
	private void test(){
		try{
		Class<?> cl = Class.forName("iva.com.beispiele.Beisp1");
		
		System.out.println("\n------------");
		Beisp1 bb = (Beisp1)cl.newInstance();
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

}
