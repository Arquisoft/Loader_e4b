package modeltest;

import static org.junit.Assert.*;

import org.junit.Test;
import model.Type;


public class TypeTest {

	@Test
	public void testEquals() {
		Type type = new Type(1, "Usuario");
		Type type2 = new Type(1, "Usuario");
		Type type3 = new Type(2, "Usuario");
		Type type4 = new Type(1, "NoUsuario");
		
		assertEquals(type,type2);
		assertNotEquals(type,type3);
		assertNotEquals(type,type4);
	}
	
	@Test
	public void testHashCode() {
		Type type = new Type(1, "Usuario");
		Type type2 = new Type(1, "Usuario");
		Type type3 = new Type(2, "Usuario");
		Type type4 = new Type(1, "NoUsuario");
		
		assertEquals(type.hashCode(), type2.hashCode());
		assertNotEquals(type.hashCode(), type3.hashCode());
		assertNotEquals(type.hashCode(), type4.hashCode());
	}
	
	@Test
	public void testToString() {
		Type type = new Type(1, "Usuario");
		
		String resultado = "Tipo [code=1, type=Usuario]";
		
		assertEquals(type.toString(), resultado);
	}
	
}
