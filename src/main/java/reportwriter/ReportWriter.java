package reportwriter;

/**
 * Clase singleton que tiene una instancia de WriteReport para escribir mensajes por pantalla.
 */
public class ReportWriter {
	private static ReportWriter instance;
	private WriteReport wR = new WriteReportImpl();
	
	private ReportWriter() {
	}
	
	/**
	 * Devuelve la unica instancia de esta clase.
	 * @return La instancia de esta clase.
	 */
	public static ReportWriter getInstance() {
		if(instance == null) instance = new ReportWriter();
		return instance;
	}
	
	/**
	 * Devuelve el logger de la aplicacion.
	 * @return El logger de la aplicacion.
	 */
	public WriteReport getWriteReport() {
		return wR;
	}
	
	
}
