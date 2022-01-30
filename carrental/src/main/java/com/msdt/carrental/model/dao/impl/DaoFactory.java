package com.msdt.carrental.model.dao.impl;

import java.sql.Connection;

/**
 * DAO LAYER Entry Point to call any Dao Class you need to follow this pattern
 * 
 * DaoFactory daoFactory = DaoFactory.INSTANCE;
 * daoFactory.setConnection(connection) UserDao userDao =
 * daoFactory.getUserDao();
 * 
 * @author Ahmed Samy https://github.com/JAVA-MSDT
 */
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
	
	public OrderDao getOrderDao() {
		return new OrderDao(connection);
	}
}
