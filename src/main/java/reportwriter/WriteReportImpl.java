package reportwriter;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que imprime por pantalla mensajes dados con un nivel de identificacion.
 */
public class WriteReportImpl implements WriteReport {

	private Logger logger = Logger.getLogger("Logger");
	
	@Override
	public void log(Level lv, String msg) {
		logger.log(lv, msg);
	}

	/**
	 * Devuelve la instancia del logger.
	 * @return La instancia del logger usado.
	 */
	public Logger getLogger(){
		return logger;
	}
}
