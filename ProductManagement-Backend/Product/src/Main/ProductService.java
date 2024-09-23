package Main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
	List<Product> products= new ArrayList<>();
	ProductDB db=new ProductDB();
	public void addProduct(Product p) throws SQLException {
		// TODO Auto-generated method stub
		//products.add(p);
		
		db.save(p);
		
	}
	public List<Product> getAllProducts() throws SQLException {
		// TODO Auto-generated method stub
		return db.getAll();
		
	}
	public Product getProduct(String name) {
		// TODO Auto-generated method stub
		for(Product p:products) {
			if(p.getName1().equals(name)) return p;
		}
		for(Product p:products) {
			if(p.getPlace().equals(name)) return p;
		}
		for(Product p:products) {
			if(p.getType1().equals(name)) return p;
		}
		
		return null;
		
	}
	public Product getProduct(int warrenty) {
		// TODO Auto-generated method stub
		for(Product p:products) {
			if(p.getWarrenty1()==warrenty) return p;
		}
		return null;
		
	}
	public List<Product> getProductOutOfWarrenty(int warrenty) {
		// TODO Auto-generated method stub
		List<Product> pr=new ArrayList<>();
		for(Product p:products) {
			if(p.getWarrenty1()==warrenty) pr.add(p);
		}
		return pr;
	}
	public List<Product> getProductWithText(String string) {
		String str=string.toLowerCase();
		// TODO Auto-generated method stub
		List<Product> products=new ArrayList<>();
		
		for(Product p:products) {
			if(p.getName1().toLowerCase().contains(string) || p.getType1().toLowerCase().contains(string) || p.getPlace().toLowerCase().contains(string))
				products.add(p);
		}
			
		return products;
	}
	

}
