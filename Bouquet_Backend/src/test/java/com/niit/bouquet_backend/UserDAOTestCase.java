package com.niit.bouquet_backend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDAO;
import com.niit.model.User;

public class UserDAOTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static UserDAO userDAO;

	@Autowired
	static User user;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		userDAO = (UserDAO) context.getBean("userDAO");

		user = (User) context.getBean("user");

	}

	@Test
	public void createUserTestCase() {
		user.setId("Shannu");
		user.setName("Shannu");
		user.setPassword("Shannu");
		user.setRole("ROLE_USER");
		user.setContact("9876543210");
		boolean flag = userDAO.save(user);

		assertEquals("createUserTestCase", true, flag);

	}

	/*@Test
	public void updateUserTestCase() {
		user.setId("Kausar");
		user.setName("Kausar");
		user.setPassword("52");
		user.setRole("ROLE_ADMIN");
		user.setContact("8877665544");
		boolean flag = userDAO.update(user);

		assertEquals("updateUserTestCase", true, flag);

	}

	@Test
	public void validateUserTestCase() {

		boolean flag = userDAO.validate("Shannu", "Shannu");
		assertEquals(true, flag);

	}
*/
	
	@Test
	public void listAllUserTestCase() {
		int actualSize = userDAO.list().size();
		assertEquals(5, actualSize);
	}

}
