package com.target.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Price {
	private double current_price;
	private String currency_code;

	public double getCurrent_price() {
		return current_price;
	}

	public void setCurrent_price(double current_price) {
		this.current_price = current_price;
	}

	public String getCurrency_code() {
		return currency_code;
	}

	public void setCurrency_code(String currency_code) {
		this.currency_code = currency_code;
	}

}
