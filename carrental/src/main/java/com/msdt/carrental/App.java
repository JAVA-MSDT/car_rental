package com.msdt.carrental;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.msdt.carrental.domain.User;
import com.msdt.carrental.model.config.DBConnection;
import com.msdt.carrental.model.service.api.ServiceException;
import com.msdt.carrental.model.service.impl.ServiceFactory;
import com.msdt.carrental.model.service.impl.UserService;

public class App {

	public static void main(final String[] args) throws SQLException, ServiceException {

		Connection connection = new DBConnection().getConnection();
		ServiceFactory serviceFactory = ServiceFactory.INSTANCE;
		serviceFactory.setConnection(connection);

		UserService userService = serviceFactory.getUserService();

		List<User> users = userService.getAllItems();

		users.forEach(System.out::println);

	}
}
