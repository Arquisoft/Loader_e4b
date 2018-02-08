package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase para gestionar los usuarios de la base de datos.
 */
@Entity
@Table(name = "Users")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	private String email;
	
	@Column(unique = true)
	private String identificador;
	
	private String username;
	
	private String password;
	
	private String localizacion;
	
	@ManyToOne private Type tipo;

	User() {
	}
	
	/**
	 * Constructor minimo de la clase User. Crea un objeto User 
	 * asociandole el identificador pasado por parámetro.
	 * @param identificador identificador del usuario. Tipo String
	 */
	public User(String identificador) {
		this.identificador = identificador;
	}

	/**
	 * Constructor de la clase User. Crea un objeto User y le asocia 
	 * un nombre, localizacion, email e identificador dados. Además, 
	 * establece el identificador como nombre de usuario y se genera una 
	 * contraseña.
	 * @param nombre nombre del usuario. Tipo String
	 * @param localizacion localización en la que se encuentra el usuario. 
	 * Este campo es opcional para usuarios de tipo Entity y Person
	 * @param email Correo electrónico de contacto. En el caso de sensores 
	 * u otro tipo de agentes automáticos, puede ser el correo electrónico 
	 * de la persona que lo administra.
	 * @param identificador Identificador del agente. En caso de personas 
	 * físicas o entidades puede ser el CIF. Este identificador será único 
	 * en el sistema y será el nombre de usuario. 
	 */
	public User(String nombre, String localizacion, String email, String identificador) {
		this(identificador); 
		setNombre(nombre);
		setEmail(email);
		setUsername(identificador);
		setLocalizacion(localizacion);
		generarPassword();
	}
	
	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	private void setLocalizacion(String loc) {
		this.localizacion = loc;
	}
	
	public String getLocalizacion() {
		return this.localizacion;
	}

	public String getIdentificador() {
		return identificador;
	}
	
	public String getEmail() {
		return email;
	}

	private void setEmail(String email) {
		this.email = email;
	}
	
	public Type getTipo() {
		return tipo;
	}

	private void setPassword(String password) {
		this.password = password;
	}

	private void setUsername(String username) {
		this.username = username;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identificador == null) ? 0 : identificador.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (identificador == null) {
			if (other.identificador != null)
				return false;
		} else if (!identificador.equals(other.identificador))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nombre=" + nombre + ", email=" + email + ", identificador=" + identificador
				+ ", username=" + username + ", localizacion=" + localizacion + ", tipo=" + tipo + "]";
	}

	/**
	 * Método que genera una contraseña para el usuario.
	 */
	private void generarPassword() {
		StringBuffer pass = new StringBuffer();
		int low = 65;
		int top = 90;
		for (int i = 0; i < 9; i++) {
			int numAleatorio = (int) Math.floor(Math.random() * (top - low) + low);
			pass.append((char) numAleatorio);
		}
		for (int i = 0; i < 3; i++) {
			int numAleatorio = (int) Math.floor(Math.random() * (9 - 0) + 0);
			pass.append(numAleatorio);
		}
		setPassword(pass.toString());
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	void _setTipo(Type tipo) {
		this.tipo = tipo;	
	}

}
