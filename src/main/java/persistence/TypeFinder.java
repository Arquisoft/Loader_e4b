package persistence;

import java.util.List;

import model.Type;
import persistence.util.Jpa;

/**
 * Clase para ejecutar las querys preparadas para los tipos.
 * @author Alejandro García Parrondo
 */
public class TypeFinder {
	
	/**
	 * Ejecuta una query preparada para encontrar los tipos con un código dado como parámetro.
	 * @param codigo a buscar en la tabla de tipos.
	 * @return Una lista con todos los tipos con el código dado.
	 */
	public static List<Type> findByCode(int codigo){
		return Jpa.getManager().createNamedQuery("Type.findByCode", Type.class).
				setParameter(1, codigo).getResultList();
	}
	
	/**
	 * Ejecuta una query preparada para encontrar los tipos con un nombre dado como parámetro.
	 * @param tipo a buscar en la tabla de tipos.
	 * @return Una lista con todos los tipos con el nombre dado.
	 */
	public static List<Type> findByType(String tipo){
		return Jpa.getManager().createNamedQuery("Type.findByType", Type.class).
				setParameter(1, tipo).getResultList();
	}
	
}
