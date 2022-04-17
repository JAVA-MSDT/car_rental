package com.msdt.carrental.model.dao.impl;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.msdt.carrental.domain.Car;
import com.msdt.carrental.model.config.DBTestConfig;

/**
 * 
 * @author Ahmed Samy https://github.com/JAVA-MSDT
 */
public class CarDaoTest {

	private DBTestConfig testConfig = new DBTestConfig();
	private DaoFactory daoFactory = DaoFactory.INSTANCE;
	private CarDao carDao;
	private Connection connection;

	/**
	 * This method will run before each single test in the class
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		connection = testConfig.getConnection();
		daoFactory.setConnection(connection);
		carDao = daoFactory.getCarDao();
	}

	/**
	 * This method will run after each single test in the class
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		connection = null;
		carDao = null;
	}

	@Test
	public void testInsertItem() throws Exception {
		Car expectedCar = new Car("Sidan", "2020", "Red", "BMW", 2);

		assertEquals(1, carDao.insertItem(expectedCar));
	}

	@Test
	public void testGetAllItems() throws Exception {
		List<Car> cars = carDao.getAllItems();
		assertEquals(100, cars.size());
	}

	@Test
	public void testGetItemById() throws Exception {
		Car actualCar = carDao.getItemById(4);
		Car expectedCar = new Car(4, "Suburban 2500", "1996", "Green", "GMC", 4);
		System.out.println(actualCar);

		assertEquals(expectedCar, actualCar);
	}

	@Test
	public void testUpdateItem() throws Exception {
		Car expectedCar = new Car(4, "Suburban 2500", "2010", "Brown", "Audi", 5);

		assertEquals(1, carDao.updateItem(expectedCar));
	}

	@Test
	public void testDeleteItem() throws Exception {
		Car expectedCar = new Car("Sidan", "2020", "Red", "BMW", 3);
		carDao.insertItem(expectedCar);

		assertEquals(1, carDao.deleteItem(101));
	}

}
