package com.msdt.carrental.frontcontroller.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.msdt.carrental.domain.User;
import com.msdt.carrental.domain.UserRole;
import com.msdt.carrental.util.constants.ControllerConstant;
import com.msdt.carrental.util.constants.UserConstant;

@WebFilter("/car-rental")
public class AuthController implements Filter {

	private static final Logger LOGGER = LogManager.getLogger();

	private static final List<String> PUBLIC_CONTROLLER = Arrays.asList(ControllerConstant.BLOG_CONTROLLER,
			ControllerConstant.ABOUT_CONTROLLER, ControllerConstant.NEWS_CONTROLLER, ControllerConstant.CARS_CONTROLLER,
			ControllerConstant.LOGIN_CONTROLLER, ControllerConstant.LOGOUT_CONTROLLER,
			ControllerConstant.VIEW_CAR_CONTROLLER);

	private static final List<String> ADMINISTRATION_CONTROLLER = Arrays.asList(ControllerConstant.USERS_CONTROLLER,
			ControllerConstant.CONFIRM_ORDER_CONTROLLER);

	private static final List<String> USER_CONTROLLER = Arrays.asList(ControllerConstant.CONFIRM_ORDER_CONTROLLER);

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		LOGGER.info("Auth Filter Started.....");

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpSession session = request.getSession();

		User user = (User) session.getAttribute(UserConstant.USER_ATTRIBUTE);
		String controller = request.getParameter(ControllerConstant.CONTROLLER_NAME_VAR);
		if (!isPublicController(controller)) {

			if (user != null && user.getUserRole().equals(UserRole.ADMIN) && isAdministrationController(controller)) {
				filterChain.doFilter(request, response);
			} else if (user != null && user.getUserRole().equals(UserRole.USER) && isUserController(controller)) {
				filterChain.doFilter(request, response);
			} else {
				response.sendRedirect(ControllerConstant.HOME_PAGE);
			}
		} else {
			filterChain.doFilter(request, response);
		}

	}

	/**
	 * @param contoroller to be checked if the administration authorized to access
	 *                    it or not
	 * @return true if the admin authorized or false if it is not authorized
	 */
	private boolean isAdministrationController(String contoroller) {

		return ADMINISTRATION_CONTROLLER.contains(contoroller);
	}

	/**
	 * @param command to be checked if the user authorized to access on of this
	 *                command or not
	 * @return true if the user authorized or false if it is not authorized
	 */
	private boolean isUserController(String controller) {
		return USER_CONTROLLER.contains(controller);
	}

	/**
	 * @param command that are common for all the users registered or not
	 * @return true if it is for all the users or false.
	 */
	private boolean isPublicController(String controller) {

		return PUBLIC_CONTROLLER.contains(controller);
	}

	@Override
	public void destroy() {
		LOGGER.info("Auth Filter Destroied.....");

	}

}
