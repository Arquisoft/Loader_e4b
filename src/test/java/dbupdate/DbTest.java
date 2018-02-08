package dbupdate;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lowagie.text.DocumentException;

import executer.ActionSingleton;
import model.Type;
import model.User;
import persistence.UserFinder;
import persistence.util.Jpa;

public class DbTest {
	
	@Before
	public void setUp() {
		ActionSingleton aS = ActionSingleton.getInstance();
		
		Type type = new Type(1, "Usuario");
		Type type2 = new Type(2, "Entity");
		
		aS.getAF().saveType(type);
		aS.getAF().saveType(type2);
		
		EntityManager mapper = Jpa.createEntityManager();
		EntityTransaction trx = mapper.getTransaction();
		trx.begin();
		trx.commit();
		mapper.close();
	}

	@Test
	public void usuarioYaExistenteDni() throws FileNotFoundException, DocumentException, IOException {
		ActionSingleton aS = ActionSingleton.getInstance();
		
		User user1 = new User("Paco", "-22.971436, -43.182565", "francisco@gmail.com", "87654321P");
		User user2 = new User("Paco", "-22.971436, -43.182565", "francisco@gmail.com", "87654321P");

		aS.getAF().saveData(user1, "1");
		aS.getAF().saveData(user2, "1");

		EntityManager mapper = Jpa.createEntityManager();
		EntityTransaction trx = mapper.getTransaction();
		trx.begin();

		List<User> test = UserFinder.findByIdent("87654321P");
		assertTrue(test.size() == 1);
		assertFalse(test.isEmpty());

		trx.commit();
		mapper.close();
	}

	@Test
	public void usuarioConTipoNoValido() throws FileNotFoundException, DocumentException, IOException {
		ActionSingleton aS = ActionSingleton.getInstance();
		
		User user1 = new User("Paco", "-22.971436, -43.182565", "francisco@gmail.com", "87654321P");

		aS.getAF().saveData(user1, "4");

		EntityManager mapper = Jpa.createEntityManager();
		EntityTransaction trx = mapper.getTransaction();
		trx.begin();

		List<User> test = UserFinder.findByIdent("87654321P");
		assertTrue(test.isEmpty());

		trx.commit();
		mapper.close();
	}
	
	

	@After
	public void deleting() {
		EntityManager mapper = Jpa.createEntityManager();
		EntityTransaction trx = mapper.getTransaction();
		trx.begin();
		List<User> aBorrar = UserFinder.findByIdent("87654321P");
		
		if(!aBorrar.isEmpty()) {
			for(int i = aBorrar.size()-1; i >= 0; i--) {
				System.out.println(aBorrar.get(i));
				Jpa.getManager().remove(aBorrar.get(i));
			}	
		}
		trx.commit();
		mapper.close();
	}

}
