package dbupdate;

import java.util.List;

import model.Type;
import persistence.TypeFinder;

/**
 * Clase que implementa los métodos de la interfaz InsertType para encargarse de la gestión de tipos.
 * @author Alejandro García Parrondo
 */
public class InsertT implements InsertType{

	@Override
	public Type save(Type tipo) {
		// TODO Auto-generated method stub
		return null;
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
