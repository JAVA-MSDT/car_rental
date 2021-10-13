package com.msdt.carrental.frontcontroller.controller;

import com.msdt.carrental.frontcontroller.view.AboutController;
import com.msdt.carrental.frontcontroller.view.BlogController;
import com.msdt.carrental.frontcontroller.view.NewsController;

public class ControllerFactory {

	public ControllerFactory() {

	}

	public Controller getController(final String controllerName) {

		switch (controllerName) {
		case "news":
			return new NewsController();
		case "about":
			return new AboutController();
		case "blog":
			return new BlogController();
		default:
		}
		return null;
	}
}
