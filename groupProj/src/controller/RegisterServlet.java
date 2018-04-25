package controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.AddQuery;
import model.Customer;
import utilities.PasswordService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get the data
		Random r = new Random();
		int customerID = r.nextInt(5000); 
		String firstName  = request.getParameter("firstName");
		String lastName  = request.getParameter("lastName");
		int phoneNum = Integer.parseInt(request.getParameter("phoneNum"));
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String paymentInfo = request.getParameter("paymentInfo");
		String username = request.getParameter("username");
		String password  = request.getParameter("password");
		
		PasswordService pws = new PasswordService();
		String encryptedPass = pws.encrypt(password);		
		
		//setup a customer object
		Customer customer = new Customer();
		customer.setCustomerID(customerID);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setPhoneNum(phoneNum);
		customer.setEmail(email);
		customer.setAddress(address);
		customer.setPaymentInfo(paymentInfo);
		customer.setUsername(username);
		customer.setPassword(encryptedPass);
		
		//setup an addQuery Object
		AddQuery aq = new AddQuery("groupProj", "root", "811997914");
		
		//pass the product to addQuery to add to the database
		aq.doAddCustomer(customer);
		
		//pass execution control to the ReadServlet
		String url = "/read";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
		
	}

}
