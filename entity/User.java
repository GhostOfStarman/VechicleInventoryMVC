package com.vehicleinventory.entity;

public class User {
	protected int idNo;
	protected String username;
	protected String password;
	protected String firstName;
	protected String lastName;
	protected String emailAddress;
	protected int phoneNumber;
	protected String mailingAddress;

	public User(){}

	public User(int id){
		this.idNo = id;
	}
	
	public User(int id, String user, String password) {
		this.idNo = id;
		this.username = user;
		this.password = password;
	}
	
	public User(int id, String username, String password, String firstName, String lastName, String email, int phoneNo, String address) {
		this(firstName, lastName, email, phoneNo, address);
		this.idNo = id;
		this.username = username;
		this.password = password;
	}

	public User(String firstName, String lastName, String email, int phoneNo, String address){
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = email;
		this.phoneNumber = phoneNo;
		this.mailingAddress = address;
	}
	
	//-------------------------------------------------

	public int getId(){
		return idNo;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}

	public int getPhoneNumber(){
		return phoneNumber;
	}

	public String getFirstName(){
		return firstName;
	}

	public String getLastName(){
		return lastName;
	}

	public String getEmailAddress(){
		return emailAddress;
	}

	public String getMailingAddress(){
		return mailingAddress;
	}


	//-------------------------------------------------

	public void setId(int number){
		idNo = number;
	}
	
	public void setUsername(String user){
		username = user;
	}
	
	public void setPassword(String password){
		this.password = password;
	}

	public void setPhoneNumber(int digits){
		phoneNumber = digits;
	}

	public void setFirstName(String first){
		firstName = first;
	}

	public void setLastName(String last){
		lastName = last;
	}

	public void setMailingAddress(String address){
		mailingAddress = address;
	}

	public void setEmailAddress(String email){
		emailAddress = email;
	}

}
