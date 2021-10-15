package com.mycompany.productapi.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mycompany.productapi.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

	
}
