package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Product;
import model.CartItems;

public class ReadQuery {

	private Connection connection;
	private ResultSet results;
	
	
	public ReadQuery(String dbName, String uname, String pwd){
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		
		// set up the driver
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void doRead(){
		String query = "select * from Product";
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			this.results= ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getHTMLTable(){
		String table ="";
		table += "<table border=1 align=\"center\">";
		
		table +="<tr>";
		table +="<th>";
		table += "Product Name";
		table += "</th>";
		table +="<th>";
		table += "Product Price";
		table += "</th>";
		table +="<th>";
		table += "Product Inventory";
		table += "</th>";
		table +="<th>";
		table += "Option";
		table += "</th>";
		table +="</tr>";
		
		
		
		try {
			while(this.results.next()){
				Product product = new Product();
				product.setProductID(this.results.getInt("productID"));
				product.setProductName(this.results.getString("productName"));
				product.setProductPrice(this.results.getDouble("productPrice"));
				product.setInventory(this.results.getInt("inventory"));
				
				
				
				table +="<tr>";
				table +="<td>";
				table += product.getProductName();
				table +="</td>";
				table +="<td>";
				table += product.getProductPrice();
				table +="</td>";
				table +="<td>";
				table += product.getInventory();
				table +="</td>";
				
//				table +="<td>";
//				table += "<img src= \"milk.png\">";
//				table +="</td>";
//				table +="</tr>";
				table +="<td>";
				
				table += "<a href=AddToCart?productID=" + product.getProductID() + " >Add to Cart</a>";
				table +="</td>";
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		table += "</table>";
		return table;
	}
	
	
	
	public void doReadCart(){
		String query = "select * from cartItems";
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			this.results= ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public String getCartTable(){
		String table ="";
		table += "<table border=1 align=\"center\">";
		
		table +="<tr>";
		table +="<th>";
		table += "Product Name";
		table += "</th>";
		table +="<th>";
		table += "Product Price";
		table += "</th>";
		table +="<th>";
		table += "Product Quantity";
		table += "</th>";
		table +="<th>";
		table += "Option";
		table += "</th>";
		table +="</tr>";
		
		
		
		try {
			while(this.results.next()){
				CartItems item = new CartItems();
				item.setCartItemsID(this.results.getInt("cartItemsID"));
				item.setProductName(this.results.getString("productName"));
				item.setProductPrice(this.results.getDouble("productPrice"));
				item.setProductQuantity(this.results.getInt("productQuantity"));
				
				
				
				table +="<tr>";
				table +="<td>";
				table += item.getProductName();
				table +="</td>";
				table +="<td>";
				table += item.getProductPrice();
				table +="</td>";
				table +="<td>";
				table += item.getProductQuantity();
				table +="</td>";
				
//				table +="<td>";
//				table += "<img src= \"milk.png\">";
//				table +="</td>";
//				table +="</tr>";
				table +="<td>";
				
				table += "<a href=delete?cartItemsID=" + item.getCartItemsID() + " >Delete From Cart</a>";
				table +="</td>";
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		table += "</table>";
		return table;
	}
}
