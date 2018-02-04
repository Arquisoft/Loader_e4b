package dbupdate;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import model.Type;
import persistence.TypeFinder;
import persistence.util.Jpa;
import reportwriter.ReportWriter;

/**
 * Clase que implementa los métodos de la interfaz InsertType para encargarse de la gestión de tipos.
 * @author Alejandro García Parrondo
 */
public class InsertT implements InsertType{

	@Override
	public Type save(Type tipo) {
		EntityManager mapper = Jpa.createEntityManager();
		EntityTransaction trx = mapper.getTransaction();
		trx.begin();

		try {
			List<Type> toDelete = findByCode(tipo.getCode());
			for(int i=0;i<toDelete.size();i++)
				Jpa.getManager().remove(toDelete.get(i));
			
			Jpa.getManager().persist(tipo);
			trx.commit();
		}
		catch (PersistenceException ex) {
			ReportWriter.getInstance().getWriteReport().log(Level.WARNING, "Error de la BBDD");
			if (trx.isActive())
				trx.rollback();
		} finally {
			if (mapper.isOpen())
				mapper.close();
		}

		return tipo;
	}

	@Override
	public List<Type> findByCode(int codigo) {
		return TypeFinder.findByCode(codigo);
	}

	@Override
	public List<Type> findByType(String tipo) {
		return TypeFinder.findByType(tipo);
	}

}
