package model;

/**
 * Clase que implementa los métodos de la interfaz InsertType para encargarse de la gestión de tipos.
 * @author Ángela Val Cadena
 */
public class Association {

	/**
	 * Clase que se encarga de asignarle a los usuarios (User) un tipo específico (Type).
	 * @author Ángela Val
	 *
	 */
	public static class Clasificar {

		/**
		 * Método que asocia el tipo pasado por parámetro al cliente dado.
		 * @param tipo tipo del usuario. Tipo Type.
		 * @param usuario usuario al que se le quiere asignar un tipo. Tipo User
		 */
		public static void link(Type tipo, User usuario) {
			tipo._getUsuarios().add(usuario);
			usuario._setTipo(tipo);		
		}
	}
	
}
