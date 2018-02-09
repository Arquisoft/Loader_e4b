package parser.reader;

import java.io.FileNotFoundException;
import java.util.List;

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
	List<String> load(String path) throws FileNotFoundException, DocumentException;

	/**
	 * Devuelve la lista con las lineas que se leyeron la última vez.
	 * @return Una lista de strings con lo leido la última vez.
	 */
	List<String> getLoadedList();
}
