package iva.com.beispiele;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement (name="IVA")
public class CustomerList {

@XmlElement(name = "Customer", type = Customer.class)
List<Customer> list = new ArrayList<Customer>();

public List<Customer> getList() {
	return list;
}

//@XmlElement(name = "customer", type = Customer.class)
/*public void setList(List<Customer> list) {
	this.list = list;
}
*/
	

}
