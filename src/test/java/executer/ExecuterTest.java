package executer;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import com.lowagie.text.DocumentException;

import model.*;
import persistence.TypeFinder;
import persistence.UserFinder;
import persistence.util.Jpa;

public class ExecuterTest {

	@Test
	public void testActionSingleton() throws FileNotFoundException, DocumentException, IOException {
		ActionSingleton aS = ActionSingleton.getInstance();
		ActionSingleton aS2 = ActionSingleton.getInstance();
		
		assertEquals(aS, aS2);
		
		Date date = new Date(System.currentTimeMillis());
		User user = new User("Paco", "Francisco", "francisco@gmail.com", date, "C\\Uría", "Español", "87654321P");
		Type type = new Type(3, "Sensor");
		
		aS.getAF().saveData(user);
		aS.getAF().saveType(type);
		
		EntityManager mapper = Jpa.createEntityManager();
		EntityTransaction trx = mapper.getTransaction();
		trx.begin();
		
		User user2 = UserFinder.findByEmail("francisco@gmail.com").get(0);
		Type type2 = TypeFinder.findByCode(3).get(0);
		
		assertEquals(user, user2);
		assertEquals(type, type2);
		
		trx.commit();
		
	}


}
