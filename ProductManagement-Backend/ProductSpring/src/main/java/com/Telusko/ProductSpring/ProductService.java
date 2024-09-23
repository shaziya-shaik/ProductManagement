package com.Telusko.ProductSpring;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ProductService {
	List<Product> products= new ArrayList<>();
	@Autowired
	ProductDB db;
	public void addProduct(Product p) throws SQLException {
		// TODO Auto-generated method stub
		//products.add(p);
		
		db.save(p);
		
	}
	public List<Product> getAllProducts() throws SQLException {
		// TODO Auto-generated method stub
		return db.findAll();
		
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
			if(p.getWarrenty()==warrenty) return p;
		}
		return null;
		
	}
	public List<Product> getProductOutOfWarrenty(int warrenty) {
		// TODO Auto-generated method stub
		List<Product> pr=new ArrayList<>();
		for(Product p:products) {
			if(p.getWarrenty()==warrenty) pr.add(p);
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
	


}
