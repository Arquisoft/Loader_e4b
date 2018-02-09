package parser.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import com.lowagie.text.DocumentException;

import reportwriter.ReportWriter;

public class CSVReader implements ReadList {

	private List<String> lineas;

	@Override
	public List<String> load(String path) throws FileNotFoundException{
		BufferedReader br = null;
		String line;
		lineas = new ArrayList<String>();
		int i = 0;
		
		try {			
			br = new BufferedReader(new FileReader(path));
			while ((line = br.readLine()) != null) {				
				lineas.add(line);
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

		return lineas;
	}

	@Override
	public List<String> getLoadedList() {
		return lineas;
	}


}
