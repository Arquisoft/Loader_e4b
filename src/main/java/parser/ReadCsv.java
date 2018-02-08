package parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;

import com.lowagie.text.DocumentException;

import reportwriter.ReportWriter;

public abstract class ReadCsv implements ReadList{

	@Override
	public void load(String path) throws FileNotFoundException, DocumentException {
		BufferedReader br = null;
		String line = "";
		int i = 0;
		
		try {			
			br = new BufferedReader(new FileReader(path));
			while ((line = br.readLine()) != null) {				
				addMethod(line);
				i++;
			}

		} 
		catch (FileNotFoundException e) {
			throw e;
		} 
		catch (IOException e) {
			System.err.println("Problema con la lectura del csv en la linea " + i);
			ReportWriter.getInstance().getWriteReport().log(Level.WARNING, "Problema con la lectura del csv en la linea " + i);
		} 
		finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	protected abstract void addMethod(String line) throws FileNotFoundException, DocumentException, IOException;

}
