package parser.cartas;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import model.User;

public class PdfLetter extends Letter{
	
	@Override
	public  void createLetter(User user) throws DocumentException, FileNotFoundException{
		FileOutputStream letter = null;
		letter = new FileOutputStream(
				"cartas/pdf/" + user.getIdentificador() + ".pdf");
		Document document = new Document();
		PdfWriter.getInstance(document, letter);
		document.open();
		document.add(new Paragraph("Usuario: " + user.getUsername()
				+ "\n Password: " + user.getPassword()));
		document.close();
	}
}
