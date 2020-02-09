package com.target.DOA;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.target.model.Product;

@Repository
public interface productDOA extends MongoRepository<Product, Integer> {

	Product findById(int id);

	Product save(Product product);

}
