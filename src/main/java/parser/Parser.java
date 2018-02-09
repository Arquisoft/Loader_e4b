package parser;

import com.lowagie.text.DocumentException;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Parser {

    /**
     * Dada una cadena, la direccion de un fichero, se lee con un ReadList y se sube a la base de datos con un ClassAppend.
     * @param cad dirección del fichero a operar.
     * @throws IOException
     * @throws DocumentException
     */
    void parse(String cad) throws IOException, DocumentException;

}
