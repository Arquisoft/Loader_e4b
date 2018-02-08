package executer;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.lowagie.text.DocumentException;

import model.*;

public interface ActionFacade {
	/**
	 * Guarda un usuario en la base de datos.
	 * @param user a guardar.
	 * @param tipo del usuario.
	 * @throws FileNotFoundException
	 * @throws DocumentException
	 * @throws IOException
	 */
	public void saveData(User user, String tipo) throws FileNotFoundException, DocumentException, IOException;
	
	/**
	 * Guarda un tipo de usuario en la base de datos.
	 * @param type a guardar.
	 */
	public void saveType(Type type);
	// public void verifySecurity();  Esto es una ampliacion opcional y no se en que consiste
}