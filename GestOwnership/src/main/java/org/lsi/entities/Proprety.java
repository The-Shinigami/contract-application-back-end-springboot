package org.lsi.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="propreties")
public class Proprety {

	@Id
	String id;
	
	String typePrp;
	String desc;
	User owner;
	
	public Proprety() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Proprety(String id, String typePrp, String desc, User owner) {
		super();
		this.id = id;
		this.typePrp = typePrp;
		this.desc = desc;
		this.owner = owner;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTypePrp() {
		return typePrp;
	}
	public void setTypePrp(String typePrp) {
		this.typePrp = typePrp;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	
}
