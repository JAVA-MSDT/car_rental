package com.msdt.carrental.frontcontroller.controller;

import java.sql.Connection;

import com.msdt.carrental.frontcontroller.view.AboutController;
import com.msdt.carrental.frontcontroller.view.BlogController;
import com.msdt.carrental.frontcontroller.view.NewsController;
import com.msdt.carrental.frontcontroller.view.car.CarView;
import com.msdt.carrental.frontcontroller.view.car.CarsController;
import com.msdt.carrental.frontcontroller.view.common.LoginController;
import com.msdt.carrental.frontcontroller.view.common.LogoutController;
import com.msdt.carrental.frontcontroller.view.user.UsersController;
import com.msdt.carrental.model.config.DBConnection;
import com.msdt.carrental.model.config.DBTestConfig;
import com.msdt.carrental.model.service.impl.ServiceFactory;
import com.msdt.carrental.util.constants.ControllerConstant;

public class ControllerFactory{

	private Connection connection = new DBConnection().getConnection();
	private ServiceFactory serviceFactory = ServiceFactory.INSTANCE;

	public ControllerFactory() {
		serviceFactory.setConnection(connection);
	}

	public Controller getController(final String controllerName) {

		switch (controllerName) {
		case ControllerConstant.NEWS_CONTROLLER:
			return new NewsController();
		case ControllerConstant.CARS_CONTROLLER:
			return new CarsController(serviceFactory.getCarService());
		case ControllerConstant.USERS_CONTROLLER:
			return new UsersController(serviceFactory.getUserService());
		case ControllerConstant.ABOUT_CONTROLLER:
			return new AboutController();
		case ControllerConstant.BLOG_CONTROLLER:
			return new BlogController();
		case ControllerConstant.LOGIN_CONTROLLER:
			return new LoginController(serviceFactory.getUserService());
		case ControllerConstant.LOGOUT_CONTROLLER:
			return new LogoutController();
		case ControllerConstant.VIEW_CAR_CONTROLLER:
			return new CarView(serviceFactory.getCarService());
		default:
		}
		
		return null;
	}

}
