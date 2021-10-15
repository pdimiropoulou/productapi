package com.mycompany.productapi.controllers;

import java.sql.Date;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.productapi.entities.Product;
import com.mycompany.productapi.repositories.ProductRepository;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	ProductRepository  repository; 
	
	@PostMapping("/add")
	public @ResponseBody Map<String,Boolean> addNewProduct(@Valid @RequestBody Product obj) {
		repository.save(obj);
		
		return Collections.singletonMap("succeed",true);
	}
	
	@PostMapping("/update")
	public @ResponseBody Map<String,Boolean> updateProducts(@Valid @RequestBody Product obj) {
		repository.save(obj);
		
		return Collections.singletonMap("succeed",true);
	}
	
	@GetMapping("/get/{productid}")
	public @ResponseBody Product getProduct(@PathVariable("productid") Integer id) {
		
		return repository.findById(id).get();
	}
	
	@GetMapping("/getall")
	public @ResponseBody Iterable<Product> getAllProducts() {
		
		return repository.findAll();
	}

	@DeleteMapping("/delete/{productid}")
	public @ResponseBody Map<String,Boolean> deleteProduct(@PathVariable("productid") Integer id) {
		repository.delete(repository.findById(id).get());
		
		return Collections.singletonMap("succeed",true); 
	}
	
}
