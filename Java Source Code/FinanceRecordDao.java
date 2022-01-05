package com.financing;

import java.sql.*;
import java.util.*;

public class FinanceRecordDao{
	private String dbUrl;
	private String dbUsername;
	private String dbPassword;
	private static Connection dbConnection; 
	
	public FinanceRecordDao(String dbUrl, String dbUsername, String dbPassword) {
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

	//—————————————————————————————————————————	Create methods: 
	  
	public boolean insertFinancePlan(FinanceRecord record) throws SQLException {
		establishConnection();
		
		String query = "INSERT INTO VehicleInventory.FinanceRecords (FinanceID, CustomerID, VehicleID, VehicleCost, CreditScore, InterestRate, TermLength, " +
		"DownPayment, Principal, TotalOwed, PaymentsMade) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement statement = dbConnection.prepareStatement(query);
		statement.setInt(1, record.getFinanceId());
		statement.setInt(2, record.getCustomerId());
		statement.setString(3, record.getAssociatedVin());
		statement.setDouble(4, record.getVehicleCost());
		statement.setInt(5, record.getCreditScore());
		statement.setDouble(6, record.getInterestRate());
		statement.setInt(7, record.getTerm());
		statement.setDouble(8, record.getDownPayment());
		statement.setDouble(9, record.getPrincipal());
		statement.setDouble(10, record.getTotalDebt());
		statement.setInt(11, record.getInstallmentsPaid());
		
		int rowsAffected = statement.executeUpdate();
		statement.close();
		closeConnection();
		
		return rowsAffected > 0;
	}

	public int getNumPlans() throws SQLException {
		establishConnection();
		Statement statement = dbConnection.createStatement();
		ResultSet results = statement.executeQuery("SELECT * FROM VehicleInventory.FinanceRecords");
		
		int count = 0;
		while(results.next()) {
			count++;
		}
		statement.close();
		closeConnection();
		return count;
	}

	//---------------------------------------------------------------------------------------- Read:
	
	public List<FinanceRecord> listAllRecords() throws SQLException {
		List<FinanceRecord> records = new ArrayList<>();

		establishConnection();
		
		String query = "SELECT * FROM VehicleInventory.FinanceRecords";
		Statement statement = dbConnection.createStatement();
		ResultSet results = statement.executeQuery(query);
		
		while(results.next()) {
			String vId = results.getString("VehicleID");

			int finId = results.getInt("FinanceID");
			int custId = results.getInt("CustomerID");
			int term = results.getInt("TermLength");
			int credit = results.getInt("CreditScore"); 
			int paymentsMade = results.getInt("PaymentsMade");

			double downPayment = results.getDouble("DownPayment");
			double price = results.getDouble("VehicleCost");
			double rate = results.getDouble("InterestRate");
			double principal = results.getDouble("Principal");
			double debt = results.getDouble("TotalOwed");

			
			FinanceRecord record = new FinanceRecord(finId, custId, credit, vId, term, rate, price, downPayment, principal, debt, paymentsMade);
			records.add(record);
		}
		
		statement.close();
		closeConnection();
		
		return records;
	}

	public FinanceRecord getPlanById(FinanceRecord record) throws SQLException {
		establishConnection();
		
		String query = "SELECT * FROM VehicleInventory.FinanceRecords WHERE FinanceID = '" + record.getFinanceId() + "'";
		PreparedStatement statement = dbConnection.prepareStatement(query);
		ResultSet results = statement.executeQuery(query);
		
		FinanceRecord plan = null;
		while(results.next()) {
			String vId = results.getString("VehicleID");

			int finId = results.getInt("FinanceID");
			int custId = results.getInt("CustomerID");
			int term = results.getInt("TermLength");
			int credit = results.getInt("CreditScore"); 
			int paymentsMade = results.getInt("PaymentsMade");

			double downPayment = results.getDouble("DownPayment");
			double price = results.getDouble("VehicleCost");
			double rate = results.getDouble("InterestRate");
			double principal = results.getDouble("Principal");
			double debt = results.getDouble("TotalOwed");

			
			plan = new FinanceRecord(finId, custId, credit, vId, term, rate, price, downPayment, principal, debt, paymentsMade);
		}
		
		statement.close();
		closeConnection();
		
		return plan;
	}
	
	public List<String> listAllRecordIds() throws SQLException {
		establishConnection();
		List<String> finIds = new ArrayList<>();
		
		String query = "SELECT vin FROM VehicleInventory.FinanceRecords";
		Statement statement = dbConnection.createStatement();
		ResultSet results = statement.executeQuery(query);

		while(results.next()) {
			finIds.add(results.getString("FinanceID"));
		}
		
		statement.close();
		closeConnection();
		
		return finIds;
	}

	//---------------------------------------------------------------------------------------- Update:

	public boolean updatePlan(FinanceRecord record) throws SQLException {
		establishConnection();
		
		String query = "UPDATE InvUserbase.UserAccounts SET FinanceID = ?, CustomerID = ?, VehicleID = ?, VehicleCost = ?, CreditScore = ?, "
				+ "InterestRate = ?, TermLength = ?, DownPayment = ?, Principal = ?, TotalOwed = ?, PaymentsMade= ? WHERE idNo = " + record.getFinanceId();
		
		PreparedStatement statement = dbConnection.prepareStatement(query);
		statement.setInt(1, record.getFinanceId());
		statement.setInt(2, record.getCustomerId());
		statement.setString(3, record.getAssociatedVin());
		statement.setDouble(4, record.getVehicleCost());
		statement.setInt(5, record.getCreditScore());
		statement.setDouble(6, record.getInterestRate());
		statement.setInt(7, record.getTerm());
		statement.setDouble(8, record.getDownPayment());
		statement.setDouble(9, record.getPrincipal());
		statement.setDouble(10, record.getTotalDebt());
		statement.setInt(11, record.getInstallmentsPaid());
		
		int rowsAffected = statement.executeUpdate();
		statement.close();
		closeConnection();
		
		return rowsAffected > 0;
	}
	
	//————————————————————————————————————————— delete methods:
	
	public boolean deleteRecord(String finId) throws SQLException {
		establishConnection();
		
		String query = "DELETE FROM VehicleInventory.FinanceRecords WHERE vin = '" + finId + "'";
		Statement statement = dbConnection.createStatement();
		int rowsAffected = statement.executeUpdate(query);
		
		statement.close();
		closeConnection();
		return rowsAffected > 0;
	}
	
	public boolean deleteRecord(FinanceRecord record) throws SQLException {
		establishConnection();
		
		String query = "DELETE FROM VehicleInventory.FinanceRecords WHERE vin = '" + record.getFinanceId() + "'";
		Statement statement = dbConnection.createStatement();
		int rowsAffected = statement.executeUpdate(query);
		
		statement.close();
		closeConnection();
		return rowsAffected > 0;
	}
	
	public boolean clearTable() throws SQLException {
		establishConnection();
		
		Statement statement = dbConnection.createStatement();
		List<String> allFinIds = this.listAllRecordIds();
		for(String finID : allFinIds) {
			String query = "DELETE FROM VehicleInventory.FinanceRecords WHERE FinanceID = '" + finID + "'";
			statement.execute(query); 
		}
		
		ResultSet results = statement.executeQuery("SELECT * FROM VehicleInventory.FinanceRecords");
		
		int numRows = 0;
		while(results.next()) {
			numRows++;
		}
		
		statement.close();
		closeConnection();
		
		return numRows < 1;
	}

}