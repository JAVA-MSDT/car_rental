package com.msdt.carrental.model.dao.impl;

import java.util.List;

import com.msdt.carrental.domain.User;
import com.msdt.carrental.model.dao.GenericDao;

public class UserDao implements GenericDao<User>{

	@Override
	public int insertItem(final User item) {
		
		return 0;
	}

	@Override
	public List<User> getAllItems() {
		
		return null;
	}

	@Override
	public User getItemById(final long id) {
		
		return null;
	}

	@Override
	public int updateItem(final User item) {
		
		return 0;
	}

	@Override
	public int deleteItem(final long id) {
		
		return 0;
	}

}
