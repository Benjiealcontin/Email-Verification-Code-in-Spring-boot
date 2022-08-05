package com.operation.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String email;
	private String code;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String username, String email, String code) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.code = code;
	}
	public User(String username, String email, String code) {
		super();
		this.username = username;
		this.email = email;
		this.code = code;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	
	
}
