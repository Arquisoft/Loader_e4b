package parser;

import com.lowagie.text.DocumentException;
import parser.reader.CSVReader;
import parser.reader.ReadList;
import parser.reader.XLSXReader;
import parser.uploader.UserUploader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class UserParser implements Parser{

    private ReadList reader;

    public UserParser(String extension){
        selectExtension(extension);
    }

    private void selectExtension(String extension){
        if(extension.equals("xlsx")){
            reader = new XLSXReader();
        }
        else{
            reader = new CSVReader();
        }
    }

    @Override
    public void parse(String cad) throws IOException, DocumentException {
        List<String> res = reader.load(cad);
        new UserUploader().addMethod(res);
    }

}
