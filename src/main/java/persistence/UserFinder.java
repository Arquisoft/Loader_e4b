package persistence;

import java.util.List;
import model.User;
import persistence.util.Jpa;

/**
 * Clase para ejecutar querys preparadas para los usuarios.
 */
public class UserFinder {

	/**
	 * Ejecuta la consulta preparada que busca a los usuarios que tienen un id dado.
	 * @param id a buscar entre los usuarios.
	 * @return Una lista con los usuarios con el id dado.
	 */
	public static List<User> findByIdent(String id) {
		return Jpa.getManager().createNamedQuery("User.findByIdent", User.class).
				setParameter(1, id).getResultList();
	}

//	public static List<User> findByEmail(String email) {
//		return Jpa.getManager().createNamedQuery("User.findByEmail", User.class).
//				setParameter(1, email).getResultList();
//	}
}
