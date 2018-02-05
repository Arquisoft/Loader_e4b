package model;

/**
 * Clase que implementa los métodos de la interfaz InsertType para encargarse de la gestión de tipos.
 * @author Ángela Val Cadena
 */
public class Association {

	public static class Clasificar {

		public static void link(Type tipo, User usuario) {
			tipo._getUsuarios().add(usuario);
			usuario._setTipo(tipo);		
		}

//		public static void unlink(Type tipo, User usuario) {
//			usuario._setTipo(null);
//			tipo._getUsuarios().remove(usuario);
//		}
	}
	
}
