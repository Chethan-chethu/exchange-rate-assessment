package com.echange.currencyexhange.models;

import java.util.Map;

// Utility Model 
public class ResultModel {

	private Map<String,Object> conversion_rates;

	public Map<String, Object> getConversion_rates() {
		return conversion_rates;
	}

	public void setConversion_rates(Map<String, Object> conversion_rates) {
		this.conversion_rates = conversion_rates;
	}

	public ResultModel() {
		super();	
	}
		
}
