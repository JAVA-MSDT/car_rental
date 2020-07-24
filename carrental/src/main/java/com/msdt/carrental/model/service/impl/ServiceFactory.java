package com.msdt.carrental.model.service.impl;

import java.sql.Connection;

import com.msdt.carrental.model.dao.impl.DaoFactory;

public enum ServiceFactory {

	INSTANCE;

	private DaoFactory daoFactory = DaoFactory.INSTANCE;

	public void setConnection(final Connection connection) {
		daoFactory.setConnection(connection);
	}


	public UserService getUserService() {
		return new UserService(daoFactory.getUserDao());
	}

}
