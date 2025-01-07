package com.echange.currencyexhange.models;

//this is the response model being sent for the post request
public class ConvertedModel {

	private String from;
	private String to;
	private int amount;
	private double ConvertedAmount;
	
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
	public double getConvertedAmount() {
		return ConvertedAmount;
	}
	public void setConvertedAmount(double convertedAmount) {
		ConvertedAmount = convertedAmount;
	}
	
	public ConvertedModel() {
		super();		
	}		
	
}
