package com.niit.bouquet_backend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.SupplierDAO;
import com.niit.model.Supplier;

public class SupplierDAOTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static SupplierDAO supplierDAO;
	@Autowired
	static Supplier supplier;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		// get the categoryDAO from context
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");

		// get the category from context

		supplier = (Supplier) context.getBean("supplier");

	}

	@Test
	public void createSupplierTestCase() {
		supplier.setId("Birthday1");
		supplier.setName("Birthday flowers");
		supplier.setAddress("Hyderabad");

		boolean flag = supplierDAO.save(supplier);

		assertEquals("createSupplierTestCase", true, flag);

	}

	/*@Test
	public void updateSupplierTestCase() {
		supplier.setId("Birthday2");
		supplier.setName("Birthdays);
		supplier.setAddress("Vizag");

		boolean flag = supplierDAO.update(supplier);

		assertEquals("updateSupplierTestCase", true, flag);

	}

	@Test
	public void listAllSupplierTestCase() {
		int actualSize = supplierDAO.list().size();
		assertEquals(6, actualSize);
	}*/

}
