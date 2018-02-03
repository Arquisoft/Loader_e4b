package executer;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.lowagie.text.DocumentException;

import dbupdate.Insert;
import dbupdate.InsertP;
import dbupdate.InsertT;
import dbupdate.InsertType;
import model.Type;
import model.User;

public class ActionFacadeClass implements ActionFacade {

	@Override
	public void saveData(User user) throws FileNotFoundException, DocumentException, IOException {
		Insert insert = new InsertP();
		insert.save(user);
	}

	@Override
	public void saveType(Type type) {
		InsertType insert = new InsertT();
		insert.save(type);
	}
}