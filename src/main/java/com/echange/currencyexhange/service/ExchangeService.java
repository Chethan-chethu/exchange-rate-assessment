package com.echange.currencyexhange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import com.echange.currencyexhange.models.ResultModel;

import com.echange.currencyexhange.models.ConversionModel;
import com.echange.currencyexhange.models.ConvertedModel;
import com.echange.currencyexhange.models.DemoModel;

@Service
public class ExchangeService {

	@Autowired
	private RestTemplate restTemplate;
		
	// api key is stored in application.properties file
	@Value("${api.sceret.key}")
	private String apiKey;
	
	
	public ResponseEntity<Object> getCurrencyRates(String base) {	
		try {
			// if no currency code is provide , then by default it is USD
			base=base==null? "USD": base;
			String url="https://v6.exchangerate-api.com/v6/"+apiKey+"/latest/"+base;
			
			// RestModel data contains the exchange rates for a specific currency
			ResponseEntity<ResultModel> response=restTemplate.getForEntity(url, ResultModel.class);	
			HttpStatusCode statusCode=response.getStatusCode();
			return  ResponseEntity.status(statusCode).body(response.getBody());
			} 
		    // if any client side exception occurs, then we will set the respective code and response recieved from the api 
			catch (HttpClientErrorException e) {
				return ResponseEntity.status(e.getStatusCode()).body( e.getResponseBodyAsString());
			}
		    // if any server side exception occurs, then we will set the respective code and response recieved from the api
			catch (HttpServerErrorException e) {
				return ResponseEntity.status(e.getStatusCode()).body( e.getResponseBodyAsString());
			}
			// if any exception occurs from java side, then we will set internal server error code and response
			catch (Exception e) {
				return ResponseEntity.status(500).body("Internal Server Error");
			}	
	}
	
	public ResponseEntity<Object> doConversion(ConversionModel conversionModel){
		try {
			String from=conversionModel.getFrom();
			String to=conversionModel.getTo();
			int amount=conversionModel.getAmount();
			
			String url="https://v6.exchangerate-api.com/v6/"+apiKey+"/pair/"+from+"/"+to+"/"+amount;
			ResponseEntity<DemoModel> demoModelResponse=restTemplate.getForEntity(url, DemoModel.class);
			HttpStatusCode statusCode=demoModelResponse.getStatusCode();
			
			// this model is used to only extract the converted result filed from the response object
			DemoModel demoModel=demoModelResponse.getBody();
			
			// Model to be sent as response type
			ConvertedModel convertedModel=new ConvertedModel();
			convertedModel.setFrom(from);
			convertedModel.setTo(to);
			convertedModel.setAmount(amount);
			convertedModel.setConvertedAmount(demoModel.getConversion_result());
			
			return ResponseEntity.status(statusCode).body(convertedModel);
			}
			// if any client side exception occurs, then we will set the respective code and response recieved from the api
			catch (HttpClientErrorException e) {
				return ResponseEntity.status(e.getStatusCode()).body( e.getResponseBodyAsString());
			}
			// if any server side exception occurs, then we will set the respective code and response recieved from the api		
			catch (HttpServerErrorException e) {
				return ResponseEntity.status(e.getStatusCode()).body( e.getResponseBodyAsString());
			}
			// if any exception occurs from java side, then we will set internal server error code and response
			catch (Exception e) {
				return ResponseEntity.status(500).body("Internal Server Error");
			}			
	}
	
}
