package com.msdt.carrental.frontcontroller.entitybuilder;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import com.msdt.carrental.domain.Order;
import com.msdt.carrental.util.constants.OrderConstant;

public class OrderBuilderFromRequest {

	/**
	 * 
	 * @param request
	 * @param userId
	 * @param carId
	 * @return Order to store in DB
	 */
	public Order buildUserOrder(HttpServletRequest request, long userId, long carId) {

		String orderDate = request.getParameter(OrderConstant.TABLE_ORDER_DATE);
		String returningDate = request.getParameter(OrderConstant.TABLE_ORDER_RETURN_DATE);
		double rentalcost = 20.00;

		return new Order(userId, carId, Date.valueOf(orderDate), Date.valueOf(returningDate), rentalcost);
	}

}
