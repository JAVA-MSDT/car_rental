package com.msdt.carrental.frontcontroller.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msdt.carrental.frontcontroller.controller.Controller;
import com.msdt.carrental.frontcontroller.viewresolve.ViewResolver;
import com.msdt.carrental.util.constants.ControllerConstant;

public class BlogController implements Controller {

	@Override
	public ViewResolver resolve(final HttpServletRequest request, final HttpServletResponse response) {
		request.setAttribute("blog_post", "Blog Post");
		return new ViewResolver(ControllerConstant.BLOG_PAGE);
	}

}
