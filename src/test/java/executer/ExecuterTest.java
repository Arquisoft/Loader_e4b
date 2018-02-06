package executer;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

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
		
		User user1 = new User("Paco", "-22.971436, -43.182565", "francisco@gmail.com", "87654321P");
		Type type = new Type(3, "Sensor");
		
		aS.getAF().saveType(type);
		aS.getAF().saveData(user1, "3");	
		
		EntityManager mapper = Jpa.createEntityManager();
		EntityTransaction trx = mapper.getTransaction();
		trx.begin();
		
		User user2 = UserFinder.findByIdent("87654321P").get(0);
		Type type2 = TypeFinder.findByCode(3).get(0);
		
		assertEquals(user1, user2);
		assertEquals(type, type2);
		
		trx.commit();
		
	}


}
