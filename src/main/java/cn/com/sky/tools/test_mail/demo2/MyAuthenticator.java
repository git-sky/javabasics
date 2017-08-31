package cn.com.sky.tools.test_mail.demo2;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MyAuthenticator extends Authenticator {
	String name;

	String password;

	/**
	 * 
	 * @param name
	 * @param password
	 */
	public MyAuthenticator(String name, String password) {
		this.name = name;
		this.password = password;
		getPasswordAuthentication();
	}

	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(name, password);
	}
}