package com.msdt.carrental;

import com.msdt.carrental.domain.User;
import com.msdt.carrental.domain.UserRole;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(final String[] args) {

		User user = new User(1, "Adam", "Emain", "Password ", "Adres", false, UserRole.ADMIN);

		System.out.println("User: " + user);
		System.out.println(user.getUserPassword());
	}
}
