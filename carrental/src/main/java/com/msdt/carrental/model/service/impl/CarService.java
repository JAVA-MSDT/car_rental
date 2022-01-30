package com.msdt.carrental.model.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.msdt.carrental.domain.Car;
import com.msdt.carrental.model.dao.api.DaoException;
import com.msdt.carrental.model.dao.impl.CarDao;
import com.msdt.carrental.model.service.api.GenericService;
import com.msdt.carrental.model.service.api.ServiceException;

public class CarService implements GenericService<Car> {
	private static final Logger LOGGER = LogManager.getLogger();
	private CarDao carDao;
	
	 CarService(final CarDao carDao) {
		this.carDao = carDao;
	}
	
	@Override
	public int insertItem(final Car car) throws ServiceException {
		
		try {
			return carDao.insertItem(car);
		} catch (DaoException e) {
			LOGGER.error("Unabling to perform insert from carService: " + e);
			throw new ServiceException("Unabling to perform insert from carService: " + e);
		}
	}

	@Override
	public List<Car> getAllItems() throws ServiceException {
		
		try {
			return carDao.getAllItems();
		} catch (DaoException e) {
			LOGGER.error("Unabling to perform getAllCars from carService: " + e);
			throw new ServiceException("Unabling to perform getAllCars from carService: " + e);
		}
	}

	@Override
	public Car getItemById(final long id) throws ServiceException {
		
		try {
			return carDao.getItemById(id);
		} catch (DaoException e) {
			LOGGER.error("Unabling to perform getCarById from carService: " + e);
			throw new ServiceException("Unabling to perform getCarById from carService: " + e);
		}
	}

	@Override
	public int updateItem(final Car car) throws ServiceException {
		
		try {
			return carDao.updateItem(car);
		} catch (DaoException e) {
			LOGGER.error("Unabling to perform update Car from carService: " + e);
			throw new ServiceException("Unabling to perform update Car from carService: " + e);
		}
	}

	@Override
	public int deleteItem(final long id) throws ServiceException {
		
		try {
			return carDao.deleteItem(id);
		} catch (DaoException e) {
			LOGGER.error("Unabling to perform delete Car from carService: " + e);
			throw new ServiceException("Unabling to perform delete Car from carService: " + e);
		}
	}

}
