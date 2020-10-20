package dev.wael.jaxRS.services.entities;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {

	private int id;
	private String text;
	private Date dateTime;

	public Message() {

		// TODO Auto-generated constructor stub
	}

	public Message(int id, String text, Date dateTime) {

		this.id = id;
		this.text = text;
		this.dateTime = dateTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "\nMessage [ id=" + id + ",text=" + text + ", dateTime=" + dateTime + "]";
	}

}
