package parser;

import com.lowagie.text.DocumentException;
import parser.reader.CSVReader;
import parser.reader.ReadList;
import parser.uploader.TypeUploader;

import java.io.FileNotFoundException;
import java.util.List;

public class MasterParser implements Parser{
    private ReadList reader = new CSVReader();

    @Override
    public void parse(String cad) throws FileNotFoundException, DocumentException {
        List<String> read = reader.load(cad);
        new TypeUploader().addMethod(read);
    }
}
