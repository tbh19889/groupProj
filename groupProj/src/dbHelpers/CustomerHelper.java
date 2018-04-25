package dbHelpers;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

import model.Customer;


public class CustomerHelper {
	
	private PreparedStatement authenticateUserStatement;
	private Connection connection;
	
	public CustomerHelper()
{
	//String url = "jdbc:mysql://localhost:3306/" + dbName;
	
	// set up the driver
	try {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/groupProj", "root", "811997914");
		//create preparedstatement
		authenticateUserStatement = connection.prepareStatement("select * from Customer where username=? and password=?");
		
	}catch(Exception e)
	{
		System.out.println(e.getClass().getName() + ": " + e.getMessage());
	}
}
	


	public Customer authenticateCustomer(String username, String password)
	{
		Customer customer = null;
		try {
			//add parameters to the ?'s in the preparedstatement and execute
			authenticateUserStatement.setString(1, username);
			authenticateUserStatement.setString(2, password);
			
			ResultSet rs = authenticateUserStatement.executeQuery();
			
			//if we've returned a row, turn that row into a new user object
			if(rs.next())
			{
				customer = new Customer(rs.getInt("customerID"), rs.getString("firstName"), rs.getString("lastName"), rs.getInt("phoneNum"), rs.getString("email"), rs.getString("address"), rs.getString("paymentInfo"), rs.getString("username"), rs.getString("password"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return customer;
	}

	
	
	 

}
