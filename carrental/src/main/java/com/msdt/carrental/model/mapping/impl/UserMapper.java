package com.msdt.carrental.model.mapping.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.msdt.carrental.domain.User;
import com.msdt.carrental.domain.UserRole;
import com.msdt.carrental.model.mapping.GenericMapper;

/**
 * 
 * @author Ahmed Samy 
 * https://github.com/JAVA-MSDT
 */
public class UserMapper implements GenericMapper<User>{

	@Override
	public User rowMapper(final ResultSet resultSet) throws SQLException {
		long userId = resultSet.getLong("user_id");
		String userName = resultSet.getString("user_name");
		String userEmail = resultSet.getString("user_email");
		String userPassword = resultSet.getString("user_password");
		String userAddress = resultSet.getString("user_address");
		boolean userBlocked = resultSet.getBoolean("user_blocked");
		UserRole useRole = UserRole.valueOf(resultSet.getString("user_role"));

		return new User(userId, userName, userEmail, userPassword, userAddress, userBlocked, useRole);
	}

}
