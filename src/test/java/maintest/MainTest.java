package maintest;

import com.lowagie.text.DocumentException;
import main.LoadUsers;
import org.junit.Test;

public class MainTest {

    @Test
    public void helpTest() throws DocumentException {
        LoadUsers load = new LoadUsers();
        String[] help = {"--help"};

        load.run(help);
    }

    @Test
    public void infoTest() throws DocumentException {
        LoadUsers load = new LoadUsers();
        String[] help = {"info"};

        load.run(help);
    }

    @Test
    public void loadTest() throws DocumentException {
        LoadUsers load = new LoadUsers();
        String[] help = {"load src/test/resources/test.xlsx"};

        load.run(help);
    }

}
