package iva.com.beispiele;


public class BuilderExp {
	 static
	  {
	    System.out.println( "STATIC....." );
	    //System.exit(0);
	  }
	 {
		 System.out.println( "Initial....." );
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println( "main....." );
		BuilderExp exp = new BuilderExp();
		exp.test();
	}
	void test(){
		ObjMitBuilder.MeinBuilder obj = new ObjMitBuilder.MeinBuilder("Frau");
		ObjMitBuilder ob= obj.setAlter(67).setName("Iva").build();
		System.out.println(ob.getGen() + " "+ ob.getName() + " " + ob.getAlter());
		
	}
}
