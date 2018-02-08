package parser;

import java.io.FileNotFoundException;

import com.lowagie.text.DocumentException;

/**
 * Clase para implementar un metodo para la lectura de ficheros.
 */
public interface ReadList {
	
	/**
	 * Dado un fichero lee su contenido para poder operar con el.
	 * @param path del fichero.
	 * @throws FileNotFoundException En caso de que no se encuentre el fichero.
	 * @throws DocumentException En caso de que haya un error escribiendo las cartas.
	 */
	public void load(String path) throws FileNotFoundException, DocumentException;
}
