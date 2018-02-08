package parser;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.lowagie.text.DocumentException;

import model.User;

public class RCsv extends ReadCsv{

	/**
	 * Crea el usuario con la informacion que se hapasado por parametro.
	 * @param line, informacion del usuario
	 */
	@Override
	protected void addMethod(String line) throws FileNotFoundException, DocumentException, IOException {
		String[] tipo = line.split(",");
		for(int i=0; i<tipo.length; i++) {
			System.out.print(tipo[i] + " ; "); 
		}
		System.out.println();
		crearUsuarios(tipo);
	}

	/**
	 * Crea un nuevo usuario para la base de datos y lo inserta en esta.
	 * @param list fila del fichero csv a operar.
	 * @throws FileNotFoundException 
	 * @throws DocumentException
	 * @throws IOException
	 */
	private void crearUsuarios(String[] list) throws FileNotFoundException, DocumentException, IOException {
		User user = new User(list[0]
				,list[1]
				,list[2]
				,list[3]);
		
		
		InsertR insert = new InsertR();
		insert.save(user,"1");
	}
}
