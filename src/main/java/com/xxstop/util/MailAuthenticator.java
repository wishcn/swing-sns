package com.xxstop.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;import java.lang.String;

/**
 * 统一定义用户名和密码
 */
public class MailAuthenticator extends Authenticator {
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 密码
	 */
	private String password;

	/**
	 * 带参构造函数
	 * 
	 * @param userName
	 * @param password
	 */
	public MailAuthenticator(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	protected PasswordAuthentication getPasswordAuthentication(){   
	   return new PasswordAuthentication(userName, password);   
	}
	/**
	 * 获取用户名
	 * 
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置用户名
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 获取密码
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置密码
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
