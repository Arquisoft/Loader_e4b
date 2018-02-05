package dbupdate;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import com.lowagie.text.DocumentException;

import model.Association;
import model.Type;
import model.User;
import parser.cartas.Letter;
import parser.cartas.PdfLetter;
import parser.cartas.TxtLetter;
import parser.cartas.WordLetter;
import persistence.TypeFinder;
import persistence.UserFinder;
import persistence.util.Jpa;
import reportwriter.ReportWriter;

public class InsertP implements Insert {

	@Override
	public User save(User user, String tipo) throws FileNotFoundException, DocumentException, IOException {
		EntityManager mapper = Jpa.createEntityManager();
		EntityTransaction trx = mapper.getTransaction();
		trx.begin();
		try {
			List<Type> tipos = TypeFinder.findByCode(Integer.parseInt(tipo));
			if (!UserFinder.findByIdent(user.getIdentificador()).isEmpty()) {
				ReportWriter.getInstance().getWriteReport().log(Level.WARNING,
						"El usuario con el dni " + user.getIdentificador() + " ya existe en la base de datos");
				trx.rollback();
			}else if (tipos.isEmpty()) {
				ReportWriter.getInstance().getWriteReport().log(Level.WARNING,
						"Tipo de usuario " + user.getTipo().getType() + " no reconocido");
				trx.rollback();
			}else {
				Jpa.getManager().persist(user);
				Association.Clasificar.link(tipos.get(0) , user);
				trx.commit();
				Letter letter = new PdfLetter();
				letter.createLetter(user);
				letter = new TxtLetter();
				letter.createLetter(user);
				letter = new WordLetter();
				letter.createLetter(user);
			}
		} catch (PersistenceException ex) {
			ReportWriter.getInstance().getWriteReport().log(Level.WARNING, "Error de la BBDD");
			if (trx.isActive())
				trx.rollback();
		} finally {
			if (mapper.isOpen())
				mapper.close();
		}
		return user;
	}

	@Override
	public List<User> findByDNI(String dni) {
		return UserFinder.findByIdent(dni);
	}

//	@Override
//	public List<User> findByEmail(String email) {
//		return UserFinder.findByEmail(email);
//	}

}
