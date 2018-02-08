package parser;

import java.util.ArrayList;
import java.util.List;

import dbupdate.InsertT;
import executer.ActionFacade;
import executer.ActionFacadeClass;
import model.Type;

public class RMaster extends ReadCsv{
	private ActionFacade aF = new ActionFacadeClass();
	private ArrayList<Type> allTypes = new ArrayList<Type>();

	/**
	 * Crea el tipo de usuario y lo agrega
	 * @param line, viene la informacion del identificador y tipo.
	 * 
	 */
	@Override
	protected void addMethod(String line) {
		String[] tipo = line.split(",");
		Type type = crearTipo(tipo);
		allTypes.add(type);
	}

	/**
	 * Dada una linea del fichero maestro crea un tipo y lo inserta en la base de datos.
	 * @param tipo a insertar en la base de datos.
	 * @return Tipo despues de la gestion de persistencia.
	 */
	private Type crearTipo(String[] tipo) {
		Type type = new Type(Integer.valueOf(tipo[0]), tipo[1]);
		new InsertT().save(type);
		return type;
	}

	/**
	 * Devuelve la instancia de action facade de la clase.
	 * @return Action facade de la clase.
	 */
	public ActionFacade getaF() {
		return aF;
	}

	/**
	 * Setter para colocar un action facade en la clase.
	 * @param aF a colocar.
	 */
	public void setaF(ActionFacade aF) {
		this.aF = aF;
	}
	
	/**
	 * Devuelve una lista con todas las filas del fichero maestro.
	 * @return Todas las filas del fichero maestro.
	 */
	public List<Type> getAllTypes(){
		return allTypes;
	}


}
