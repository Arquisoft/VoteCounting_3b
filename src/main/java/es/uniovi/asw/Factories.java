package es.uniovi.asw;

import es.uniovi.asw.dbManagement.PersistenceFactory;
import es.uniovi.asw.dbManagement.impl.H2PersistenceFactory;

public class Factories {
	
	public static PersistenceFactory persistence = new H2PersistenceFactory();

}
