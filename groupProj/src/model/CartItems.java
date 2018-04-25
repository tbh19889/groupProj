package model;

import java.util.Random;

public class CartItems {
	int cartItemsID;
	String productName;
	double productPrice;
	int productQuantity;
	int Product_productID;
	
	
	public CartItems() {
		this.cartItemsID = 0;
		this.productPrice = 0.00;
		this.productQuantity = 0;	
		this.Product_productID = 0;
	}
	
	public CartItems(int cartItemsID, double productPrice,int productQuantity, int Product_productID) {
		this.cartItemsID = cartItemsID;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.Product_productID= Product_productID;
		
	}

	public int getCartItemsID() {
		return cartItemsID;
	}

	public void setCartItemsID(int cartItemsID) {
		this.cartItemsID = cartItemsID;
	}
	
	public void randomCartItemsID() {
		Random r = new Random();
		cartItemsID = r.nextInt(5000); 
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductQuantity() {
		return productQuantity;
	}
	
	public int incrementQuantity()
	{
		productQuantity++;
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public int getProduct_productID() {
		return Product_productID;
	}

	public void setProduct_productID(int product_productID) {
		Product_productID = product_productID;
	}

}
