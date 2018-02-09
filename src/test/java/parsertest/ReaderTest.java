package parsertest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import parser.*;
import parser.reader.CSVReader;
import parser.reader.ReadList;
import parser.reader.XLSXReader;
import persistence.UserFinder;
import persistence.util.Jpa;

import static org.junit.Assert.*;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.junit.After;
import org.junit.Test;

import com.lowagie.text.DocumentException;
import model.User;

public class ReaderTest {

	@Test
	public void testLoadExcelExito() throws FileNotFoundException, DocumentException {
		ReadList ex = new XLSXReader();
		ex.load("src/test/resources/test.xlsx");

		assertEquals(ex.getLoadedList().size(), 3);

		String list1 = ex.getLoadedList().get(0);
		String list2 = ex.getLoadedList().get(1);
		String list3 = ex.getLoadedList().get(2);

		assertEquals(list1, "Juan Torres Pardo,22.971436; -43.182565,juan@example.com,87654321P");
		assertEquals(list2, "Luis López Fernando,32.97; -23.1,luis@example.com,19160962F");
		assertEquals(list3, "Ana Torres Pardo,21.26; 50.26,ana@example.com,09940449X");
	}
	
	@Test
	public void testLoadCSVExito() throws FileNotFoundException, DocumentException {
		ReadList master = new CSVReader();
		master.load("src/test/resources/master.csv");
		
		assertEquals(master.getLoadedList().size(), 3);
		
		String[] test = {
				"1,Person",
				"2,Entity",
				"3,Sensor"};
		
		for(int i=0;i<master.getLoadedList().size();i++)
			assertEquals(test[i],master.getLoadedList().get(i));
	}

	@Test(expected = FileNotFoundException.class)
	public void testLoadExcelFicheroNoEncontrado() throws FileNotFoundException, DocumentException {
		ReadList ex = new XLSXReader();
		ex.load("src/test/resources/fallo.xlsx");

		assertEquals(ex.getLoadedList().size(), 3);

		String list1 = ex.getLoadedList().get(0);
		String list2 = ex.getLoadedList().get(1);
		String list3 = ex.getLoadedList().get(2);

		assertEquals(list1, "Juan Torres Pardo juan@example.com " + "español" + " C/ Federico García Lorca 2 Español 90500084Y ");

		assertEquals(list2, "Luis López Fernando luis@example.com " + "español" + " C/ Real Oviedo 2 Español 19160962F ");

		assertEquals(list3, "Ana Torres Pardo ana@example.com " + "español" + " Av. De la Constitución 8 Español 09940449X ");
	}
	
	@Test (expected = FileNotFoundException.class)
	public void testLoadCSVNoEncontrado() throws FileNotFoundException, DocumentException {
		ReadList master = new XLSXReader();
		master.load("src/test/resources/fallo.csv");
		
		assertEquals(master.getLoadedList().size(), 0);
	}

	@Test(expected = IOException.class)
	public void testLoadExcelErrorExcel() throws IOException, DocumentException {
		ReadList ex = new XLSXReader();
		ex.load("src/test/resources/vacio.xlsx");

		assertEquals(ex.getLoadedList().size(), 3);

		String list1 = ex.getLoadedList().get(0);
		String list2 = ex.getLoadedList().get(1);
		String list3 = ex.getLoadedList().get(2);

		assertEquals(list1,
				"Juan Torres Pardo juan@example.com 10-oct-1985 C/ Federico García Lorca 2 Español 90500084Y ");

		assertEquals(list2,
				"Luis López Fernando luis@example.com 02-mar-1970 C/ Real Oviedo 2 Español 19160962F ");

		assertEquals(list3,
				"Ana Torres Pardo ana@example.com 01-ene-1960 Av. De la Constitución 8 Español 09940449X ");
	}

	@Test
	public void testReaderSingleton() throws DocumentException {
		ReaderSingleton rS = ReaderSingleton.getInstance();
		rS.loadFile("cadenaIncorrecta");
		rS.loadFile("test.xlsx");
		ReaderSingleton rS1 = ReaderSingleton.getInstance();
		rS1.loadFile("cadenaIncorrecta");
		rS1.loadFile("test.xlsx");
		assertEquals(rS, rS1);
	}
	
	@Test
	public void testReaderSingletonMaster() {
		ReaderSingleton rS = ReaderSingleton.getInstance();
		rS.loadMasterFile("cadenaIncorrecta");
		rS.loadMasterFile("master.csv");
		ReaderSingleton rS1 = ReaderSingleton.getInstance();
		rS1.loadMasterFile("cadenaIncorrecta");
		rS1.loadMasterFile("master.csv");
		assertEquals(rS, rS1);
	}

	@After
	public void deleting() {
		EntityManager mapper = Jpa.createEntityManager();
		EntityTransaction trx = mapper.getTransaction();
		trx.begin();
		List<User> aBorrar = UserFinder.findByIdent("09940449X");
		if (!aBorrar.isEmpty())
			Jpa.getManager().remove(aBorrar.get(0));

		aBorrar = UserFinder.findByIdent("19160962F");
		if (!aBorrar.isEmpty())
			Jpa.getManager().remove(aBorrar.get(0));

		aBorrar = UserFinder.findByIdent("90500084Y");
		if (!aBorrar.isEmpty())
			Jpa.getManager().remove(aBorrar.get(0));

		trx.commit();
		mapper.close();

	}
}
