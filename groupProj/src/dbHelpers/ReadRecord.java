package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Product;


public class ReadRecord {
	
	private Connection connection;
	private ResultSet results;
	
	Product product = new Product();
	private int productID;
	
	public ReadRecord(String dbName, String uname, String pwd, int productID){
		
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		this.productID = productID;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
//	public void doRead(){
//		String query = "select * from products where productID = ?";
//		
//		try {
//			PreparedStatement ps = connection.prepareStatement(query);
//			
//			ps.setString(1, this.primaryKey);
//			
//			this.results = ps.executeQuery();
//			
//			this.results.next();
//			
//			
//			product.setProductID(this.results.getInt("productID"));
//			product.setProductName(this.results.getString("productName"));
//			product.setProductPrice(this.results.getDouble("productPrice"));
//			product.setInventory(this.results.getInt("inventory"));
//			
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	
	public void getItemsFromProduct(){
		String query = "select * from Product where productID = ?";
		
		
		
		
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, this.productID);
			
			
			this.results = ps.executeQuery();
			
			this.results.next();
			
			product.setProductID(this.results.getInt("productID"));
			product.setProductName(this.results.getString("productName"));
			product.setProductPrice(this.results.getDouble("productPrice"));
			product.setInventory(this.results.getInt("inventory"));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteProduct()
	{
String query = "DELETE FROM Product where productID = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, this.productID);
			
			this.results = ps.executeQuery();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public Product getProduct(){
		return this.product;
	}

}

