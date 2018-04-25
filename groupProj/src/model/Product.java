package model;
import java.util.*;

public class Product {
	int productID;
	String productName;
	double productPrice;
	int inventory;
	
	
	public Product() {
		this.productID = 0;
		this.productName = "No productName";
		
	}

	public Product(int productID, String productName) {
		this.productID = productID;
		this.productName = productName;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}


	public int deIncrement()
	{
		inventory--;
		return inventory;
	}
	
	
}
