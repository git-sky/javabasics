package cn.com.sky.tools.test_mail.demo2;

public class MailUtil {

	/**
	 * 
	 * @param to
	 *            接收人
	 * @param subject
	 *            邮件主题
	 * @param content
	 *            邮件内容
	 */
	public static void send(String to, String subject, String content) {
		String from = "xxx@126.com";

		String host = "mail.126.com";
		String name = "xxx@126.com";
		String password = "xxxxxx";
		MailInfo mailInfo = new MailInfo(from, to, subject, content);

		Mailbox mailBox = new Mailbox(host, name, password, mailInfo);
		try {
			if (mailBox.sendHtmlMail()) {
				System.out.println("Mail send successfully!");
			} else {
				System.out.println("Mail send failed!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		send("123456@qq.com", "test", "test");

	}
}