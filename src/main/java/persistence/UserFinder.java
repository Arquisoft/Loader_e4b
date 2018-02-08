package persistence;

import java.util.List;
import model.User;
import persistence.util.Jpa;

public class UserFinder {

	public static List<User> findByIdent(String id) {
		return Jpa.getManager().createNamedQuery("User.findByIdent", User.class).
				setParameter(1, id).getResultList();
	}

}
