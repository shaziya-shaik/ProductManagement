package Main;

import java.sql.SQLException;
import java.util.List;

public class Main {

	public static void main(String[] args) throws SQLException {
		ProductService service=new ProductService();
//		service.addProduct(new Product("Asus VivoBook" , "Laptop", "BrownTable" , 2022));
//		// Adding products using the service.addProduct() method
//		service.addProduct(new Product("Apple iPhone 14", "Smartphone", "Latest model with 5G", 2023));
//		service.addProduct(new Product("Sony WH-1000XM4", "Headphones", "Noise-cancelling over-ear headphones", 2021));
//		service.addProduct(new Product("Samsung QLED TV", "Television", "4K Ultra HD Smart TV", 2022));
//		service.addProduct(new Product("Dell XPS 15", "Laptop", "High-performance laptop with 16GB RAM", 2022));
//		service.addProduct(new Product("Canon EOS R5", "Camera", "Mirrorless camera with 45MP sensor", 2022));
//		service.addProduct(new Product("Apple iPad Pro", "Tablet", "Powerful tablet with M1 chip", 2023));
//		service.addProduct(new Product("Microsoft Surface Pro 8", "Tablet", "Versatile 2-in-1 with detachable keyboard", 2021));
//		service.addProduct(new Product("Bose SoundLink Mini", "Speaker", "Compact Bluetooth speaker with deep bass", 2020));
//		service.addProduct(new Product("Fitbit Charge 5", "Fitness Tracker", "Advanced fitness and health tracking", 2022));
//		service.addProduct(new Product("GoPro Hero 10", "Action Camera", "Waterproof camera with 5.3K video", 2022));

		
		List<Product> products=service.getAllProducts();
		for(Product p:products)
		System.out.println(p);
//		System.out.println("====================================");
		
		//System.out.println(service.getProduct("Asus VivoBook"));
	//	System.out.println(service.getProduct("Smartphone"));
		//System.out.println(service.getProductOutOfWarrenty(2021));
		List<Product> prods=service.getProductWithText("Hero");
		for(Product p:prods)		
			System.out.println(p);
		
		
		

	}

}
