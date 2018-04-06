package model;

public class ShoppingCart {
	int shoppingCartID;
	String dateCreated;
	String dateLastAccessed;
	
	public ShoppingCart() {
		this.shoppingCartID = 0;
		this.dateCreated = "No dateCreated";
		this.dateLastAccessed = "No dateLastAccessed";
	}

	public ShoppingCart(int shoppingCartID, String dateCreated, String dateLastAccessed) {
		this.shoppingCartID = shoppingCartID;
		this.dateCreated = dateCreated;
		this.dateLastAccessed = dateLastAccessed;
	}

	public int getShoppingCartID() {
		return shoppingCartID;
	}

	public void setShoppingCartID(int shoppingCartID) {
		this.shoppingCartID = shoppingCartID;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getDateLastAccessed() {
		return dateLastAccessed;
	}

	public void setDateLastAccessed(String dateLastAccessed) {
		this.dateLastAccessed = dateLastAccessed;
	}
}
