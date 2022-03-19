package com.msdt.carrental.frontcontroller.view.car;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msdt.carrental.domain.Car;
import com.msdt.carrental.frontcontroller.controller.Controller;
import com.msdt.carrental.frontcontroller.viewresolve.ViewResolver;
import com.msdt.carrental.model.service.api.ServiceException;
import com.msdt.carrental.model.service.impl.CarService;
import com.msdt.carrental.util.constants.ControllerConstant;

public class CarsController implements Controller {

	private CarService carService;

	public CarsController(CarService carService) {
		this.carService = carService;
	}

	@Override
	public ViewResolver resolve(final HttpServletRequest request, final HttpServletResponse response) throws ServiceException {

		List<Car> cars = carService.getAllItems();
		request.setAttribute(ControllerConstant.CARS_RESPONSE, cars);
		return new ViewResolver(ControllerConstant.CARS_PAGE);
	}

}
