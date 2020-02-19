package iva.com.beispiele;

import java.io.Serializable;

public class LoaderMy implements Serializable{
	private static int a =0;
	static{
		System.out.println("LoaderMyStatic---");
	}
	public LoaderMy(){
	System.out.println("LoaderMyConstruktor---");
	}
	public void test(){
		System.out.println("TEST LoaderMy---");
	}
	private String testPrivate(){
		System.out.println("TEST PRIVATE METHOD---");
		return "PRIVATE";
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        
//        if(o instanceof LoaderMy){
//        	 //if(((LoaderMy) o).a ==this.a)
//        	return true;
//        }
        if(o.getClass() != this.getClass()){
        	return false;
        }
        else {
        	//if(((LoaderMy) o).a ==this.a)
        	return true;
        }
        //return false;
    }
	
}
