package com.msdt.carrental.util.constants;

public class ControllerConstant {

	/////////////////////
	// Controller Name //
	/////////////////////
	public static final String CONTROLLER_NAME_VAR = "controller";
	// Public Controller
	public static final String BLOG_CONTROLLER = "blog";
	public static final String ABOUT_CONTROLLER = "about";
	public static final String NEWS_CONTROLLER = "news";
	public static final String CARS_CONTROLLER = "cars";
	public static final String LOGIN_CONTROLLER = "login";
	public static final String LOGOUT_CONTROLLER = "logout";
	public static final String VIEW_CAR_CONTROLLER = "viewCar";
	
	// User Controller
	public static final String CONFIRM_ORDER_CONTROLLER = "confirmOrder";
	
	// Administration Controller
	public static final String USERS_CONTROLLER = "users";

	///////////////////
	// View Location //
	///////////////////
	public static final String HOME_PAGE = "/";
	public static final String BLOG_PAGE = "/WEB-INF/pages/main/blog.jsp";
	public static final String ABOUT_PAGE = "/WEB-INF/pages/main/about.jsp";
	public static final String NEWS_PAGE = "/WEB-INF/pages/main/news.jsp";
	public static final String LOGIN_PAGE = "/WEB-INF/pages/common/login.jsp";
	public static final String ERROR_PAGE = "/WEB-INF/pages/common/errorPage.jsp";
	
	// Cars Pages
	public static final String CARS_PAGE = "/WEB-INF/pages/car/cars.jsp";
	public static final String CAR_PAGE = "/WEB-INF/pages/car/carPage.jsp";
	
	// User Pages
	public static final String USERS_PAGE = "/WEB-INF/pages/user/users.jsp";
	public static final String USER_PROFILE = "/WEB-INF/pages/user/userProfile.jsp";
	
	///////////////////////
	// Request Attribute //
	///////////////////////
	
	public static final String CARS_RESPONSE = "cars";
	public static final String CAR_RESPONSE = "car";
	public static final String USERS_RESPONSE = "users";
	
	public static final String ORDER_SAVED = "orderSaved";
	public static final String ORDER_FAILED = "orderFailed";
	
	private ControllerConstant() {

	}
}
