package parser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

import com.lowagie.text.DocumentException;

import parser.reader.ReadList;
import reportwriter.ReportWriter;

public class ReaderSingleton {
	private static ReaderSingleton instance;
	private Parser loader;
	private Parser master;

	/**
	 * Constructor privado para construir un patron singleton.
	 */
	private ReaderSingleton() {
		this.master = new MasterParser();
	}

	/**
	 * Crea una instancia de la clase para el patron singleton.
	 * @return El unico objeto de la clase.
	 */
	public static ReaderSingleton getInstance() {
		if (instance == null)
			instance = new ReaderSingleton();
		return instance;
	}

	/**
	 * Carga el fichero de usuarios.
	 * @param cad: ruta donde esta el fichero.
	 * @throws DocumentException en caso de que haya error escribiendo las cartas.
	 */
	public void loadFile(String cad) throws DocumentException {
		try{
			setLoader(cad);
			loader.parse(cad);
		}catch (IOException e) {
			System.err.println("No se ha encontrado el archivo especificado.");
			ReportWriter.getInstance().getWriteReport().log(Level.WARNING, "No se ha encontrado el archivo");
		}
	}
	
	/**
	 * Carga el fichero de tipos.
	 * @param cad: ruta donde esta el fichero.
	 */
	public void loadMasterFile(String cad) {
		try {
			master.parse(cad);
		}catch (IOException e) {
			System.err.println("No se ha encontrado el archivo csv especificado.");
			ReportWriter.getInstance().getWriteReport().log(Level.WARNING, "No se ha encontrado el archivo csv");
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Selecciona el modo en el que se van a leer los documentos xlsx o csv
	 * @param cad: ruta donde esta el fichero.
	 */
	private void setLoader(String cad) {
		String[] linea = cad.split("\\.");
		String extension = linea[linea.length -1];
		loader = new UserParser(extension);
	}
	
}
