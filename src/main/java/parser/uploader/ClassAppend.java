package parser.uploader;

import com.lowagie.text.DocumentException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ClassAppend {

    /**
     * Añade a la base de datos la lista de datos
     * @param toAdd lista de objetos a añadir a la base de datos
     * @throws FileNotFoundException
     * @throws DocumentException
     * @throws IOException
     */
    void addMethod(List<String> toAdd) throws DocumentException, IOException;

}
