package com.target.controller;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.target.model.Product;
import com.target.service.productService;

@RestController
public class productController {

	@Autowired
	productService productservice;

	String url = "https://redsky.target.com/v2/pdp/tcin/13860428?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics";
	ObjectMapper Obj = new ObjectMapper();

	// get the product from external API
	@RequestMapping(path = "/products", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Object getProductById(HttpServletRequest request) throws JsonProcessingException {
		RestTemplate restTemplate = new RestTemplate();
		Object obj = restTemplate.getForObject(url, Object.class);

		return obj;

	}

	// get Product by ID from mongo db
	@RequestMapping(path = "/products/{id}", method = RequestMethod.GET)
	public Product getProductById(@PathVariable("id") int id) {
		Product product = productservice.getProductById(id);
		if (product != null) {
			return product;
		} else {
			return null;
		}
	}

	// add product
	@RequestMapping(path = "/products", method = RequestMethod.POST)
	public Product getProductById(@RequestBody final Product product) {
		productservice.addProductById(product);
		return product;
	}

	// update product
	@RequestMapping(path = "/products", method = RequestMethod.PUT)
	public String updateProductById(@RequestBody final Product product) {
		String result = productservice.updateProductById(product);
		return result;
	}

	// delete Product by ID from mongo db
	@RequestMapping(path = "/products/{id}", method = RequestMethod.DELETE)
	public String deleteProductById(@PathVariable("id") int id) {
		String result = productservice.deleteProductById(id);
		return result;
	}

}