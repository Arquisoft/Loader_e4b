package parser;

import java.io.FileNotFoundException;
import java.util.logging.Level;

import com.lowagie.text.DocumentException;

import reportwriter.ReportWriter;

public class ReaderSingleton {
	private static ReaderSingleton instance;
	private ReadList loader;
	private ReadList master;

	private ReaderSingleton() {
		this.loader = new RList();
		this.master = new RMaster();
	}

	public static ReaderSingleton getInstance() {
		if (instance == null)
			instance = new ReaderSingleton();
		return instance;
	}

	public void loadFile(String cad) throws DocumentException {
		try{
			loader.load(cad);
		}catch (FileNotFoundException e) {
			System.err.println("No se ha encontrado el archivo excel especificado.");
			ReportWriter.getInstance().getWriteReport().log(Level.WARNING, "No se ha encontrado el archivo excel");
		}
	}
	
	public void loadMasterFile(String cad) {
		try {
			master.load(cad);
		}catch (FileNotFoundException e) {
			System.err.println("No se ha encontrado el archivo csv especificado.");
			ReportWriter.getInstance().getWriteReport().log(Level.WARNING, "No se ha encontrado el archivo csv");
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
}
