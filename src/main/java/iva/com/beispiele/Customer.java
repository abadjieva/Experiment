package iva.com.beispiele;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer implements Comparable, Cloneable{

	@XmlElement
	private String name;
	@XmlElement
	int age;
	@XmlAttribute(name="ID")
	int id;

	public String getName() {
		return name;
	}

//	@XmlElement
	protected void setName(String name) {
		this.name = name;
	}

	protected int getAge() {
		return age;
	}

	//@XmlElement
	protected void setAge(int age) {
		this.age = age;
	}

	protected int getId() {
		return id;
	}

	//@XmlAttribute
	protected void setId(int id) {
		this.id = id;
	}

	private void getNamePrint() {
		System.out.println("HALLO!");
	}
	
	@Override
	  public Customer clone()
	  {
	    try
	    {
	      return (Customer) super.clone();
	    }
	    catch ( CloneNotSupportedException e ) {
	      // Kann eigentlich nicht passieren, da Cloneable
	      throw new InternalError();
	    	
	    }
	  }
	
	@Override
	public int compareTo(Object neu){
		//Customer c = (Customer)neu;
		
		return this.name.compareTo(((Customer)neu).name);

	}
}