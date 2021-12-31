package com.users;

import java.sql.*;
import java.util.*;

public class UserDao {
	
	private String dbUrl;
	private String dbUsername;
	private String dbPassword;
	private static Connection dbConnection; 
	
	public UserDao(String dbUrl, String dbUsername, String dbPassword) {
		this.dbUrl = dbUrl;
		this.dbUsername = dbUsername;
		this.dbPassword = dbPassword;
	}
	  
	protected void establishConnection() throws SQLException {
		try {
			dbConnection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			System.out.println("Connected!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		  
	protected void closeConnection() throws SQLException {
		if(dbConnection != null) {
			dbConnection.close();
		}
	}

//---------------------------------------------------------------------------------------- Create:
	
	public boolean createUser(User user) throws SQLException {
		establishConnection();
		String query = "INSERT INTO InvUserbase.UserAccounts (idNo, username, password, firstName, lastName, emailAddress, mailingAddress,"
				+ "phoneNUmber) VALUES (?,?,?,?,?,?,?,?)";
		
		PreparedStatement statement = dbConnection.prepareStatement(query);
		statement.setInt(1, user.getId());
		statement.setString(2, user.getUsername());
		statement.setString(3, user.getPassword());
		statement.setString(4, user.getFirstName());
		statement.setString(5, user.getLastName());
		statement.setString(6, user.getEmailAddress());
		statement.setString(7, user.getMailingAddress());
		statement.setInt(8, user.getPhoneNumber());
		
		int rowsAffected = statement.executeUpdate();
		statement.close();
		closeConnection();
		
		return rowsAffected > 0;
	}
	
	public int getNumUsers() throws SQLException {
		establishConnection();
		Statement statement = dbConnection.createStatement();
		ResultSet results = statement.executeQuery("SELECT * FROM InvUserbase.UserAccounts");
		
		int count = 0;
		while(results.next()) {
			count++;
		}
		statement.close();
		closeConnection();
		return count;
	}
	
//---------------------------------------------------------------------------------------- Read:
	
	public List<User> listAllUsers() throws SQLException {
		List<User> users = new ArrayList<>();

		establishConnection();
		
		String query = "SELECT * FROM InvUserbase.UserAccounts";
		Statement statement = dbConnection.createStatement();
		ResultSet results = statement.executeQuery(query);
		
		while(results.next()) {
			int id = results.getInt("idNo");
			String user = results.getString("username");
			String pw = results.getString("password");;
			String first = results.getString("firstName"); ;
			String last = results.getString("lastName");
			String email = results.getString("emailAddress");;
			int phoneNo = results.getInt("phoneNumber");;
			String mailAddress = results.getString("mailingAddress");
			
			User acct = new User(id, user, pw, first, last, email, phoneNo, mailAddress);
			users.add(acct);
		}
		
		statement.close();
		closeConnection();
		
		return users;
	}
	
	public User getUserByID(User user) throws SQLException {
		establishConnection();
		
		String query = "SELECT * FROM InvUserbase.UserAccounts WHERE ID = ?";
		PreparedStatement statement = dbConnection.prepareStatement(query);
		statement.setInt(1, user.getId());
		ResultSet results = statement.executeQuery(query);
		
		User singleUser = null;
		if(results.next()) {
			int idNo = results.getInt("idNo");
			String usernm = results.getString("username");
			String pw = results.getString("password");;
			String first = results.getString("firstName"); ;
			String last = results.getString("lastName");
			String email = results.getString("emailAddress");;
			int phoneNo = results.getInt("phoneNumber");;
			String mailAddress = results.getString("mailingAddress");
			
			singleUser = new User(idNo, usernm, pw, first, last, email, phoneNo, mailAddress);
		}
		
		statement.close();
		closeConnection();
		
		return singleUser;
	}
	
//---------------------------------------------------------------------------------------- Update:
	
	public boolean updateUser(User user) throws SQLException {
		establishConnection();
		
		String query = "UPDATE InvUserbase.UserAccounts SET(idNo = ?, username = ?, password = ?, firstName = ?, lastName = ?,"
				+ " emailAddress = ?, mailingAddress = ?, phoneNumber = ?) WHERE ID = ?";
		
		PreparedStatement statement = dbConnection.prepareStatement(query);
		statement.setInt(1, user.getId());
		statement.setString(2, user.getUsername());
		statement.setString(3, user.getPassword());
		statement.setString(4, user.getFirstName());
		statement.setString(5, user.getLastName());
		statement.setString(6, user.getEmailAddress());
		statement.setString(7, user.getMailingAddress());
		statement.setInt(8, user.getPhoneNumber());
		
		int rowsAffected = statement.executeUpdate();
		statement.close();
		closeConnection();
		
		return rowsAffected > 0;
	}
	
//---------------------------------------------------------------------------------------- Delete:
	
	public boolean deleteUser(User user) throws SQLException {
		establishConnection();
		
		String query = "DELETE FROM InvUserbase.UserAccounts WHERE ID = " + user.getId();
		Statement statement = dbConnection.createStatement();
		
		int rowsAffected = statement.executeUpdate(query);
		statement.close();
		closeConnection();
		
		return rowsAffected > 0;
	}

}
