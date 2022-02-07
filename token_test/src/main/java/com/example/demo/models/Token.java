package com.example.demo.models;


import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_token")
public class Token {
	@Id
	private String id;
	@NotBlank
	@Size(max = 20)
	private String token;
	@DBRef
	private User user;
	
	
	
	public Token(String jwt, User user) {
		this.token = jwt;
		this.user = user;
	}
	public Token(String id,String token, User user) {
		super();
		this.id = id;
		this.token = token;
		this.user = user;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
