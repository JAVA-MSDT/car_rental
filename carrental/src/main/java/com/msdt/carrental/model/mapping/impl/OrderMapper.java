package com.msdt.carrental.model.mapping.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import com.msdt.carrental.domain.Order;
import com.msdt.carrental.model.mapping.GenericMapper;
import com.msdt.carrental.util.constants.OrderConstant;

/**
 * 
 * @author Ahmed Samy 
 * https://github.com/JAVA-MSDT
 */
public class OrderMapper implements GenericMapper<Order>{

	@Override
	public Order rowMapper(ResultSet resultSet) throws SQLException {
		
        long orderId = resultSet.getLong(OrderConstant.TABLE_ORDER_ID);
        long userId = resultSet.getLong(OrderConstant.TABLE_ORDER_USER_ID);
        long carId = resultSet.getLong(OrderConstant.TABLE_ORDER_CAR_ID);
        Date orderDate = resultSet.getDate(OrderConstant.TABLE_ORDER_DATE);
        Date returningDate = resultSet.getDate(OrderConstant.TABLE_ORDER_RETURN_DATE);
        boolean carReturned = resultSet.getBoolean(OrderConstant.TABLE_ORDER_CAR_RETURNED);
        double rentalcost = resultSet.getDouble(OrderConstant.TABLE_ORDER_RENTAL_COST);

        return new Order(orderId, userId, carId, orderDate, returningDate, carReturned, rentalcost);

	}

}
