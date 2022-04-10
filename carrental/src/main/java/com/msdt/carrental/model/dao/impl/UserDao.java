package com.msdt.carrental.model.dao.impl;

import java.sql.Connection;
import java.util.List;

import com.msdt.carrental.domain.User;
import com.msdt.carrental.model.dao.api.AbstractDao;
import com.msdt.carrental.model.dao.api.DaoException;
import com.msdt.carrental.model.mapping.impl.UserMapper;
import com.msdt.carrental.util.MD5Encryptor;
import com.msdt.carrental.util.constants.UserConstant;

/**
 * 
 * @author Ahmed Samy https://github.com/JAVA-MSDT
 */
public class UserDao extends AbstractDao<User> {

	UserDao() {
	}

	UserDao(final Connection connection) {
		super(connection);
	}

	@Override
	public int insertItem(final User item) throws DaoException {
		System.out.println("UserDao: " + item);
		String encryptPassword = MD5Encryptor.encrypt(item.getUserPassword());
		return executeUpdate(UserConstant.INSERT_USER, item.getUserName(), item.getUserEmail(), encryptPassword,
				item.getUserAddress(), String.valueOf(item.isUserBlocked()), item.getUseRole().name());
	}

	@Override
	public List<User> getAllItems() throws DaoException {
		return queryForObjects(UserConstant.SELECT_ALL_USERS, new UserMapper());
	}

	@Override
	public User getItemById(final long id) throws DaoException {
		return queryForObject(UserConstant.SELECT_USER_BY_ID, new UserMapper(), String.valueOf(id));
	}

	@Override
	public int updateItem(final User item) throws DaoException {
		return executeUpdate(UserConstant.UPDATE_USER, item.getUserName(), item.getUserEmail(), item.getUserPassword(),
				item.getUserAddress(), String.valueOf(item.isUserBlocked()), item.getUseRole().name(),
				String.valueOf(item.getUserId()));
	}

	@Override
	public int deleteItem(final long id) throws DaoException {
		return executeUpdate(UserConstant.DELETE_USER_BY_ID, String.valueOf(id));
	}
	
	/////// Custom Queries ///////
	
	public User getUserByUserNameAndPassword(final String userName, final String userPassword) throws DaoException {
		System.out.println("Passowrd Bfore Encrypt: " + userPassword);
		String encryptPassword = MD5Encryptor.encrypt(userPassword).trim();
		System.out.println("Passowrd After Encrypt: " + encryptPassword);
		return queryForObject(UserConstant.SELECT_USER_BY_USER_NAME_PASSWORD, new UserMapper(), userName, encryptPassword);
	}
	
	

}
