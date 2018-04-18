package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbHelpers.CustomerHelper;
import model.Customer;
import utilities.PasswordService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	private String url;
	private int loginAttempts;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		//get our current session
		session = request.getSession();
		
		//get the number of logins
		if(session.getAttribute("loginAttempts") == null)
		{
			loginAttempts = 0;
		}
		
		//exceeded logins
		if(loginAttempts>3) 
		{
			String errorMessage = "You have exceeded the number of login attempts.";
			request.setAttribute("errorMessage", errorMessage);
		}
		else { //proceed
			
			//pull the fields from the form
			String email  = request.getParameter("email");
			String password  = request.getParameter("password");
			
			//encrypt the password to check against what's stored in DB
			PasswordService pws = new PasswordService();
			String encryptedPass = pws.encrypt(password);
			
			//create a userHelper class to make database calls, and call authenticate user method
			CustomerHelper uh = new CustomerHelper("groupProj", "root", "811997914");
			Customer user = uh.authenticateCustomer(email, encryptedPass);
			
			//we've found a user that matches the credentials!
			if(user != null)
			{
				//invalidate current session, then get new session for our user (combats session hijacking)
				//used for when a user browses the website without logging in and then decides to login. it deletes their previous session and creates a new one.
				session.invalidate();
				session=request.getSession(true);
				session.setAttribute("user", user);
				url="product.jsp";
			}
			//user doesn't exist, redirect to previous page and show error
			else {
				String errorMessage = "Username or Password not recognized.";
				request.setAttribute("errorMessage", errorMessage);
				
				//track login attempts (combats: brute force attacks)
				session.setAttribute("loginAttempts", loginAttempts++);
				url = "login.jsp";
			}
			
		}
		
		//forward our request along
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	    
		
		
		
	}
	
	public void logout()
	{
		session.invalidate();
	}

}
