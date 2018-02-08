package parser.cartas;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.lowagie.text.DocumentException;

import model.User;

/**
 * Clase abstracta para implementar un metodo de escritura de cartas para un usuario dado.
 */
public abstract class Letter {
	/**
	 * Escribe una carta de error para un usuario dado.
	 * @param user al que escribirle la carta.
	 * @throws DocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public abstract void createLetter(User user) throws DocumentException, FileNotFoundException, IOException;
}
