package com.msdt.carrental.model.dao.impl;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.msdt.carrental.domain.Order;
import com.msdt.carrental.model.config.DBTestConfig;

/**
 * 
 * @author Ahmed Samy https://github.com/JAVA-MSDT
 */
public class OrderDaoTest {

	private DBTestConfig testConfig = new DBTestConfig();
	private DaoFactory daoFactory = DaoFactory.INSTANCE;
	private OrderDao orderDao;
	private Connection connection;
	Date orderDate;
	Date returnDate;

	/**
	 * This method will run before each single test in the class
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		connection = testConfig.getConnection();
		daoFactory.setConnection(connection);
		orderDao = daoFactory.getOrderDao();
	}

	/**
	 * This method will run after each single test in the class
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		connection = null;
		orderDao = null;
		orderDate = null;
		returnDate = null;
	}

	@Test
	public void testInsertItem() throws Exception {

		Order order = new Order(1, 1, Date.valueOf(LocalDate.of(2021, 10, 26)),
				Date.valueOf(LocalDate.of(2021, 11, 23)), 295.9);

		orderDao.insertItem(order);

		List<Order> orders = orderDao.getAllItems();
		int actualordersSize = orders.size();
		int expectedordersSize = 101;

		assertEquals(expectedordersSize, actualordersSize);
	}

	@Test
	public void testGetAllItems() throws Exception {
		List<Order> orders = orderDao.getAllItems();
		int actualordersSize = orders.size();
		int expectedordersSize = 100;

		assertEquals(expectedordersSize, actualordersSize);
	}

	@Test
	public void testGetItemById() throws Exception {

		Order exectedOrder = new Order(1, 1, 1, Date.valueOf(LocalDate.of(2020, 05, 26)),
				Date.valueOf(LocalDate.of(2020, 04, 23)), true, 29235.9);
		Order actualOrder = orderDao.getItemById(1);

		assertEquals(exectedOrder, actualOrder);
	}

	@Test
	public void testUpdateItem() throws Exception {

		Order exectedOrder = new Order(1, 1, 1, Date.valueOf(LocalDate.of(2022, 05, 26)),
				Date.valueOf(LocalDate.of(2020, 04, 10)), false, 29235.9);

		int actualUpdateStatus = orderDao.updateItem(exectedOrder);
		int expectedUpdateStatus = 1;

		assertEquals(expectedUpdateStatus, actualUpdateStatus);
	}

	@Test
	public void testDeleteItem() throws Exception {

		Order order = new Order(1, 1, Date.valueOf(LocalDate.of(2021, 10, 26)),
				Date.valueOf(LocalDate.of(2021, 11, 23)), 295.9);

		orderDao.insertItem(order);

		int actualDeleteStatus = orderDao.deleteItem(101);
		int expectedDeleteStatus = 1;

		List<Order> orders = orderDao.getAllItems();
		int actualordersSize = orders.size();
		int expectedordersSize = 100;

		assertEquals(expectedordersSize, actualordersSize);
		assertEquals(expectedDeleteStatus, actualDeleteStatus);
	}

}
