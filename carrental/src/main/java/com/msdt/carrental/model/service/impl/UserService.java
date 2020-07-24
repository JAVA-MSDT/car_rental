package com.msdt.carrental.model.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.msdt.carrental.domain.User;
import com.msdt.carrental.model.dao.api.DaoException;
import com.msdt.carrental.model.dao.impl.UserDao;
import com.msdt.carrental.model.service.api.GenericService;
import com.msdt.carrental.model.service.api.ServiceException;

public class UserService implements GenericService<User> {
	private static final Logger LOGGER = LogManager.getLogger();

	private UserDao userDao;

	UserService(final UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public int insertItem(final User item) throws ServiceException {
		try {
			return userDao.insertItem(item);
		} catch (DaoException e) {
			LOGGER.error("Unabling to perform insert from userService: " + e);
			throw new ServiceException("Unabling to perform insert from userService: " + e);
		}
	}

	@Override
	public List<User> getAllItems() throws ServiceException {

		try {
			return userDao.getAllItems();
		} catch (DaoException e) {
			LOGGER.error("Unabling to perform getAll from userService: " + e);
			throw new ServiceException("Unabling to perform getAll from userService: " + e);
		}
	}

	@Override
	public User getItemById(final long id) throws ServiceException {

		try {
			return userDao.getItemById(id);
		} catch (DaoException e) {
			LOGGER.error("Unabling to perform GetItemByID from userService: " + e);
			throw new ServiceException("Unabling to perform GetItemByID from userService: " + e);
		}
	}

	@Override
	public int updateItem(final User item) throws ServiceException {

		try {
			return userDao.updateItem(item);
		} catch (DaoException e) {
			LOGGER.error("Unabling to perform updateItem from userService: " + e);
			throw new ServiceException("Unabling to perform updateItem from userService: " + e);
		}
	}

	@Override
	public int deleteItem(final long id) throws ServiceException {
		try {
			return userDao.deleteItem(id);
		} catch (DaoException e) {
			LOGGER.error("Unabling to perform updateItem from userService: " + e);
			throw new ServiceException("Unabling to perform updateItem from userService: " + e);
		}
	}

}
