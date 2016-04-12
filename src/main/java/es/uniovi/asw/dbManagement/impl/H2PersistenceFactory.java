package es.uniovi.asw.dbManagement.impl;

import es.uniovi.asw.dbManagement.IGetCensus;
import es.uniovi.asw.dbManagement.IGetVotes;
import es.uniovi.asw.dbManagement.PersistenceFactory;

public class H2PersistenceFactory implements PersistenceFactory {

	@Override
	public IGetCensus census() {
		// TODO Auto-generated method stub
		return  new GetCensusInfo();
	}

	@Override
	public IGetVotes votes() {
		// TODO Auto-generated method stub
		return new GetVotesInfo();
	} 
}
