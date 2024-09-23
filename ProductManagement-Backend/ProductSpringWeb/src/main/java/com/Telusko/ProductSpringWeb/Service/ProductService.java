package com.Telusko.ProductSpringWeb.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Telusko.ProductSpringWeb.Model.Product;
import com.Telusko.ProductSpringWeb.Repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;



@Service
public class ProductService {
	
	List<Product> products= new ArrayList<>();
	@Autowired
	ProductRepository Repo;
	public void addProduct(Product p) throws SQLException {
		// TODO Auto-generated method stub
		//products.add(p);
		
		Repo.save(p);
		
	}
	public List<Product> getAllProducts() throws SQLException {
		// TODO Auto-generated method stub
		return Repo.findAll();
		
	}
	public Product getProduct(String name) {
		// TODO Auto-generated method stub
		for(Product p:products) {
			if(p.getName().equals(name)) return p;
		}
		for(Product p:products) {
			if(p.getPlace().equals(name)) return p;
		}
		for(Product p:products) {
			if(p.getType().equals(name)) return p;
		}
		
		return null;
		
	}
	public Product getProduct(int warrenty) {
		// TODO Auto-generated method stub
		for(Product p:products) {
			if(p.getWarranty()==warrenty) return p;
		}
		return null;
		
	}
	public List<Product> getProductOutOfWarrenty(int warrenty) {
		// TODO Auto-generated method stub
		List<Product> pr=new ArrayList<>();
		for(Product p:products) {
			if(p.getWarranty()==warrenty) pr.add(p);
		}
		return pr;
	}
	public List<Product> getProductWithText(String string) {
		String str=string.toLowerCase();
		// TODO Auto-generated method stub
		List<Product> products=new ArrayList<>();
		
		for(Product p:products) {
			if(p.getName().toLowerCase().contains(string) || p.getType().toLowerCase().contains(string) || p.getPlace().toLowerCase().contains(string))
				products.add(p);
		}
			
		return products;
	}
	public Optional<Product> getById(Integer id) {
		// TODO Auto-generated method stub
		return Repo.findById(id);
	}
	public Optional<Product> deleteById(Integer id) {
		// TODO Auto-generated method stub
		 Optional<Product> product=  Repo.findById(id);
		 if (product.isPresent()) {
			   Repo.deleteById(id);
		        return product; 
		 }
		 return Optional.empty();
	 }
	public void UpdateProduct(Product p) {
		// TODO Auto-generated method stub
		 if (!Repo.existsById(p.getId())) {
	            throw new EntityNotFoundException("Product not found with ID: " + p.getId());
	        }
		 Repo.save(p);
		
	}
	
}
