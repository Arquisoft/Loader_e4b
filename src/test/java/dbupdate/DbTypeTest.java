package dbupdate;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Before;
import org.junit.Test;

import executer.ActionSingleton;
import model.Type;
import persistence.TypeFinder;
import persistence.util.Jpa;

public class DbTypeTest {

	@Test
	public void ComprobarCargaTipo() {
		ActionSingleton aS = ActionSingleton.getInstance();

		Type type = new Type(1, "Usuario");
		Type type2 = new Type(2, "Entity");

		aS.getAF().saveType(type);
		aS.getAF().saveType(type2);

		EntityManager mapper = Jpa.createEntityManager();
		EntityTransaction trx = mapper.getTransaction();
		trx.begin();

		List<Type> test = TypeFinder.findByType("Usuario");
		assertEquals(test.get(0).getType(), "Usuario");
		
		List<Type> test2 = TypeFinder.findByType("Entity");
		assertEquals(test2.get(0).getType(), "Entity");

		trx.commit();
		mapper.close();
	}
	
	@Test
	public void ComprobarBorrado() {
		ActionSingleton aS = ActionSingleton.getInstance();

		Type type = new Type(999, "Prueba");

		aS.getAF().saveType(type);

		EntityManager mapper = Jpa.createEntityManager();
		EntityTransaction trx = mapper.getTransaction();
		trx.begin();
		
		List<Type> toDelete = TypeFinder.findByCode(999);
		assertEquals(toDelete.size(), 1);
		
		Jpa.getManager().remove(toDelete.get(0));
		toDelete = TypeFinder.findByCode(999);
		assertTrue(toDelete.isEmpty());
		
		trx.commit();
		mapper.close();
	}

	
}
