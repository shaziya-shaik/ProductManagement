package Main;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ProductDB {
	Connection con=null;
	String url="jdbc:mysql://localhost:3306/telusko";
	String pass="";
	String uname="root";
	
	public void save(Product p) throws SQLException {
		con=DriverManager.getConnection(url , uname , pass);
		String Querry="insert into product (name , type , place , warrenty) values (?,?,?,?)";
	
		PreparedStatement st=con.prepareStatement(Querry);
		st.setString(1, p.getName1());
		st.setString(2,p.getPlace());
		st.setString(3, p.getType1());
		st.setInt(4, p.getWarrenty1());
		int result=st.executeUpdate();
		System.out.println(result);
		
	}

	public List<Product> getAll() throws SQLException {
		con=DriverManager.getConnection(url , uname , pass);
		// TODO Auto-generated method stub
		List<Product> products=new ArrayList<>();
		String Querry="select name , type , place , warrenty from product";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(Querry);
		while(rs.next()) {
			Product p=new Product();
			
			p.setName1(rs.getString(1));
			p.setPlace(rs.getString(2));
			p.setType1(rs.getString(3));
			p.setWarrenty1(rs.getInt(4));
			products.add(p);
		}
		return products;
	}


}
