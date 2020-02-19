package iva.com.beispiele;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsIn.*;
import static org.hamcrest.collection.IsCollectionWithSize.*;

import org.junit.*;

public class CustomerTest {
	String message = "Robert";
	String[] arr = new String[] { "Iva", "Olga" };
	List<String> lis1 = Arrays.asList(arr);

	@Test
	public void testSalutationMessage() {
		System.out.println("Inside testSalutationMessage()");
		message = "Robert";
		assertEquals("Fehler", message, "Robert");
		assertThat("Hat 2 Sätze", lis1, hasSize(2));
		assertThat("Fehler", "Iva", in(lis1));

	}

	@Test
	public void CustomerTest1() {

		JAXBExample ex = new JAXBExample();
		assertTrue("Nicht gleich", ex.getInt() == 2);
	}
}
