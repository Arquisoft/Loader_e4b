package dbupdate;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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
		
		List<Type> test = TypeFinder.findByCode(1);
		assertEquals(test.get(0).getType(), "Usuario");
		
		List<Type> test2 = TypeFinder.findByType("Entity");
		assertEquals(test2.get(0).getCode(), 2);

		trx.commit();
		mapper.close();
		
	}
	
}
