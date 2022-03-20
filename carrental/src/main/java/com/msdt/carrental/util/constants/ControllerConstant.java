package com.msdt.carrental.util.constants;

public class ControllerConstant {

	/////////////////////
	// Controller Name //
	/////////////////////
	public static final String BLOG_CONTROLLER = "blog";
	public static final String ABOUT_CONTROLLER = "about";
	public static final String NEWS_CONTROLLER = "news";
	public static final String CARS_CONTROLLER = "cars";
	public static final String USERS_CONTROLLER = "users";

	///////////////////
	// View Location //
	///////////////////
	public static final String BLOG_PAGE = "/WEB-INF/pages/main/blog.jsp";
	public static final String ABOUT_PAGE = "/WEB-INF/pages/main/about.jsp";
	public static final String NEWS_PAGE = "/WEB-INF/pages/main/news.jsp";
	
	// Cars Pages
	public static final String CARS_PAGE = "/WEB-INF/pages/car/cars.jsp";
	
	// User Pages
	public static final String USERS_PAGE = "/WEB-INF/pages/user/users.jsp";
	
	///////////////////////
	// Request Attribute //
	///////////////////////
	
	public static final String CARS_RESPONSE = "cars";
	public static final String USERS_RESPONSE = "users";
	
	private ControllerConstant() {

	}
}
