package com.msdt.carrental.model.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.msdt.carrental.domain.Order;
import com.msdt.carrental.model.dao.api.DaoException;
import com.msdt.carrental.model.dao.impl.OrderDao;
import com.msdt.carrental.model.service.api.GenericService;
import com.msdt.carrental.model.service.api.ServiceException;

public class OrderService implements GenericService<Order>{

	private static final Logger LOGGER = LogManager.getLogger();

	
	private OrderDao orderDao;
	
	OrderService(final OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	@Override
	public int insertItem(final Order order) throws ServiceException {
		
		try {
			return orderDao.insertItem(order);
		} catch (DaoException e) {
			LOGGER.error("Unabling to perform insert from orderService: " + e);
			throw new ServiceException("Unabling to perform insert from orderService: " + e);
		}
	}

	@Override
	public List<Order> getAllItems() throws ServiceException {
		
		try {
			return orderDao.getAllItems();
		} catch (DaoException e) {
			LOGGER.error("Unabling to perform getAllOrders from orderService: " + e);
			throw new ServiceException("Unabling to perform getAllOrders from orderService: " + e);
		}
	}

	@Override
	public Order getItemById(final long id) throws ServiceException {
		
		try {
			return orderDao.getItemById(id);
		} catch (DaoException e) {
			LOGGER.error("Unabling to perform getOrderById from orderService: " + e);
			throw new ServiceException("Unabling to perform getOrderById from orderService: " + e);
		}
	}

	@Override
	public int updateItem(final Order order) throws ServiceException {
		
		try {
			return orderDao.updateItem(order);
		} catch (DaoException e) {
			LOGGER.error("Unabling to perform updateOrder from orderService: " + e);
			throw new ServiceException("Unabling to perform updateOrder from orderService: " + e);
		}
	}

	@Override
	public int deleteItem(final long id) throws ServiceException {
		
		try {
			return orderDao.deleteItem(id);
		} catch (DaoException e) {
			LOGGER.error("Unabling to perform deleteOrder from orderService: " + e);
			throw new ServiceException("Unabling to perform deleteOrder from orderService: " + e);
		}
	}

}
