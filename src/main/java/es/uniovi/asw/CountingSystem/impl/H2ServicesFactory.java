package es.uniovi.asw.CountingSystem.impl;

import es.uniovi.asw.CountingSystem.IGetCensusInfo;
import es.uniovi.asw.CountingSystem.IGetVotesInfo;
import es.uniovi.asw.CountingSystem.ServicesFactory;

public class H2ServicesFactory implements ServicesFactory{

	@Override
	public IGetCensusInfo CensusInfo() {
		// TODO Auto-generated method stub
		return new GetCensusInfo();
	}

	@Override
	public IGetVotesInfo VotesInfo() {
		// TODO Auto-generated method stub
		return new GetVotesInfo();
	}

}
