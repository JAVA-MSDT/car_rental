package com.msdt.carrental;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.msdt.carrental.domain.Car;
import com.msdt.carrental.domain.Order;
import com.msdt.carrental.domain.User;
import com.msdt.carrental.model.config.DBConnection;
import com.msdt.carrental.model.config.DBTestConfig;
import com.msdt.carrental.model.service.api.ServiceException;
import com.msdt.carrental.model.service.impl.CarService;
import com.msdt.carrental.model.service.impl.OrderService;
import com.msdt.carrental.model.service.impl.ServiceFactory;
import com.msdt.carrental.model.service.impl.UserService;

public class App {

	public static void main(final String[] args) throws SQLException, ServiceException {

		Connection connection = new DBTestConfig().getConnection(); // new DBConnection().getConnection();
		ServiceFactory serviceFactory = ServiceFactory.INSTANCE;
		serviceFactory.setConnection(connection);

		UserService userService = serviceFactory.getUserService();
		CarService carService = serviceFactory.getCarService();
		OrderService orderService = serviceFactory.getOrderService();

		List<User> users = userService.getAllItems();
		List<Car> cars = carService.getAllItems();
		List<Order> orders = orderService.getAllItems();
		
		System.out.println("========================================= USERS =========================================");
		users.forEach(System.out::println);
		System.out.println("========================================= CARS =========================================");
		cars.forEach(System.out::println);
		System.out.println("========================================= ORDERS =========================================");
		orders.forEach(System.out::println);

	}
}
