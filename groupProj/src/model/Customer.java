package model;

public class Customer {
	int customerID;
	String firstName;
	String lastName;
	int phoneNum;
	String email;
	String address;
	String paymentInfo;
	String username;
	String password;
	
	public Customer() {
		this.customerID = 0;
		this.firstName = "No firstName";
		this.lastName = "No lastName";
		this.phoneNum = 0;
		this.email = "No email";
		this.address = "No address";
		this.paymentInfo = "No paymentInfo";
		this.username = "No username";
		this.password = "No password";
	}

	public Customer(int customerID, String firstName, String lastName, int phoneNum, String email, String address,String paymentInfo, String username, String password) {
		this.customerID = customerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phoneNum;
		this.email = email;
		this.address = address;
		this.paymentInfo = paymentInfo;
		this.username = username;
		this.password = password;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(String paymentInfo) {
		this.paymentInfo = paymentInfo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
