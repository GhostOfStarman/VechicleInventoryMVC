package com.vehicleinventory.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// entity name maps to CustomerAccountDAOImp methods
@Entity(name="customerAccounts")
@Table(name="CustomerAccounts")
public class CustomerAccount {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customerId")
	private int customerId;
	
	@NotNull(message="cannot be blank")
	@Size(min=1, max=15, message="must be between 1-15 Characters")
	@Column(name="username")
	private String username;
	
	@NotNull(message="cannot be blank")
	@Size(min=1, max=15, message="must be between 1-15 Characters")
	@Column(name="password")
	private String password;
	
	@NotNull(message="cannot be blank")
	@Size(min=1, max=20, message="must be between 1-20 Characters")
	@Column(name="firstName")
	private String firstName;
	
	@NotNull(message="cannot be blank")
	@Size(min=1, max=20, message="must be between 1-20 Characters")
	@Column(name="lastName")
	private String lastName;
	
	@Email(message="must be a valid address")
	@Column(name="emailAddress")
	private String emailAddress;
	
	@NotNull(message="cannot be blank")
	@Min(value=10, message="must be 10 digits")
	@Max(value=10, message="must be 10 digits")
	@Column(name="phoneNumber")
	private int phoneNumber;
	
	@NotNull(message="cannot be blank")
	@Size(min=1, max=50, message="must be between 1-50 Characters")
	@Column(name="mailingAddress")
	private String mailingAddress;
	
	// ----------------------------------------------------------------------------------- >
	@OneToMany(mappedBy="financeId", cascade= {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST})
	private List<FinanceRecord> financedVehicles;

	// ----------------------------------------------------------------------------------- >
	// Constructors
	
	public CustomerAccount(){}

	public CustomerAccount(int id){
		this.customerId = id;
	}
	
	public CustomerAccount(int id, String CustomerAccount, String password) {
		this.customerId = id;
		this.username = CustomerAccount;
		this.password = password;
	}
	
	public CustomerAccount(int id, String CustomerAccountname, String password, String firstName, String lastName, String email, int phoneNo, String address) {
		this(firstName, lastName, email, phoneNo, address);
		this.customerId = id;
		this.username = CustomerAccountname;
		this.password = password;
	}

	public CustomerAccount(String firstName, String lastName, String email, int phoneNo, String address){
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = email;
		this.phoneNumber = phoneNo;
		this.mailingAddress = address;
	}

	// ----------------------------------------------------------------------------------- >
	// Getters/Setters

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public List<FinanceRecord> getFinancedVehicles() {
		return financedVehicles;
	}

	public void setFinancedVehicles(List<FinanceRecord> financedVehicles) {
		this.financedVehicles = financedVehicles;
	}

	public void setcustomerId(int customerId) {
		this.customerId = customerId;
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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMailingAddress() {
		return mailingAddress;
	}

	public void setMailingAddress(String mailingAddress) {
		this.mailingAddress = mailingAddress;
	}


}
