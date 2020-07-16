package com.msdt.carrental;

import java.sql.SQLException;
import java.util.List;

import com.msdt.carrental.domain.User;
import com.msdt.carrental.domain.UserRole;
import com.msdt.carrental.model.dao.impl.UserDao;

public class App {

	public static void main(final String[] args) throws SQLException {

		UserDao userDao = new UserDao();

		System.out.println("============================ SELECT ALL ===============================");

		List<User> users = userDao.getAllItems();
		users.forEach(System.out::println);

		System.out.println("============================ SELECT BY ID ===============================");

		User user = userDao.getItemById(4);
		System.out.println(" Item By Id: " + user);
		System.out.println("============================ DELETE ===============================");

		System.out.println("Deleted Status: " + userDao.deleteItem(104));
		List<User> usersAfterDelete = userDao.getAllItems();
		usersAfterDelete.forEach(System.out::println);
		System.out.println("============================ UPDATE ===============================");
		User userBeforeUpdate = userDao.getItemById(2);
		System.out.println(" userBeforeUpdate: " + userBeforeUpdate);
		User updateUser = new User(2, "userName", "userEmail", "userPassword", "userAddress", false, UserRole.ADMIN);
		System.out.println("Updated Status: " + userDao.updateItem(updateUser));
		User userAfterUpdate = userDao.getItemById(2);
		System.out.println(" userAfterUpdate: " + userAfterUpdate);
		System.out.println("============================ INSERT  ===============================");
		User newuser = new User("userName", "New UserEmail", "userPassword", "userAddress", false, UserRole.ADMIN);
		System.out.println("Insert Starus: " + userDao.insertItem(newuser));
		List<User> userNew = userDao.getAllItems();
		userNew.forEach(System.out::println);
	}
}
