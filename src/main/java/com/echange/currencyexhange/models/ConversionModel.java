package com.echange.currencyexhange.models;

// this model is sent in the form of request body in the post request to convert currencies
public class ConversionModel {

	private String from;
	private String to;
	private int amount;
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public ConversionModel() {
		super();		
	}
			
}
