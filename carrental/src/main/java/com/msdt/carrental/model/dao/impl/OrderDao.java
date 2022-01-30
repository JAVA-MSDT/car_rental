package com.msdt.carrental.model.dao.impl;

import java.sql.Connection;
import java.util.List;

import com.msdt.carrental.domain.Order;
import com.msdt.carrental.model.dao.api.AbstractDao;
import com.msdt.carrental.model.dao.api.DaoException;
import com.msdt.carrental.model.dao.api.GenericDao;
import com.msdt.carrental.model.mapping.impl.CarMapper;
import com.msdt.carrental.model.mapping.impl.OrderMapper;
import com.msdt.carrental.util.constants.CarConstant;
import com.msdt.carrental.util.constants.OrderConstant;

/**
 * 
 * @author Ahmed Samy https://github.com/JAVA-MSDT
 */
public class OrderDao extends AbstractDao<Order> {

	OrderDao() {

	}

	OrderDao(final Connection connection) {
		super(connection);

	}

	@Override
	public int insertItem(final Order order) throws DaoException {

		String isReturned = order.isCarReturned() ? "1" : "0";

		String[] orderInfo = { String.valueOf(order.getUserId()), String.valueOf(order.getCarId()),
				String.valueOf(order.getOrderDate()), String.valueOf(order.getReturnDate()), isReturned,
				String.valueOf(order.getRentalcost()) };

		return executeUpdate(OrderConstant.INSERT_ORDER, orderInfo);
	}

	@Override
	public List<Order> getAllItems() throws DaoException {

		return queryForObjects(OrderConstant.SELECT_ALL_ORDERS, new OrderMapper());
	}

	@Override
	public Order getItemById(final long id) throws DaoException {

		return queryForObject(OrderConstant.SELECT_ORDER_BY_ID, new OrderMapper(), String.valueOf(id));
	}

	@Override
	public int updateItem(final Order order) throws DaoException {

		String isReturned = order.isCarReturned() ? "1" : "0";

		String[] orderInfo = { String.valueOf(order.getUserId()), String.valueOf(order.getCarId()),
				String.valueOf(order.getOrderDate()), String.valueOf(order.getReturnDate()), isReturned,
				String.valueOf(order.getRentalcost()), String.valueOf(order.getOrderId()) };

		return executeUpdate(OrderConstant.UPDATE_ORDER, orderInfo);
	}

	@Override
	public int deleteItem(final long id) throws DaoException {

		return executeUpdate(OrderConstant.DELETE_ORDER_BY_ID, String.valueOf(id));
	}

}
