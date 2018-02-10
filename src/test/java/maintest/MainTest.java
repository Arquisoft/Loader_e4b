package maintest;

import com.lowagie.text.DocumentException;
import main.LoadUsers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class MainTest {

    private PrintStream newSystemOut;
    private PrintStream current;
    private ByteArrayOutputStream data;

    @Before
    public void setStandardOutput(){
        current = System.out;

        data = new ByteArrayOutputStream();
        newSystemOut = new PrintStream(data);

        System.setOut(newSystemOut);
    }

    @Test
    public void helpTest() throws DocumentException {
        LoadUsers load = new LoadUsers();
        String[] help = {"--help"};

        load.run(help);

        ByteArrayOutputStream text = new ByteArrayOutputStream();
        PrintStream toCheck = new PrintStream(text);

        toCheck.println("Manual de ayuda para el uso de la aplicacion");
        toCheck.println("La aplicacion tiene implementadas las operaciones info, load y help");
        toCheck.println("\tinfo: Muestra informacion relacionada con el proyecto, como los autores");
        toCheck.println("\tload [file]: Permite cargar un conjunto de ficheros excel con usuarios en la base de datos, para cargar los usuarios "
                + "estos deben de tener tipos válidos que se cargan desde el fichero master.csv");
        toCheck.println("\t--help: Muestra este menu de ayuda. Si no se proporcionan parametros "
                + "a la aplicacion se mostrara este menu");

        assertEquals(text.toString(), data.toString());
        data.reset();
    }

    @Test
    public void infoTest() throws DocumentException {
        LoadUsers load = new LoadUsers();
        String[] info = {"info"};

        load.run(info);

        ByteArrayOutputStream text = new ByteArrayOutputStream();
        PrintStream toCheck = new PrintStream(text);

        toCheck.println("Proyecto Loader 4B");
        toCheck.println("El objetivo de este proyecto es actuar como modulo de carga de"
                + "usuarios para un sistema de participacion ciudadana");
        toCheck.println("Realizado por el grupo 4B1 compuesto por: ");
        toCheck.println("Alejandro Garcia Parrondo (UO253144)");
        toCheck.println("Juan Granda Molaguero (UO244759)");
        toCheck.println("Angela Val Cadena (UO250972)");
        toCheck.println("Samuel Steven Ludenna Vela (UO251461)");
        toCheck.println("Oscar Marin Iglesias (UO251857)");
        toCheck.println("Para mas informacion consultar el repositorio en github con la url "
                + "https://github.com/Arquisoft/Loader_e4b");

        assertEquals(text.toString(), data.toString());
        data.reset();

    }

    @Test
    public void loadTest() throws DocumentException {
        LoadUsers load = new LoadUsers();
        String[] loadI = {"load" ,"src/test/resources/test.xlsx"};

        load.run(loadI);

        ByteArrayOutputStream text = new ByteArrayOutputStream();
        PrintStream toCheck = new PrintStream(text);

        toCheck.println("Juan Torres Pardo ; 22.971436; -43.182565 ; juan@example.com ; 87654321P ; ");
        toCheck.println("Luis López Fernando ; 32.97; -23.1 ; luis@example.com ; 19160962F ; ");
        toCheck.println("Ana Torres Pardo ; 21.26; 50.26 ; ana@example.com ; 09940449X ;  ; ");

        String endText = removeELInfo(data.toString());

        assertEquals(text.toString(), endText);
        data.reset();

    }

    private String removeELInfo(String text){
        String newText = "";
        String[] textArray = text.split("\n");

        for(String line : textArray)
            if(!line.contains("[EL Info]"))
                newText += line + "\n";

        return newText;
    }

    @After
    public void setDefaultStandardOutput(){
        System.setOut(current);
    }

}
