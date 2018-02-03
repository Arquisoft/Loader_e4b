package parser;

import java.util.List;

import dbupdate.InsertT;
import dbupdate.InsertType;
import model.Type;
import persistence.TypeFinder;

public class InsertM implements InsertType{

	@Override
	public Type save(Type tipo) {
		return new InsertT().save(tipo);
	}

	@Override
	public List<Type> findByCode(int codigo) {
		return TypeFinder.findByCode(codigo);
	}

	@Override
	public List<Type> findByType(String tipo) {
		return TypeFinder.findByType(tipo);
	}

}
