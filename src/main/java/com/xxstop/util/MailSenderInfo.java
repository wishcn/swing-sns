package com.xxstop.util;

import java.lang.String;
import java.util.List;
import java.util.Properties;

/**
 * 邮件基本信息
 */
public class MailSenderInfo {
	/**
	 * 发送邮件的服务器的IP
	 */
	private String mailServerHost;
	/**
	 * 发送邮件的服务器的端口
	 */
	private String mailServerPort;
	/**
	 * 邮件发送者的地址
	 */
	private String fromAddress;
	/**
	 * 邮件接收者的地址
	 */
	private List<String> toAddress;
	/**
	 * 登陆邮件发送服务器的用户名
	 */
	private String userName;
	/**
	 * 登陆邮件发送服务器的密码
	 */
	private String password;
	/**
	 * 是否需要身份验证
	 */
	private boolean validate = false;
	/**
	 * 邮件主题
	 */
	private String subject;
	/**
	 * 邮件的文本内容
	 */
	private String content;
	/**
	 * 邮件附件的文件名
	 */
	private List<String> attachFileNames;

	/**
	 * 获得邮件会话属性
	 * 
	 * @return Properties
	 */
	public Properties getProperties() {
		Properties p = new Properties();
		p.put("mail.smtp.host", this.mailServerHost);
		p.put("mail.smtp.port", this.mailServerPort);
		p.put("mail.smtp.auth", validate ? "true" : "false");
		return p;
	}

	/**
	 * 获取发送邮件的服务器的IP
	 * 
	 * @return String
	 */
	public String getMailServerHost() {
		return mailServerHost;
	}

	/**
	 * 设置发送邮件的服务器的IP
	 * 
	 * @return
	 */
	public void setMailServerHost(String mailServerHost) {
		this.mailServerHost = mailServerHost;
	}

	/**
	 * 获取发送邮件的服务器的端口
	 * 
	 * @return String
	 */
	public String getMailServerPort() {
		return mailServerPort;
	}

	/**
	 * 设置发送邮件的服务器的端口
	 * 
	 * @return
	 */
	public void setMailServerPort(String mailServerPort) {
		this.mailServerPort = mailServerPort;
	}

	/**
	 * 获取是否需要身份验证
	 * 
	 * @return boolean
	 */
	public boolean isValidate() {
		return validate;
	}

	/**
	 * 设置是否需要身份验证
	 * 
	 * @return
	 */
	public void setValidate(boolean validate) {
		this.validate = validate;
	}

	/**
	 * 获取发送附件的名称
	 * 
	 * @return List<String>
	 */
	public List<String> getAttachFileNames() {
		return attachFileNames;
	}

	/**
	 * 设置发送附件的名称
	 * 
	 * @param attachFileNames
	 */
	public void setAttachFileNames(List<String> attachFileNames) {
		this.attachFileNames = attachFileNames;
	}

	/**
	 * 获取邮件发送者的地址
	 * 
	 * @return String
	 */
	public String getFromAddress() {
		return fromAddress;
	}

	/**
	 * 设置邮件发送者的地址
	 * 
	 * @param fromAddress
	 */
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	/**
	 * 获取登陆邮件发送服务器的密码
	 * 
	 * @return String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置登陆邮件发送服务器的密码
	 * 
	 * @param
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 获取邮件接收者的地址
	 * 
	 * @return String
	 */
	public List<String> getToAddress() {
		return toAddress;
	}

	/**
	 * 设置邮件接收者的地址
	 * 
	 * @param toAddress
	 */
	public void setToAddress(List<String> toAddress) {
		this.toAddress = toAddress;
	}

	/**
	 * 获取登陆邮件发送服务器的用户名
	 * 
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置登陆邮件发送服务器的用户名
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 获取邮件主题
	 * 
	 * @return String
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * 设置邮件主题
	 * 
	 * @param subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * 获取邮件内容
	 * 
	 * @return String
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 设置邮件内容
	 * 
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}

}
