package com.msdt.carrental.frontcontroller.view.car;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msdt.carrental.domain.Car;
import com.msdt.carrental.frontcontroller.controller.Controller;
import com.msdt.carrental.frontcontroller.viewresolve.ViewResolver;
import com.msdt.carrental.model.service.api.ServiceException;
import com.msdt.carrental.model.service.impl.CarService;
import com.msdt.carrental.util.constants.CarConstant;
import com.msdt.carrental.util.constants.ControllerConstant;

public class CarView implements Controller {

	private final CarService carService;

	public CarView(CarService carService) {
		this.carService = carService;
	}

	@Override
	public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) throws ServiceException {

		String carId = request.getParameter(CarConstant.CAR_ID);
		
		Car car = carService.getItemById(Long.parseLong(carId));

		request.setAttribute(ControllerConstant.CAR_RESPONSE, car);

		return new ViewResolver(ControllerConstant.CAR_PAGE);
	}

}
