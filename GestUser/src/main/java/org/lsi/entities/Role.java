package org.lsi.entities;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="roles")
public class Role {
	
	@Id
	private String id_role;
	
	private ERole name;

	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(String id_role, ERole name) {
		super();
		this.id_role = id_role;
		this.name = name;
	}

	public String getId_role() {
		return id_role;
	}

	public void setId_role(String id_role) {
		this.id_role = id_role;
	}

	public ERole getName() {
		return name;
	}

	public void setName(ERole name) {
		this.name = name;
	}

}
