package dbHelpers;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.sql.Connection;




import model.Product;
import model.CartItems;
import model.Customer;




public class AddQuery {
	
	public Connection connection;
	
	@SuppressWarnings("deprecation")
	public AddQuery(String dbName, String uname, String pwd)
		{
			String url="jdbc:mysql://localhost:3306/" + dbName;
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				this.connection = (Connection) DriverManager.getConnection(url, uname, pwd);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	public void doAddCustomer(Customer customer)
	{
		String query = "insert into Customer (customerID, firstName, lastName, phoneNum, email, address, paymentInfo, username, password) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, customer.getCustomerID());
			ps.setString(2, customer.getFirstName());
			ps.setString(3, customer.getLastName());
			ps.setInt(4, customer.getPhoneNum());
			ps.setString(5, customer.getEmail());
			ps.setString(6, customer.getAddress());
			ps.setString(7, customer.getPaymentInfo());
			ps.setString(8, customer.getUsername());
			ps.setString(9, customer.getPassword());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
		
		
		public void addToCart(Product item)
		{
			CartItems cart = new CartItems();
			
			String query = "insert into cartItems (cartItemsID, productName, productPrice, productQuantity, Product_productID) values(?, ?, ?, ?, ?)";
			cart.randomCartItemsID();
//			cart.setProductQuantity();
			try {
				PreparedStatement ps = connection.prepareStatement(query);
				
				ps.setInt(1, cart.getCartItemsID());
				ps.setString(2, item.getProductName());
				ps.setDouble(3, item.getProductPrice());
//				ps.setInt(4, item.getInventory());
				ps.setInt(4, cart.incrementQuantity());
				ps.setInt(5, item.getProductID());
				
				ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		
	


}
