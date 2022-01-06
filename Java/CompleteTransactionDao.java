package com.transactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.users.User;
import com.users.UserDao;
import com.vehicles.Vehicle;
import com.vehicles.VehicleDao;


public class CompleteTransactionDao {
	private String dbUrl;
	private String dbUsername;
	private String dbPassword;
	private static Connection dbConnection; 
	
	public CompleteTransactionDao(String dbUrl, String dbUsername, String dbPassword) {
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
	
	public boolean createCompleteTransactionDao(CompleteTransaction transaction) throws SQLException {
		establishConnection();
		String query = "INSERT INTO VehicleInventory.CompletedTransactions (transID, buyerID, vin, make, model, modelYear, extColor,"
				+ "intColor, mileage, soldCondition, askingPrice, sellingPrice) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement statement = dbConnection.prepareStatement(query);
		statement.setInt(1, transaction.getTransId());
		statement.setInt(2, transaction.getBuyerId());
		statement.setString(3, transaction.getVin());
		statement.setString(4, transaction.getMake());
		statement.setString(5, transaction.getModel());
		statement.setInt(6, transaction.getModelYear());
		statement.setString(7, transaction.getExtColor());
		statement.setString(8, transaction.getIntColor());
		statement.setInt(9, transaction.getMileage());
		statement.setString(10, transaction.getSoldCondition());
		statement.setDouble(11, transaction.getAskingPrice());
		statement.setDouble(12, transaction.getSellingPrice());
		
		int rowsAffected = statement.executeUpdate();
		statement.close();
		closeConnection();
		
		return rowsAffected > 0;
	}
	
	
	
	public int getNumTransactions() throws SQLException {
		establishConnection();
		Statement statement = dbConnection.createStatement();
		ResultSet results = statement.executeQuery("SELECT * FROM VehicleInventory.CompletedTransactions");
		
		int count = 0;
		while(results.next()) {
			count++;
		}
		statement.close();
		closeConnection();
		return count;
	}
	
//---------------------------------------------------------------------------------------- Read:
	
	public List<CompleteTransaction> listAllTransactions() throws SQLException {
		List<CompleteTransaction> history = new ArrayList<>();

		establishConnection();
		
		String query = "SELECT * FROM VehicleInventory.CompletedTransactions";
		Statement statement = dbConnection.createStatement();
		ResultSet results = statement.executeQuery(query);
		
		while(results.next()) {
			int transId = results.getInt("transID");
			int buyerId = results.getInt("buyerID");
			String vin = results.getString("vin");;
			String make = results.getString("make"); ;
			String model = results.getString("model");
			int year = results.getInt("modelYear");;
			String extColor = results.getString("extColor");;
			String intColor = results.getString("intColor");
			int mileage = results.getInt("mileage");
			String condition = results.getString("soldCondition");
			double askingPrice = results.getDouble("askingPrice");
			double sellingPrice = results.getDouble("sellingPrice");
			
			CompleteTransaction transaction = new CompleteTransaction(transId, buyerId, vin, make, model, year, extColor, intColor, mileage, condition, askingPrice, sellingPrice);
			history.add(transaction);
		}
		
		statement.close();
		closeConnection();
		
		return history;
	}
	
	public CompleteTransaction getTransactionById(CompleteTransaction transaction) throws SQLException {
		establishConnection();
		
		String query = "SELECT * FROM VehicleInventory.CompletedTransactions WHERE idNo = '" + transaction.getTransId() + "'";
		PreparedStatement statement = dbConnection.prepareStatement(query);
		ResultSet results = statement.executeQuery(query);
		
		CompleteTransaction singleTransaction = null;
		if(results.next()) {
			int transId = results.getInt("transID");
			int buyerId = results.getInt("buyerID");
			String vin = results.getString("vin");;
			String make = results.getString("make"); ;
			String model = results.getString("model");
			int year = results.getInt("modelYear");;
			String extColor = results.getString("extColor");;
			String intColor = results.getString("intColor");
			int mileage = results.getInt("mileage");
			String condition = results.getString("soldCondition");
			double askingPrice = results.getDouble("askingPrice");
			double sellingPrice = results.getDouble("sellingPrice");
			
			singleTransaction = new CompleteTransaction(transId, buyerId, vin, make, model, year, extColor, intColor, mileage, condition, askingPrice, sellingPrice);
		}
		
		statement.close();
		closeConnection();
		
		return singleTransaction;
	}
	
	public CompleteTransaction getTransactionById(int transId) throws SQLException {
		establishConnection();
		
		String query = "SELECT * FROM VehicleInventory.CompletedTransactions WHERE transID = " + transId;
		Statement statement = dbConnection.createStatement();
		ResultSet results = statement.executeQuery(query);
		
		CompleteTransaction singleTransaction = null;
		if(results.next()) {
			int transIdNo = results.getInt("transID");
			int buyerId = results.getInt("buyerID");
			String vin = results.getString("vin");;
			String make = results.getString("make"); ;
			String model = results.getString("model");
			int year = results.getInt("modelYear");;
			String extColor = results.getString("extColor");;
			String intColor = results.getString("intColor");
			int mileage = results.getInt("mileage");
			String condition = results.getString("soldCondition");
			double askingPrice = results.getDouble("askingPrice");
			double sellingPrice = results.getDouble("sellingPrice");
			
			singleTransaction = new CompleteTransaction(transIdNo, buyerId, vin, make, model, year, extColor, intColor, mileage, condition, askingPrice, sellingPrice);
		}
		
		statement.close();
		closeConnection();
		
		return singleTransaction;
	}
	
	public List<Integer> listAllTransactionIds() throws SQLException {
		establishConnection();
		List<Integer> transIds = new ArrayList<>();
		
		String query = "SELECT transID FROM VehicleInventory.CompletedTransactions";
		Statement statement = dbConnection.createStatement();
		ResultSet results = statement.executeQuery(query);

		while(results.next()) {
			transIds.add(results.getInt("transID"));
		}
		
		statement.close();
		closeConnection();
		
		return transIds;
	}
	
//---------------------------------------------------------------------------------------- Update:
	
	public boolean updateCompletedTransaction(CompleteTransaction transaction) throws SQLException {
		establishConnection();
		String query = "UPDATE VehicleInventory.CompletedTransactions SET transID = ?, buyerID = ?, vin = ?, make = ?, model = ?, "
				+ "modelYear = ?, extColor = ?, intColor = ?, mileage = ?, soldCondition = ?, askingPrice = ?, sellingPrice = ? WHERE idNo = " + transaction.getTransId();
		
		PreparedStatement statement = dbConnection.prepareStatement(query);
		statement.setInt(1, transaction.getTransId());
		statement.setInt(2, transaction.getBuyerId());
		statement.setString(3, transaction.getVin());
		statement.setString(4, transaction.getMake());
		statement.setString(5, transaction.getModel());
		statement.setInt(6, transaction.getModelYear());
		statement.setString(7, transaction.getExtColor());
		statement.setString(8, transaction.getIntColor());
		statement.setInt(9, transaction.getMileage());
		statement.setString(10, transaction.getSoldCondition());
		statement.setDouble(11, transaction.getAskingPrice());
		statement.setDouble(12, transaction.getSellingPrice());
		
		int rowsAffected = statement.executeUpdate();
		statement.close();
		closeConnection();
		
		return rowsAffected > 0;
	}
	
//---------------------------------------------------------------------------------------- Delete:
	
	public boolean deleteTransaction(int id) throws SQLException {
		establishConnection();
		
		String query = "DELETE FROM VehicleInventory.CompletedTransactions WHERE idNo = '" + id + "'";
		Statement statement = dbConnection.createStatement();
		
		int rowsAffected = statement.executeUpdate(query);
		statement.close();
		closeConnection();
		
		return rowsAffected > 0;
	}
	
	public boolean deleteTransaction(CompleteTransaction transaction) throws SQLException {
		establishConnection();
		
		String query = "DELETE FROM VehicleInventory.CompletedTransactions WHERE idNo = '" + transaction.getTransId() + "'";
		Statement statement = dbConnection.createStatement();
		
		int rowsAffected = statement.executeUpdate(query);
		statement.close();
		closeConnection();
		
		return rowsAffected > 0;
	}
	
	public boolean clearTable() throws SQLException {
		establishConnection();
		
		Statement statement = dbConnection.createStatement();
		List<Integer> allTransIds = this.listAllTransactionIds();
		for(int id : allTransIds) {
			String query = "DELETE FROM VehicleInventory.CompletedTransactions WHERE idNo = '" + id + "'";
			statement.execute(query); 
		}
		
		ResultSet results = statement.executeQuery("SELECT * FROM VehicleInventory.CompletedTransactions");
		
		int numRows = 0;
		while(results.next()) {
			numRows++;
		}
		
		statement.close();
		closeConnection();
		
		return numRows < 1;
	}
}
