package cn.com.sky.tools.test_mail.demo2;

public class Mailbox {
	private String host;
	private String name;
	private String password;
	private String from;
	private String to;
	private String subject;
	private String content;

	public Mailbox(String host, String name, String password, MailInfo mailInfo) {
		this.host = host;
		this.name = name;
		this.password = password;
		this.from = mailInfo.getFrom();
		this.to = mailInfo.getTo();
		this.subject = mailInfo.getSubject();
		this.content = mailInfo.getContent();
	}

	public boolean sendTextMail() {
		TextMail textMail = new TextMail(host, name, password);
		textMail.setFrom(from);
		textMail.setText(content);
		textMail.setTo(to);
		textMail.setSubject(subject);
		return textMail.send();
	}

	public boolean sendHtmlMail() {
		TextMail textMail = new TextMail(host, name, password);
		textMail.setFrom(from);
		textMail.setBody(content);
		textMail.setTo(to);
		textMail.setSubject(subject);
		return textMail.send();
	}
}