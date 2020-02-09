package com.target.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.target.DOA.productDOA;
import com.target.model.Product;

@Service
public class productService {

	@Autowired
	productDOA productdoa;

	public Product getProductById(int id) {
		Product product = productdoa.findById(id);
		return product;
	}

	public Product addProductById(Product product) {
		productdoa.save(product);
		return product;
	}

	public String updateProductById(Product product) {
		// find the product
		Product isProductFound = productdoa.findById(product.getId());
		if (isProductFound != null) {
			// update that record
			isProductFound.setName(product.getName());
			isProductFound.setCurrent_price(product.getCurrent_price());
			productdoa.save(isProductFound);
			return "Product successfully updated";
		} else {
			return "Product not found";
		}

	}

	public String deleteProductById(int id) {
		Product product = productdoa.findById(id);
		if (product != null) {
			productdoa.delete(product);
			return "Product successfully deleted";
		} else {
			return "Product not found";
		}
	}

}
