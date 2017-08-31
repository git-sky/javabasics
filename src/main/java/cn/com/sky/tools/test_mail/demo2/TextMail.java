package cn.com.sky.tools.test_mail.demo2;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * function: Send a mail to the specific address
 * 
 */
public class TextMail {
	private MimeMessage message;

	private Properties props;

	private Session session;

	private String name = "";

	private String password = "";

	private Multipart mp;

	/**
	 * complete the initialization
	 * 
	 * @param host
	 * @param name
	 * @param password
	 */
	public TextMail(String host, String name, String password) {
		this.name = name;
		this.password = password;
		props = System.getProperties();
		// set the SMTP host
		props.put("mail.smtp.host", host);
		// set SMTP authorization
		props.put("mail.smtp.auth", "true");
		// get the mail session
		MyAuthenticator auth = new MyAuthenticator(name, password);
		session = Session.getInstance(props, auth);
		// create MIME mail object
		message = new MimeMessage(session);
	}

	/**
	 * set mail sender
	 * 
	 * @param from
	 */
	public void setFrom(String from) {
		try {
			message.setFrom(new InternetAddress(from));
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * set mail recipient
	 * 
	 * @param to
	 */
	public void setTo(String to) {
		try {
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * set mail subject
	 * 
	 * @param subject
	 */
	public void setSubject(String subject) {
		try {
			message.setSubject(subject);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * set mail text
	 * 
	 * @param text
	 */
	public void setText(String text) {
		try {
			message.setText(text);
			// message.
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param mailBody
	 *            String
	 */
	public boolean setBody(String mailBody) {
		try {
			BodyPart bp = new MimeBodyPart();
			bp.setContent("<meta http-equiv=Content-Type content=text/html; charset=gb2312>" + mailBody, "text/html;charset=GB2312");
			mp = new MimeMultipart();
			mp.addBodyPart(bp);
			message.setContent(mp);
			return true;
		} catch (Exception e) {
			System.err.println("设置邮件正文时发生错误！" + e);
			return false;
		}
	}

	/**
	 * @param name
	 *            String
	 * @param pass
	 *            String
	 */
	public boolean addFileAffix(String filename) {

		System.out.println("增加邮件附件：" + filename);

		try {
			BodyPart bp = new MimeBodyPart();
			FileDataSource fileds = new FileDataSource(filename);
			bp.setDataHandler(new DataHandler(fileds));
			bp.setFileName(fileds.getName());

			mp = new MimeMultipart();
			mp.addBodyPart(bp);
			message.setContent(mp);
			return true;
		} catch (Exception e) {
			System.err.println("增加邮件附件：" + filename + "发生错误！" + e);
			return false;
		}
	}

	/**
	 * send mail
	 * 
	 * @return
	 */
	public boolean send() {
		try {
			// create SMTP sender object
			Transport transport = session.getTransport("smtp");
			// get the connection with server
			transport.connect((String) props.get("mail.smtp.host"), name, password);
			// send the mail via server
			transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
			transport.close();
			return true;
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
			return false;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
	}
}