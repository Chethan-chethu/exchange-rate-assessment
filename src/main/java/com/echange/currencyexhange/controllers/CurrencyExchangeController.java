package com.echange.currencyexhange.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.echange.currencyexhange.models.ConversionModel;
import com.echange.currencyexhange.service.ExchangeService;

@RestController
@RequestMapping("api")
public class CurrencyExchangeController {	
	
	@Autowired
	private ExchangeService exchangeService;	
	
	@GetMapping("/rates")
	public ResponseEntity<Object> getCurrencyRates(@RequestParam(name="base",required = false) String base) {			
		return exchangeService.getCurrencyRates(base);		
	}
		
	@PostMapping("/convert")
	public ResponseEntity<Object> doConversion(@RequestBody ConversionModel conversionModel){
		return exchangeService.doConversion(conversionModel);
	}
	
}
