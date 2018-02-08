package executer;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.lowagie.text.DocumentException;

import model.*;

public interface ActionFacade {
	public void saveData(User user, String tipo) throws FileNotFoundException, DocumentException, IOException;
	public void saveType(Type type);
	// public void verifySecurity();  Esto es una ampliacion opcional y no se en que consiste
}