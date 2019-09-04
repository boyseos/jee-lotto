package com.lotto.web.serviceImpls;

import com.lotto.web.daoimpls.ConsumerDaoImpl;
import com.lotto.web.daos.ConsumerDao;
import com.lotto.web.domains.ConsumerBean;
import com.lotto.web.services.ConsumerService;

public class ConsumerServiceImpl implements ConsumerService{

	private ConsumerDao dao;
	
	public ConsumerServiceImpl() {
		dao = new ConsumerDaoImpl();
	}
	
	@Override
	public void resisterConsumer(ConsumerBean param) {	
		dao.insertConsumer(param);
	}
}
