package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.AddQuery;
import dbHelpers.ReadQuery;
import dbHelpers.ReadRecord;
import model.Product;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/AddToCart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlet() {
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
		// TODO Auto-generated method stub
		// gets the productID from product.jsp 
				int productID = Integer.parseInt(request.getParameter("productID"));
				
				// create ReadRecord class
				ReadRecord rr = new ReadRecord("groupProj", "root", "811997914", productID);
				
				// Use ReadRecord to get the product data
				rr.getItemsFromProduct();
//				rr.deleteProduct();
				
				Product product = rr.getProduct();
				
				//setup an addQuery Object
				AddQuery aq = new AddQuery("groupProj", "root", "811997914");
				
				//pass the product to addQuery to add to the database
				aq.addToCart(product);
				
				// pass product and control to the readCart servlet
				request.setAttribute("product", product);
				
				String url = "/readCart";
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
				
		
		
		
		
	}

}
