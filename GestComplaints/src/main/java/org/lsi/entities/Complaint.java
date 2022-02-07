package org.lsi.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="complaints")
public class Complaint {

	@Id
	private String id;
	
	private String desc;
	private String date;
	private String email;
	private String reponse;
	
	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	public Complaint() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Complaint(String id, String desc, String date, String email) {
		super();
		this.id = id;
		this.desc = desc;
		this.date = date;
		this.email = email;
	}
	public Complaint(String id, String desc, String date, String email,String reponse) {
		super();
		this.id = id;
		this.desc = desc;
		this.date = date;
		this.email = email;
		this.reponse = reponse;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
