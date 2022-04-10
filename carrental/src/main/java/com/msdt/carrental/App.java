package com.msdt.carrental;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.msdt.carrental.domain.Car;
import com.msdt.carrental.domain.Order;
import com.msdt.carrental.domain.User;
import com.msdt.carrental.domain.UserRole;
import com.msdt.carrental.model.config.DBConnection;
import com.msdt.carrental.model.config.DBTestConfig;
import com.msdt.carrental.model.service.api.ServiceException;
import com.msdt.carrental.model.service.impl.CarService;
import com.msdt.carrental.model.service.impl.OrderService;
import com.msdt.carrental.model.service.impl.ServiceFactory;
import com.msdt.carrental.model.service.impl.UserService;

public class App {

	public static void main(final String[] args) throws SQLException, ServiceException {

		Connection connection = new DBConnection().getConnection();
		ServiceFactory serviceFactory = ServiceFactory.INSTANCE;
		serviceFactory.setConnection(connection);

		UserService userService = serviceFactory.getUserService();

		List<User> users = userService.getAllItems();
		System.out.println(
				"========================================= Insert User =========================================");
		
		users().forEach(user -> {
			try {
				userService.insertItem(user);
			} catch (ServiceException e) {
				System.out.println("ServiceException");
				e.printStackTrace();
			}
		});

		System.out.println(
				"========================================= USER NAME & PASSWORD =========================================");
		System.out.println(userService.getUserByUserNameAndPassword("admin", "admin"));
		System.out.println(userService.getUserByUserNameAndPassword("user", "user"));

		System.out.println("========================================= USERS =========================================");

		System.out.println(userService.getItemById(1));
		System.out.println(userService.getItemById(2));
		users.forEach(System.out::println);
	}

	private static List<User> users() {
		return Arrays.asList(new User("admin", "Email@Email.com", "admin", "Address One", false, UserRole.ADMIN),
				new User("user", "user@user.com", "user", "Address user", false, UserRole.USER),
				new User("adminOne", "adminOne@Email.com", "adminOne", "Address adminOne", false, UserRole.ADMIN),
				new User("userOne", "userOne@Email.com", "userOne", "Address User", false, UserRole.USER));
	}
}
