package parser.uploader;

import com.lowagie.text.DocumentException;
import model.User;
import parser.inserter.InsertR;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class UserUploader implements ClassAppend{

    @Override
    public void addMethod(List<String> toAdd) throws DocumentException, IOException {
        for(String line : toAdd) {
            String[] tipo = line.split(",");
            crearUsuarios(tipo);
        }
    }

    private void crearUsuarios(String[] list) throws DocumentException, IOException {
        User user = new User(list[0] ,list[1] ,list[2] ,list[3]);

        InsertR insert = new InsertR();
        insert.save(user,"1");
    }

}
