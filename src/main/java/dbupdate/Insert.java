package dbupdate;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.lowagie.text.DocumentException;

import model.User;

/**
 * 
 * @author Ignacio Escribano Burgos
 * Gestiona la conexión con la base de datos
 *
 */
public interface Insert {
	/**
	 * Guarda un usuario en la base de datos.
	 * @param user a guardar.
	 * @param tipo del usuario.
	 * @return Usuario devuelto desde el sistema de persistencia.
	 * @throws FileNotFoundException
	 * @throws DocumentException
	 * @throws IOException
	 */
	User save(User user, String tipo) throws FileNotFoundException, DocumentException, IOException;
	
	/**
	 * Devuelve la lista de usuarios con un dni dado.
	 * @param dni a buscar.
	 * @return Lista de usuarios con el dni dado.
	 */
	List<User> findByDNI(String dni);

}
