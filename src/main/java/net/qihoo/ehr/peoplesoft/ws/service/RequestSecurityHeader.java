package net.qihoo.ehr.peoplesoft.ws.service;

public class RequestSecurityHeader {

	/**
	 * 加密方式
	 */
	private String userName;

	/**
	 * 加密方式
	 */
	private String password;

	/**
	 * 加密方式
	 */
	private String passwordType;
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordType() {
		return passwordType;
	}

	public void setPasswordType(String passwordType) {
		this.passwordType = passwordType;
	}

}
