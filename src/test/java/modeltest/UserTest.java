package modeltest;

import static org.junit.Assert.*;


import model.User;

import org.junit.Test;

public class UserTest {

	@Test
	public void testEquals() {
		
		User user1 = new User("Dani", "-22.971436, -43.182565"
				, "email@gmail.com", "7777777R");
		
		User user2 = new User("Dani", "-22.971436, -43.182565"
				, "email@gmail.com", "7777777R");
		
		User user3 = new User("Dani", "-22.971436, -43.182565"
				, "email@gmail.com", "7787777R");
		
		User user4 = new User("Dani", "-22.971436, -43.182565"
				, "email@gmail.com", null);

		assertEquals(true, user1.equals(user2));
		assertEquals(false, user2.equals(user3));
		assertNotNull(user1);
		assertEquals(false, user4.equals(user3));
	}

	@Test
	public void testHashCode() {
		User user1 = new User("Dani", "-22.971436, -43.182565"
				, "email@gmail.com", "7777777R");
		
		User user2 = new User("Dani", "-22.971436, -43.182565"
				, "email@gmail.com", "7777777R");
		
		User user3 = new User("Dani", "-22.971436, -43.182565"
				, "email@gmail.com", "7787777R");
		
		User user4 = new User("Dani", "-22.971436, -43.182565"
				, "email@gmail.com", null);
		
		User user5 = new User("Dani", "-22.971436, -43.182565"
				, "email@gmail.com", null);

		assertEquals(user1.hashCode(), user2.hashCode());
		assertEquals(user4.hashCode(), user5.hashCode());
		assertNotEquals(user2.hashCode(), user3.hashCode());

		System.out.println(user1.toString());
	}

	@Test
	public void testAll() {
		User user1 = new User("Dani", "-22.971436, -43.182565"
				, "email@gmail.com", "7777777R");
		
		String password = user1.getPassword();
		String userName = user1.getUsername();
		String toString = "User [id=null, nombre=Dani, email=email@gmail.com, identificador=7777777R, "
				+ "username=7777777R, localizacion=-22.971436, -43.182565, tipo=null]";

		assertEquals("Dani", user1.getNombre());
		assertEquals("email@gmail.com", user1.getEmail());
		assertEquals("7777777R", user1.getIdentificador());
		assertEquals(password, user1.getPassword());
		assertEquals(userName, user1.getUsername());
		assertEquals(toString, user1.toString());
	}

}
