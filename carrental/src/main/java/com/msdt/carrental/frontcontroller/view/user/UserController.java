package com.msdt.carrental.frontcontroller.view.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msdt.carrental.domain.Car;
import com.msdt.carrental.domain.User;
import com.msdt.carrental.frontcontroller.controller.Controller;
import com.msdt.carrental.frontcontroller.viewresolve.ViewResolver;
import com.msdt.carrental.model.service.api.ServiceException;
import com.msdt.carrental.model.service.impl.CarService;
import com.msdt.carrental.model.service.impl.UserService;
import com.msdt.carrental.util.constants.ControllerConstant;

public class UserController implements Controller {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@Override
	public ViewResolver resolve(final HttpServletRequest request, final HttpServletResponse response) throws ServiceException {

		List<User> users = userService.getAllItems();
		request.setAttribute(ControllerConstant.USERS_RESPONSE, users);
		return new ViewResolver(ControllerConstant.USERS_PAGE);
	}

}
