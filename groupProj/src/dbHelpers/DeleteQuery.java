package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteQuery {
	
private Connection connection;
	
	public DeleteQuery(String dbName, String uname, String pwd){
		
		String url = "jdbc:mysql://localhost:3306/"+dbName;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doDeleteProduct(String productID){
		// set up a String to hold our query
		String query = "delete from Product where productID = ?";
		
		// create a preparedstatement using our query string
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			// fill in the preparedstatement
			ps.setString(1, productID);
			
			// execute the query
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		public void deleteFromCart(int cartItemsID){
			// set up a String to hold our query
			String query = "delete from cartItems where cartItemsID = ?";
			
			// create a preparedstatement using our query string
			try {
				PreparedStatement ps = connection.prepareStatement(query);
				
				// fill in the preparedstatement
				ps.setInt(1, cartItemsID);
				
				// execute the query
				ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}

}
