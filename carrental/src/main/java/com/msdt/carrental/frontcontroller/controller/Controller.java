package com.msdt.carrental.frontcontroller.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msdt.carrental.frontcontroller.viewresolve.ViewResolver;

public interface Controller {
	ViewResolver resolve(final HttpServletRequest request, final HttpServletResponse response);
}
