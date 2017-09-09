package com.niit.bouquet_backend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;

public class CategoryDAOTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static CategoryDAO categoryDAO;

	@Autowired
	static Category category;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		// get the categoryDAO from context
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

		// get the category from context

		category = (Category) context.getBean("category");

	}

	@Test
	public void createCategoryTestCase() {
		category.setId("Birthday1");
		category.setName("Birthday");
		category.setDescription("Bouquet of flowers");

		boolean flag = categoryDAO.save(category);

		assertEquals("createCategoryTestCase", true, flag);

	}

	/*@Test
	public void updateCategoryTestCase() {
		category.setId("Birthday2");
		category.setName("BirthdayFlowers");
		category.setDescription("Bouquet of flowers");

		boolean flag = categoryDAO.update(category);

		assertEquals("updateCategoryTestCase", true, flag);

	}

	/*@Test
	public void deleteCategoryTestCase() {
		category.setName("APPLIANCES");
		boolean flag = categoryDAO.delete(category.getName());

		assertEquals("deleteCategoryTestCase", true, flag);

	}

	@Test
	public void listAllCategoryTestCase() {
		int actualSize = categoryDAO.list().size();
		assertEquals(7, actualSize);
	}*/

}
