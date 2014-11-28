package com.xxstop.util;

import java.util.Date;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * 发送邮件
 */
public class MailUtils {

	/**
	 * 邮件基本信息
	 */
	private MailSenderInfo msInfo;

	/**
	 * 带参构造函数
	 * 
	 * @param msInfo
	 */
	public MailUtils(MailSenderInfo msInfo) {
		this.msInfo = msInfo;
	}

	/**
	 * 发送文本邮件
	 * 
	 * @return boolean
	 */
	public boolean sendTextEmail() {
		return sendEmail("text");
	}

	/**
	 * 发送HTML邮件
	 * 
	 * @return boolean
	 */
	public boolean sendHtmlEmail() {
		return sendEmail("html");
	}

	/**
	 * 发送邮件
	 * 
	 * @param flag
	 * @return boolean
	 */
	private boolean sendEmail(String flag) {
		
		Authenticator authenticator = null;
		
		// 是否需要身份验证
		if (msInfo.isValidate()) {
			authenticator = new MailAuthenticator(msInfo.getUserName(), msInfo.getPassword());
		}
		// 根据邮件会话属性和密码验证器构造一个发送邮件的session
		Session session = Session.getDefaultInstance(msInfo.getProperties(),
				authenticator);
		try {
			// 根据session创建一个邮件消息
			Message mimeMessage = new MimeMessage(session);
			// 创建邮件发送者地址
			Address fromAddress = new InternetAddress(msInfo.getFromAddress());
			// 设置邮件消息的发送者
			mimeMessage.setFrom(fromAddress);
			// 创建邮件的接收者地址，并设置到邮件消息中(可同时发送多封邮件)
			Address[] toAddress = new InternetAddress[msInfo.getToAddress().size()];
			for(int i = 0; i < toAddress.length; i++){
				toAddress[i] =new InternetAddress( msInfo.getToAddress().get(i));
			}
			mimeMessage.setRecipients(Message.RecipientType.TO, toAddress);
			// 设置邮件消息的主题
			mimeMessage.setSubject(msInfo.getSubject());
			// 设置邮件消息发送的时间
			mimeMessage.setSentDate(new Date());
			
			// 邮件内容
			String content = msInfo.getContent();
			
			// 设置邮件消息的主要内容
			if ("text".equals(flag)) {
				mimeMessage.setText(content);
			}
			if ("html".equals(flag)) {
				// MimeMultipart类是一个容器类，包含MimeBodyPart类型的对象
				Multipart multipart = new MimeMultipart();
				// 创建一个包含HTML内容的MimeBodyPart
				BodyPart html = new MimeBodyPart();
				// 设置HTML内容
				html.setContent(content, "text/html; charset=utf-8");
				multipart.addBodyPart(html);
				// 将MimeMultipart对象设置为邮件内容
				mimeMessage.setContent(multipart);
			}
			// 发送邮件
			Transport.send(mimeMessage);
			return true;
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
		return false;
	}
}
