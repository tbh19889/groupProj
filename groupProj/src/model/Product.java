package model;

public class Product {
	int productID;
	String productName;
	
	public Product() {
		this.productID = 0;
		this.productName = "No productName";
	}

	public Product(int productID, String productName) {
		this.productID = productID;
		this.productName = productName;
	}
}
