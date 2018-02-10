package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "UserType")
public class Type implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private int code;
	private String type;
	
	@OneToMany(mappedBy = "tipo")
	private Set<User> usuarios = new HashSet<User>();
	
	public Type(){}

	/**
	 * Constructor de la clase Type. Crea un objeto 
	 * al que se le asigna un código y un texto que identifica 
	 * el tipo de usuario.
	 * @param code codigo del tipo. Tipo int
	 * @param type nombre asociado al tipo. Tipo String
	 */
	public Type(int code, String type) {
		this.code = code;
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	
	@Override
	public String toString() {
		return "Type [code=" + code + ", type=" + type + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Type other = (Type) obj;
		if (code != other.code)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public Set<User> _getUsuarios() {
		return this.usuarios;
	}
	
	
	
}
