package com.msdt.carrental.model.mapping.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.msdt.carrental.domain.User;
import com.msdt.carrental.domain.UserRole;
import com.msdt.carrental.model.mapping.GenericMapper;
import com.msdt.carrental.util.constants.UserConstant;

/**
 * 
 * @author Ahmed Samy 
 * https://github.com/JAVA-MSDT
 */
public class UserMapper implements GenericMapper<User>{

	@Override
	public User rowMapper(final ResultSet resultSet) throws SQLException {
		long userId = resultSet.getLong(UserConstant.TABLE_USER_ID);
		String userName = resultSet.getString(UserConstant.TABLE_USER_NAME);
		String userEmail = resultSet.getString(UserConstant.TABLE_USER_EMAIL);
		String userPassword = resultSet.getString(UserConstant.TABLE_USER_PASSWORD);
		String userAddress = resultSet.getString(UserConstant.TABLE_USER_ADDRESS);
		boolean userBlocked = resultSet.getBoolean(UserConstant.TABLE_USER_BLOCK_STATUS);
		UserRole useRole = UserRole.valueOf(resultSet.getString(UserConstant.TABLE_USER_ROLE));

		return new User(userId, userName, userEmail, userPassword, userAddress, userBlocked, useRole);
	}

}
