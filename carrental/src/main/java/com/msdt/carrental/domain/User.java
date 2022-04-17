package com.msdt.carrental.domain;

/**
 * 
 * @author Ahmed Samy 
 * https://github.com/JAVA-MSDT
 */
public class User {

	// Variables
	private long userId;
	private String userName;
	private String userEmail;
	private String userPassword;
	private String userAddress;
	private boolean userBlocked;
	private UserRole userRole;

	// Constructors
	public User() {

	}

	public User(final String userName, final String userEmail, final String userPassword, final String userAddress,
			final boolean userBlocked, final UserRole userRole) {

		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userAddress = userAddress;
		this.userBlocked = userBlocked;
		this.userRole = userRole;
	}

	public User(final long userId, final String userName, final String userEmail, final String userPassword,
			final String userAddress, final boolean userBlocked, final UserRole userRole) {

		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userAddress = userAddress;
		this.userBlocked = userBlocked;
		this.userRole = userRole;
	}

	// Setters & Getters
	public long getUserId() {
		return userId;
	}

	public void setUserId(final long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(final String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(final String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(final String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(final String userAddress) {
		this.userAddress = userAddress;
	}

	public boolean isUserBlocked() {
		return userBlocked;
	}

	public void setUserBlocked(final boolean userBlocked) {
		this.userBlocked = userBlocked;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(final UserRole userRole) {
		this.userRole = userRole;
	}

	// To String 
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword="
				+ userPassword + ", userAddress=" + userAddress + ", userBlocked=" + userBlocked + ", userRole="
				+ userRole + "]";
	}

	// Hash code
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((userRole == null) ? 0 : userRole.hashCode());
		result = (prime * result) + ((userAddress == null) ? 0 : userAddress.hashCode());
		result = (prime * result) + (userBlocked ? 1231 : 1237);
		result = (prime * result) + ((userEmail == null) ? 0 : userEmail.hashCode());
		result = (prime * result) + (int) (userId ^ (userId >>> 32));
		result = (prime * result) + ((userName == null) ? 0 : userName.hashCode());
		result = (prime * result) + ((userPassword == null) ? 0 : userPassword.hashCode());
		return result;
	}

	// Equals
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		User other = (User) obj;
		if (userRole != other.userRole) {
			return false;
		}
		if (userAddress == null) {
			if (other.userAddress != null) {
				return false;
			}
		} else if (!userAddress.equals(other.userAddress)) {
			return false;
		}
		if (userBlocked != other.userBlocked) {
			return false;
		}
		if (userEmail == null) {
			if (other.userEmail != null) {
				return false;
			}
		} else if (!userEmail.equals(other.userEmail)) {
			return false;
		}
		if (userId != other.userId) {
			return false;
		}
		if (userName == null) {
			if (other.userName != null) {
				return false;
			}
		} else if (!userName.equals(other.userName)) {
			return false;
		}
		if (userPassword == null) {
			if (other.userPassword != null) {
				return false;
			}
		} else if (!userPassword.equals(other.userPassword)) {
			return false;
		}
		return true;
	}



}
