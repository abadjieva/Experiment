package iva.com.beispiele;

public class Beisp1 {

	static {
		try {
			System.out.println("sich selbst beim Laden instanzieren");
			new Beisp1();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Beisp1() {
		System.out.println("Obj instantiiren");
		Beisp2.register(this);
	}
	public void my(){
		System.out.println("aus dem Beisp1");
	}

}
