package test;

import static org.junit.Assert.*;
import model.Shoppinguser;

import org.junit.Test;

import dao.UserDB;


public class DBUserTest
{
	public void testInsert()
	{
		Shoppinguser user = new Shoppinguser();
		user.setEmail("admin@infosys.com");
		user.setPassword("admin");
		user.setUsername("admin");
		user.setCredit(50);
		
		UserDB.insert(user);
	}
	
	@Test
	public void testUpdateCredit()
	{
		Shoppinguser user = UserDB.getUserByID(2);
		user.setCredit(50);
		
		UserDB.update(user);
	}
	
//	@Test
	public void testLogin()
	{		
		System.out.println(UserDB.checkLogin("admin", "admin"));
	}

	
//	@Test
	public void testIsAvailable()
	{
		Shoppinguser user = new Shoppinguser();
		
		user.setUsername("admin");
		user.setEmail("admin@infosys.com");
		assertFalse(UserDB.isAvailable(user));
		
		user.setUsername("admin2");
		user.setEmail("admin@infosys.com");
		assertFalse(UserDB.isAvailable(user));
		
	}
}
