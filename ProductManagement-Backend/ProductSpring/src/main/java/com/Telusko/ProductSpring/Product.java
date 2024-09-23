package com.Telusko.ProductSpring;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private String Name;
	private String type;
	private String place;
	private int warrenty;
	
	@Override
	public String toString() {
		return "Product [Name1=" + Name + ", type1=" + type + ", place=" + place + ", warrenty1=" + warrenty + "]";
	}
	public Product() {
		super();
	}
	public Product(String name, String type, String place, int warrenty) {
		super();
		Name = name;
		this.type = type;
		this.place = place;
		this.warrenty = warrenty;
	}
	
	  
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName1(String name) {
		Name = name;
	}
	public String getType() {
		return type;
	}
	public void setType1(String type) {
		this.type = type;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getWarrenty() {
		return warrenty;
	}
	public void setWarrenty1(int warrenty) {
		this.warrenty = warrenty;
	}
	


}
