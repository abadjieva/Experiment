package iva.com.beispiele;

public class BeispielFactory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BeispielFactory beispiel = new BeispielFactory();
		beispiel.factory();
	}

	void factory() {
		FactoryAbstract fc = new FactoryKoncret();
		AbstractProduct produkt = fc.createProduct("na");
		System.out.println(produkt.getName());
		String userHome = System.getProperty("user.home");
		System.out.println("HOME= " + userHome);
	}

}
