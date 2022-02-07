package com.example.demo.models;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
 
@Id
  private String id;

  @NotBlank
  @Size(max = 20)
  private String username;


  @NotBlank
  @Size(max = 120)
  private String password;
  
  @NotBlank
  @Size(max = 20)
  private String nom;
  
  @NotBlank
  @Size(max = 20)
  private String prenom;
  
  @NotBlank
  @Size(max = 20)
  private String tel;
  
  @NotBlank
  @Size(max = 20)
  private String CIN;
  
  public String getCIN() {
	return CIN;
}

public void setCIN(String CIN) {
	this.CIN = CIN;
}

@Size(max = 100)
  private String account_address;
  
  public String getAccount_address() {
	return account_address;
}

public void setAccount_address(String account_address) {
	this.account_address = account_address;
}

@DBRef
  private Set<Role> roles = new HashSet<>();

  public User() {
  }

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  
  public User(String username,String password, String nom,String prenom, String tel) {
	super();
	this.username = username;
	this.password = password;
	this.nom = nom;
	this.prenom = prenom;
	this.tel = tel;
}



public User(String id, @NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
		@NotBlank @Size(max = 120) String password, @NotBlank @Size(max = 20) String nom,
		@NotBlank @Size(max = 20) String prenom, @NotBlank @Size(max = 20) String tel, Set<Role> roles) {
	super();
	this.id = id;
	this.username = username;
	this.password = password;
	this.nom = nom;
	this.prenom = prenom;
	this.tel = tel;
	this.roles = roles;
}

public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
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

public String getTel() {
	return tel;
}

public void setTel(String tel) {
	this.tel = tel;
}
  
  
}
