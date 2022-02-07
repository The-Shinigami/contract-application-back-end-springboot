package org.lsi.entities;

import java.math.BigInteger;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection="contracts")
public class Contract {

	@Id
	private String id;
	
	private User buyer;
	private User seller;
	private BigInteger cost;
	private String date;
	private Proprety prop;
	private String desc;
	
	public Contract() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contract(String id, User buyer, User seller, BigInteger cost, String date, Proprety prop, String desc) {
		super();
		this.id = id;
		this.buyer = buyer;
		this.seller = seller;
		this.cost = cost;
		this.date = date;
		this.prop = prop;
		this.desc = desc;
	}
	
	

	public Contract(User buyer, User seller, BigInteger cost, String date, Proprety prop, String desc) {
		super();
		this.buyer = buyer;
		this.seller = seller;
		this.cost = cost;
		this.date = date;
		this.prop = prop;
		this.desc = desc;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getBuyer() {
		return buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	public BigInteger getCost() {
		return cost;
	}

	public void setCost(BigInteger cost) {
		this.cost = cost;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Proprety getProp() {
		return prop;
	}

	public void setProp(Proprety prop) {
		this.prop = prop;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	
}
