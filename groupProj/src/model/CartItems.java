package model;

public class CartItems {
	int cartItemsID;
	double productPrice;
	int productQuantity;
	
	public CartItems() {
		this.cartItemsID = 0;
		this.productPrice = 0.00;
		this.productQuantity = 0;	
	}
	
	public CartItems(int cartItemsID, double productPrice,int productQuantity) {
		this.cartItemsID = cartItemsID;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
	}

	public int getCartItemsID() {
		return cartItemsID;
	}

	public void setCartItemsID(int cartItemsID) {
		this.cartItemsID = cartItemsID;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
}
