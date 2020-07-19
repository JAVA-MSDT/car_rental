package com.msdt.carrental.model.dao.impl;

import java.sql.Connection;

public enum DaoFactory {

	INSTANCE;

	private Connection connection;

	public void setConnection(final Connection connection) {
		this.connection = connection;
	}

	public UserDao getUserDao() {
		return new UserDao(connection);
	}

	public CarDao getCarDao() {
		return new CarDao(connection);
	}
}
