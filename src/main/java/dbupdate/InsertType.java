package dbupdate;

import java.util.List;

import model.Type;

/**
 * Gestiona la conexión con la base de datos a la hora de insertar tipos.
 * @author Alejandro García parrondo
 */
public interface InsertType {
	
	/**
	 * Guarda un tipo de usuario en la base de datos.
	 * @param tipo a guardar.
	 * @return Retorna el tipo guardado.
	 */
	Type save(Type tipo);
	
	/**
	 * Devuelve los tipos de datos de la base de datos con el código dado.
	 * @param codigo a buscar en la base de datos.
	 * @return Lista de tipos con el código dado.
	 */
	List<Type> findByCode(int codigo);
	
	/**
	 * Devuelve los tipos de datos de la base de datos con el nombre dado.
	 * @param tipo a buscar en la base de datos.
	 * @return Lista de tipos con el nombre dado.
	 */
	List<Type> findByType(String tipo);
}
