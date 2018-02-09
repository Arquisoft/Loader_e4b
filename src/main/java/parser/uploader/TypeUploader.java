package parser.uploader;

import com.lowagie.text.DocumentException;
import dbupdate.InsertT;
import model.Type;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class TypeUploader implements ClassAppend{
    @Override
    public void addMethod(List<String> toAdd){
        for(String line : toAdd) {
            String[] tipo = line.split(",");
            Type type = crearTipo(tipo);
        }
    }

    private Type crearTipo(String[] tipo) {
        Type type = new Type(Integer.valueOf(tipo[0]), tipo[1]);
        new InsertT().save(type);
        return type;
    }

}
