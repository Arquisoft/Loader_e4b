package parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import com.lowagie.text.DocumentException;

import dbupdate.InsertT;
import executer.ActionFacade;
import executer.ActionFacadeClass;
import model.Type;
import reportwriter.ReportWriter;

public class RMaster implements ReadList{
	private ActionFacade aF = new ActionFacadeClass();
	private ArrayList<Type> allTypes = new ArrayList<Type>();

	@Override
	public void load(String path) throws FileNotFoundException, DocumentException {
		BufferedReader br = null;
		String line = "";
		int i = 0;
		
		try {
			
			br = new BufferedReader(new FileReader(path));
			while ((line = br.readLine()) != null) {
				String[] tipo = line.split(",");
				Type type = crearTipo(tipo);
				allTypes.add(type);
				i++;
			}

		} 
		catch (FileNotFoundException e) {
			throw e;
		} 
		catch (IOException e) {
			System.err.println("Problema con la lectura del excel en la linea " + i);
			ReportWriter.getInstance().getWriteReport().log(Level.WARNING, "Problema con la lectura del excel en la linea " + i);
		} 
		finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
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
