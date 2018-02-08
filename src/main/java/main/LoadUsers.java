package main;

import com.lowagie.text.DocumentException;

import parser.ReaderSingleton;

/**
 * Main application for the Loader module
 * 
 * @author Autores: 1A1
 * @author Actualizado por: e4b
 *
 */
public class LoadUsers {
	
	/**
	 * Metodo main de la aplicacion.
	 * @param args a comprobar en el metodo run.
	 * @throws DocumentException en caso de que haya problemas generando las cartas.
	 */
	public static void main(String... args) throws DocumentException {
		final LoadUsers runner = new LoadUsers();
		runner.run(args);
	}
	
	/**
	 * Metodo principal para ejecutar la aplicacion.
	 * @param args = <br>
	 * <b>--help</b> Ejecuta el metodo showHelp.<br>
	 * <b>info</b> Ejecuta el metodo showInfo. <br>
	 * <b>load</b> Carga un fichero de usuarios y un fichero de tipos de usuario.
	 * Los tipos de usuario se cargan automaticamente desde el fichero master.csv donde el estilo del csv es codigo,tipo.<br>
	 * Un ejemplo de tipos del csv seria 1,Usuario. 2,Entidad.<br>
	 * Un ejemplo de load seria load ruta/archivo.xlsx
	 * @throws DocumentException en caso de que haya problemas generando las cartas de error.
	 */
	private void run(String... args) throws DocumentException {
		if (args.length == 0 || args[0].equals("--help"))
			showHelp();
		else if (args[0].equals("info"))
			showInfo();
		else if (args[0].equals("load")) {
			if (args.length < 2)
				System.err.println(
						"La operación load necesita al menos otro " + "argumento con la ubicación del fichero");
			else {
				ReaderSingleton.getInstance().loadMasterFile("master.csv");
				
				for (int i = 1; i <= args.length - 1; i++)
					ReaderSingleton.getInstance().loadFile(args[i]);
			}
		}
		
	}
	
	/**
	 * Muestra informacion de la aplicacion.
	 */
	private void showInfo() {
		System.out.println("Proyecto Loader 4B");
		System.out.println("El objetivo de este proyecto es actuar como modulo de carga de"
				+ "usuarios para un sistema de participacion ciudadana");
		System.out.println("Realizado por el grupo 4B1 compuesto por: ");
		System.out.println("Alejandro García Parrondo (UO253144)");
		System.out.println("Juan Granda Molaguero (UO244759)");
		System.out.println("Ángela María Val Cadena (UO250972)");
		System.out.println("Samuel Steven Ludeña Vela (UO251461)");
		System.out.println("Óscar Marín Iglesias (UO251857)");
		System.out.println("Para mas informacion consultar el repositorio en github con la url "
				+ "https://github.com/Arquisoft/Loader_e4b");

	}
	
	/**
	 * Muestra una ayuda de la aplicacion.
	 */
	private void showHelp() {
		System.out.println("Manual de ayuda para el uso de la aplicacion");
		System.out.println("La aplicacion tiene implementadas las operaciones info, load y help");
		System.out.println("	info: Muestra informacion relacionada con el proyecto, como los autores");
		System.out.println(
				"	load [file]: Permite cargar un conjunto de ficheros excel con usuarios en la base de datos, para cargar los usuarios "
				+ "estos deben de tener tipos válidos que se cargan desde el fichero master.csv");
		System.out.println("	--help: Muestra este menu de ayuda. Si no se proporcionan parametros "
				+ "a la aplicacion se mostrara este menu");
	}
}
