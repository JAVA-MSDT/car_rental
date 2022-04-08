package com.msdt.carrental.frontcontroller.view.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.msdt.carrental.domain.User;
import com.msdt.carrental.frontcontroller.controller.Controller;
import com.msdt.carrental.frontcontroller.viewresolve.ViewResolver;
import com.msdt.carrental.model.service.api.ServiceException;
import com.msdt.carrental.model.service.impl.UserService;
import com.msdt.carrental.util.constants.ControllerConstant;
import com.msdt.carrental.util.constants.UserConstant;

public class LoginController implements Controller {

	private UserService userService;

	public LoginController(UserService userService) {
		this.userService = userService;
	}

	@Override
	public ViewResolver resolve(final HttpServletRequest request, final HttpServletResponse response)
			throws ServiceException {

		String page;
		ViewResolver viewResolver = new ViewResolver();
		HttpSession session = request.getSession();

		String login = request.getParameter(UserConstant.USER_LOGIN);
		String password = request.getParameter(UserConstant.USER_PASSWORD);

		User user = userService.getUserByUserNameAndPassword(login, password);

		if (null != user) {
			session.setAttribute(UserConstant.USER_ATTRIBUTE, user);

			if (user.isUserBlocked()) {
				request.setAttribute(UserConstant.BLOCK_MESSAGE, "User Blocked");
				page = ControllerConstant.LOGIN_PAGE;
			}else {
				page = ControllerConstant.USER_PROFILE;
			}

		} else {
			request.setAttribute(UserConstant.INVALID_LOGIN, "Invalid Login Credintials");
			page = ControllerConstant.LOGIN_PAGE;
		}
		viewResolver.forward(page);
		return viewResolver;
	}

}
