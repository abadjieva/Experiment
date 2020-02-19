package iva.com.beispiele;

public class FactoryKoncret extends FactoryAbstract {
	
	AbstractProduct createProduct(String name){
		AbstractProduct product;
		switch(name){
		case "iva": 
			product = new KoncretProduct();
			break;
		case "na":
			product = new KoncretProduct2();
			break;
		default:
			return new KoncretProduct2();
		}
		
		return product;
	}
	
	private class KoncretProduct extends AbstractProduct {
	
		@Override	
		String getName(){
			
			return "Iva Abadjieva";
		}
	}
	
}
