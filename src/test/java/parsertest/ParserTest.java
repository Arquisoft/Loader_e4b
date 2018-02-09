package parsertest;

import com.lowagie.text.DocumentException;
import org.junit.Before;
import org.junit.Test;
import parser.MasterParser;
import parser.UserParser;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ParserTest {

    @Before
    public void masterTest() throws FileNotFoundException, DocumentException {
        MasterParser parser = new MasterParser();
        parser.parse("master.csv");
    }

    @Test
    public void userTestXLSX() throws IOException, DocumentException {
        String fichero = "src/test/resources/test.xlsx";

        UserParser parser = new UserParser("xlsx");
        parser.parse(fichero);
    }

    @Test
    public void userTestCSV() throws IOException, DocumentException {
        String fichero = "src/test/resources/test.csv";

        UserParser parser = new UserParser("csv");
        parser.parse(fichero);
    }

}
