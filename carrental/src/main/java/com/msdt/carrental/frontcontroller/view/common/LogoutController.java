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

public class LogoutController implements Controller {

	@Override
	public ViewResolver resolve(final HttpServletRequest request, final HttpServletResponse response)
			throws ServiceException {

		ViewResolver viewResolver = new ViewResolver();
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.removeAttribute(UserConstant.USER_ATTRIBUTE);
			session.invalidate();
		}
		viewResolver.redirect(request.getContextPath() + ControllerConstant.HOME_PAGE);
		return viewResolver;
	}

}
