package com.oop.staffManagement.model;

public class RequestModel {
	private int id;
	private String name;
	private String amount;
	private String reson;
	private String date;
	public RequestModel(int id, String name, String amount, String reson, String date) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.reson = reson;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getReson() {
		return reson;
	}
	public void setReson(String reson) {
		this.reson = reson;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}