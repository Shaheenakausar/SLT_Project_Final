package com.niit.bouquet_backend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDAO;
import com.niit.dao.SupplierDAO;
import com.niit.model.Product;
import com.niit.model.Supplier;

public class ProductDAOTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static ProductDAO productDAO;
	@Autowired
	static Product product;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//get the categoryDAO from context
		productDAO =  (ProductDAO) context.getBean("productDAO");
		
		//get the category from context
		product = (Product)context.getBean("product");
		
	}
	
	@Test
	public void createProductTestCase()
	{
		
		product.setId("Birthday");
		product.setCategory_id("Birthday1");
		product.setDescription("good colors");
		product.setName("Birthday");
		product.setPrice(1445);
		product.setQuantity(2);
		product.setSupplier_id("Shaheena");
		
		boolean flag =  productDAO.saveOrUpdate(product);

		assertEquals("createProductTestCase",true,flag);
		
	}
	/*@Test
	public void updateCategoryTestCase()
	{
		product.setId("Birthday");
		product.setName("Birthday1");
		product.setDescription("good");
		product.setCategory_id("Birthday");
		product.setPrice(1499);
		product.setSupplier_id("Shaheena");
		product.setQuantity(4);
		boolean flag = productDAO.saveOrUpdate(product);
		assertEquals("update Product TestCase",true,flag);
	}
	@Test
	public void listAllProductTestCase()
	{
		int actualSize = productDAO.list().size();
		assertEquals(2, actualSize);
	} */
}
