package parser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.lowagie.text.DocumentException;

import dbupdate.Insert;
import dbupdate.InsertP;
import model.User;
import persistence.UserFinder;

/**
 * Clase que gestiona los usuarios de la base de datos.
 */
public class InsertR implements Insert {

	@Override
	public User save(User user, String tipo) throws FileNotFoundException, DocumentException, IOException {
		return new InsertP().save(user, tipo);
	}

	@Override
	public List<User> findByDNI(String dni) {
		return UserFinder.findByIdent(dni);
	}
}
