package parser.reader;

import com.lowagie.text.DocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import reportwriter.ReportWriter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;

public class XLSXReader implements ReadList {

    private List<String> lines;

    @Override
    public List<String> load(String path) throws FileNotFoundException{
        InputStream excelFile = null;
        XSSFWorkbook excel = null;
        lines = new ArrayList<String>();
        List<List<XSSFCell>> allUsers = new ArrayList<List<XSSFCell>>();
        int i = 0;
        try {
            excelFile = new FileInputStream(path);
            excel = new XSSFWorkbook(excelFile);
            XSSFSheet sheet = excel.getSheetAt(0);
            XSSFRow row;
            XSSFCell cell;
            List<XSSFCell> user;
            Iterator<Row> rows = sheet.rowIterator();

            while (rows.hasNext()) {
                user = new ArrayList<XSSFCell>();
                row = (XSSFRow) rows.next();
                Iterator<Cell> cells = row.cellIterator();
                if (i > 0) {
                    while (cells.hasNext()) {
                        cell = (XSSFCell) cells.next();
                        user.add(cell);
                        System.out.print(cell.toString() + " ; ");
                    }
                    System.out.println();
                    lines.add( migrateToString(user) );
                }
                i++;
            }
        } catch(FileNotFoundException ex){
            throw ex;
        }
        catch (IOException ioe) {
            System.err.println("Problema con la lectura del excel en la linea " + i);
            ReportWriter.getInstance().getWriteReport().log(Level.WARNING, "Problema con la lectura del excel en la linea " + i);
        }finally {
            if (excelFile != null){
                try {
                    excelFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (excel != null) {
                try {
                    excel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return lines;
    }

    /**
     * Transforma una linea de celdas a string.
     * @param line Celdas a convertir.
     * @return Un string de las celdas convertidas.
     */
    private String migrateToString(List<XSSFCell> line){
        String result = "";

        for(XSSFCell cell : line)
            result += cell.getStringCellValue() + ",";

        return removeCommasFromEndRec(result);
    }

    /**
     * Quita el ultimo caracter del texto si es una coma.
     * @param text al que quitarle la coma.
     * @return El texto sin una coma al final.
     */
    private String removeCommasFromEnd(String text){
        return text.replaceAll(",$", "");
    }

    /**
     * Borra todas las comas que haya al final del texto hasta que no haya ninguna más.
     * @param text al que quitarle todas las comas del final.
     * @return El mismo texto sin comas al final.
     */
    private String removeCommasFromEndRec(String text){
        while(text.endsWith(","))
            text = removeCommasFromEnd(text);

        return text;
    }

    @Override
    public List<String> getLoadedList() {
        return lines;
    }

}
