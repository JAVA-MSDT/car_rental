package com.msdt.carrental.frontcontroller.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msdt.carrental.frontcontroller.controller.Controller;
import com.msdt.carrental.frontcontroller.viewresolve.ViewResolver;

public class NewsController implements Controller {

	private static final String NEWS_JSP = "/WEB-INF/pages/main/news.jsp";

	@Override
	public ViewResolver resolve(final HttpServletRequest request, final HttpServletResponse response) {
		ViewResolver resolver = new ViewResolver();

		resolver.forward(NEWS_JSP);
		System.out.println("From: " + this.getClass().getSimpleName());
		return resolver;
	}
}
