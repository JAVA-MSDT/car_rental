package com.msdt.carrental.frontcontroller.view.order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msdt.carrental.domain.Car;
import com.msdt.carrental.domain.Order;
import com.msdt.carrental.domain.User;
import com.msdt.carrental.frontcontroller.controller.Controller;
import com.msdt.carrental.frontcontroller.entitybuilder.OrderBuilderFromRequest;
import com.msdt.carrental.frontcontroller.viewresolve.ViewResolver;
import com.msdt.carrental.model.service.api.ServiceException;
import com.msdt.carrental.model.service.impl.CarService;
import com.msdt.carrental.model.service.impl.OrderService;
import com.msdt.carrental.util.constants.CarConstant;
import com.msdt.carrental.util.constants.ControllerConstant;
import com.msdt.carrental.util.constants.UserConstant;

public class ConfirmOrderController implements Controller {

	private OrderService orderService;
	private CarService carService;
	private OrderBuilderFromRequest orderBuidler;

	public ConfirmOrderController(OrderService orderService, CarService carService) {
		this.orderService = orderService;
		this.carService = carService;
		orderBuidler = new OrderBuilderFromRequest();
	}

	@Override
	public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
		String carId = request.getParameter(CarConstant.CAR_ID);
		long carID = Long.parseLong(carId);
		Car car = carService.getItemById(carID);
		
		User user = (User) request.getSession(false).getAttribute(UserConstant.USER_ATTRIBUTE);
		if (user != null) {

			Order order = orderBuidler.buildUserOrder(request, user.getUserId(), carID);
			int insertOrder = orderService.insertItem(order);
			if(insertOrder == 1) {
				request.setAttribute(ControllerConstant.ORDER_SAVED, "Order Saved");
			}else {
				request.setAttribute(ControllerConstant.ORDER_FAILED, "Order Failed");
			}
			
		} else {
			request.setAttribute(UserConstant.INVALID_LOGIN, "Invalid Login Credintials");
		}
		request.setAttribute(ControllerConstant.CAR_RESPONSE, car);
		return new ViewResolver(ControllerConstant.CAR_PAGE);
	}

}
