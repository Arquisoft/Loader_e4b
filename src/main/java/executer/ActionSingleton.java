package executer;

public class ActionSingleton {
	private ActionFacade aF;
	private static ActionSingleton instance;
	
	/**
	 * Constructor privado para el patron singleton.
	 */
	private ActionSingleton() {
		this.aF = new ActionFacadeClass();
	}

	/**
	 * Devuelve la instancia de la clase singleton.
	 * @return La unica instancia de la clase.
	 */
	public static ActionSingleton getInstance() {
		if (instance == null)
			instance = new ActionSingleton();
		return instance;
	}
	
	/**
	 * Retorna la instancia de action facade de la clase.
	 * @return La instancia de action facade.
	 */
	public ActionFacade getAF() {
		return aF;
	}
}
