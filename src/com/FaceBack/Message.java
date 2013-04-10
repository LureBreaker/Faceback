package com.FaceBack;

import java.io.Serializable;

import javax.persistence.Id;

public class Message implements Serializable {
	
	@Id private Long id;
	private String email;
	private int year;
	private String message;
	private String name;
	private String from;
	
	public Message() {

	}
	
	public Message(String email, int year, String message,String name, String from){
		this.email = email;
		this.year = year;
		this.message = message;
		this.name = name;
		this.from = from;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}
	
	
}
