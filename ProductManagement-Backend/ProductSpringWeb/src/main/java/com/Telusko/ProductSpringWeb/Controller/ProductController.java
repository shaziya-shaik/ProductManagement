package com.Telusko.ProductSpringWeb.Controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Telusko.ProductSpringWeb.Model.Product;
import com.Telusko.ProductSpringWeb.Service.ProductService;


@RestController
@CrossOrigin(origins = "http://localhost:4200") 
public class ProductController {
	@Autowired
	ProductService service;
	@GetMapping("/")
	public List<Product> getAllProducts() throws SQLException{
		return service.getAllProducts();
		
	}
	
	
	
	@PostMapping("/product")
	public void addProduct(@RequestBody Product p) throws SQLException {
		 service.addProduct(p);
	}
	

	
	@GetMapping("/product/{id}")
	public Optional<Product> getById(@PathVariable Integer id) {
	    return service.getById(id);
	}

	@PutMapping("/product/{id}")
	public void updateProduct(@PathVariable Integer id, @RequestBody Product p) throws SQLException {
	    p.setId(id);
	    service.UpdateProduct(p);
	}

	@DeleteMapping("/product/{id}")
	public Optional<Product> deleteById(@PathVariable Integer id) {
	    return service.deleteById(id);
	}
	
}

