package com.maildocker.api.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Message implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Address from;
	
	private Address to;
	
	private String subject;
	
	private String text;
	
	private String html;
	
	public static Message getExample(Address to) {
		Message inst = new Message();
		inst.setTo(to);
		inst.setFrom(Address.getInstance("Maildocker", "maildocker@maildocker.io"));
		inst.setSubject("MailDocker Java API " + new SimpleDateFormat("MM/dd/yyyy HH:mm").format(new Date()));
		inst.setText("Sent from Java API");	
		return inst;
	}
	
	public static Message getInstance(Address from, Address to, String subject, String text, String html) {
		Message inst = new Message();
		inst.setFrom(from);
		inst.setTo(to);
		inst.setSubject(subject);
		inst.setText(text);	
		inst.setHtml(html);
		return inst;
	}
	
	public static Message getInstanceText(Address from, Address to, String subject, String text) {
		Message inst = new Message();
		inst.setFrom(from);
		inst.setTo(to);
		inst.setSubject(subject);
		inst.setText(text);	
		return inst;
	}
	
	public static Message getInstanceHtml(Address from, Address to, String subject, String html) {
		Message inst = new Message();
		inst.setFrom(from);
		inst.setTo(to);
		inst.setSubject(subject);
		inst.setHtml(html);
		return inst;
	}

	public Address getFrom() {
		return from;
	}

	public void setFrom(Address from) {
		this.from = from;
	}

	public Address getTo() {
		return to;
	}

	public void setTo(Address to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
//		this.text = StringUtil.replaceSpecialCharToUnicode(text);
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

}
