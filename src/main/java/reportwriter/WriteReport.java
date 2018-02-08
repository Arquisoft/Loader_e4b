package reportwriter;

import java.util.logging.Level;

/**
 * Interfaz a implementar para imprimir mensajes por pantalla.
 */
public interface WriteReport {

	/**
	 * Imprime por pantalla un mensaje dado con un nivel de identificacion.
	 * @param lv de identificacion.
	 * @param msg a escribir.
	 */
	void log(Level lv, String msg);
	
}
