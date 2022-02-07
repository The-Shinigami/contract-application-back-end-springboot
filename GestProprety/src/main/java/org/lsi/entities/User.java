package org.lsi.entities;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
public class User {
	
	@Id
	private String id;
	
	private String nom;
	private String prenom;
	private String username;
	private String password;
	private String CIN;
	private String tel;
	@DBRef
	private Set<Role> roles = new HashSet<>();
	
	
	
	public User(String id_user, String nom, String prenom, String username, String password, String cIN, String tel,Set<Role> roles) {
		super();
		this.id = id_user;
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.password = password;
		CIN = cIN;
		this.tel = tel;
		this.roles = roles;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId_user() {
		return id;
	}
	public void setId_user(String id_user) {
		this.id = id_user;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCIN() {
		return CIN;
	}
	public void setCIN(String cIN) {
		CIN = cIN;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	

}
