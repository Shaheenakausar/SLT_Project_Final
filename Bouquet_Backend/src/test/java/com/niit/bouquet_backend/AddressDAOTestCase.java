/*package com.niit.bouquet_backend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.AddressDAO;
import com.niit.model.Address;

public class AddressDAOTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static AddressDAO addressDAO;

	@Autowired
	static Address address;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		addressDAO = (AddressDAO) context.getBean("addressDAO");

		address = (Address) context.getBean("address");

	}

	@Test
	public void createAddressTestCase() {
		address.setId("shannu1");
		address.setUser_id("kausar");
		address.setH_no("44/11B");
		address.setStreet("Road no 1");
		address.setCity("Hyderabad");
		address.setCountry("India");
		address.setPin("500038");

		boolean flag = addressDAO.save(address);

		assertEquals("createAddressTestCase", true, flag);

	}

	@Test
	public void updateAddressTestCase() {
		address.setId("shaheena");
		address.setUser_id("shannu");
		address.setH_no("4-1-185");
		address.setStreet(" Road 9");
		address.setCity("vijayawada");
		address.setCountry("India");
		address.setPin("511068");

		boolean flag = addressDAO.update(address);

		assertEquals("createAddressTestCase", true, flag);

	}

	@Test
	public void listAllAddressTestCase() {
		int actualSize = addressDAO.list().size();
		assertEquals(2, actualSize);
	}

}
*/