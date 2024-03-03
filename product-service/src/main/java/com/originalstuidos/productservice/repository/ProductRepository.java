package com.originalstuidos.productservice.repository;

import com.originalstuidos.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
