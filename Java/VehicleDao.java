package com.vehicles;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


public class VehicleDao {

	  private String dbUrl;
	  private String dbUsername;
	  private String dbPassword;
	  private static Connection dbConnection; 
	  
	  public VehicleDao(String dbUrl, String dbUsername, String dbPassword) {
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
	  
	  public boolean insertVehicle(Vehicle car) throws SQLException {
			establishConnection();
			
			String query = "INSERT INTO VehicleInventory.Cars (vin, make, model, modelYear, extColor, intColor, mileage, "
					+ "currCondition, title, driveTrain, transmission, fuel, price) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement statement = dbConnection.prepareStatement(query);
			statement.setString(1, car.getVehicleIdNumber());
			statement.setString(2, car.getMake());
			statement.setString(3, car.getModel());
			statement.setInt(4, car.getYear());
			statement.setString(5, car.getExteriorColor());
			statement.setString(6, car.getInteriorColor());
			statement.setInt(7, car.getMileage());
			statement.setString(8, car.getCondition());
			statement.setString(9, car.getTitleStatus());
			statement.setString(10, car.getDriveTrainType());
			statement.setString(11, car.getTransmissionType());
			statement.setString(12, car.getFuelType());
			statement.setDouble(13, car.getPrice());
			
			int rowsAffected = statement.executeUpdate();
			statement.close();
			closeConnection();
			
			return rowsAffected > 0;
	  }
	  
		public int getNumVehicles() throws SQLException {
			establishConnection();
			Statement statement = dbConnection.createStatement();
			ResultSet results = statement.executeQuery("SELECT * FROM VehicleInventory.Cars");
			
			int count = 0;
			while(results.next()) {
				count++;
			}
			statement.close();
			closeConnection();
			return count;
		}

//—————————————————————————————————————————	Read methods:  
	  
	  public List<Vehicle> listAllVehicles() throws SQLException {
			List<Vehicle> inventory = new ArrayList<>();

			establishConnection();
			
			String query = "SELECT * FROM VehicleInventory.Cars";
			Statement statement = dbConnection.createStatement();
			ResultSet results = statement.executeQuery(query);

			while(results.next()) {
				String vin = results.getString("vin");
				String make = results.getString("make");
				String model = results.getString("model");
				int year = results.getInt("modelYear"); 
				String intColor = results.getString("intColor");
				String extColor = results.getString("extColor");
				int mileage = results.getInt("mileage");
				String condition = results.getString("currCondition");
				String title = results.getString("title");
				String driveTrain = results.getString("driveTrain");
				String transmission = results.getString("transmission");
				String fuel = results.getString("fuel");
				double price = results.getDouble("price");
				
				Vehicle car = new Vehicle(vin, make, model, year, extColor, intColor, mileage, condition, title, driveTrain, transmission, fuel, price);
				inventory.add(car);
			}
			
			statement.close();
			closeConnection();
			
			return inventory;
		}
	  
	  public Vehicle getByVin(String vinNo) throws SQLException{
		  	establishConnection();
			
			String query = "SELECT * FROM VehicleInventory.Cars WHERE vin ='" + vinNo+"'";
			Statement statement = dbConnection.createStatement();
			ResultSet results = statement.executeQuery(query);
			
			Vehicle car = null;
			if(results.next()) {
				String vin = results.getString("vin");
				String make = results.getString("make");
				String model = results.getString("model");
				int year = results.getInt("modelYear"); 
				String intColor = results.getString("intColor");
				String extColor = results.getString("extColor");
				int mileage = results.getInt("mileage");
				String condition = results.getString("currCondition");
				String title = results.getString("title");
				String driveTrain = results.getString("driveTrain");
				String transmission = results.getString("transmission");
				String fuel = results.getString("fuel");
				double price = results.getDouble("price");
				
				car = new Vehicle(vin, make, model, year, extColor, intColor, mileage, condition, title, driveTrain, transmission, fuel, price);
			}
			
			statement.close();
			closeConnection();
			
			return car;
		}
	  
	  public List<String> listAllVins() throws SQLException {
			establishConnection();
			List<String> acctIds = new ArrayList<>();
			
			String query = "SELECT vin FROM VehicleInventory.Cars";
			Statement statement = dbConnection.createStatement();
			ResultSet results = statement.executeQuery(query);

			while(results.next()) {
				acctIds.add(results.getString("vin"));
			}
			
			statement.close();
			closeConnection();
			
			return acctIds;
		}
	
//————————————————————————————————————————— update methods:
	
	public boolean updateVehicle(Vehicle vehicle) throws SQLException{
		establishConnection();
		
		String query = "UPDATE VehicleInventory.Cars SET vin = ?, make = ?, model = ?, modelYear = ?, extColor = ?,"
				+ " intColor = ?, mileage = ?, currCondition = ?, title = ?, driveTrain = ?, transmission = ?, fuel = ?, price = ? WHERE vin = '" + vehicle.getVehicleIdNumber() + "'";
		PreparedStatement statement = dbConnection.prepareStatement(query);
		
		statement.setString(1, vehicle.getVehicleIdNumber());
		statement.setString(2, vehicle.getMake());
		statement.setString(3, vehicle.getModel());
		statement.setInt(4, vehicle.getYear());
		statement.setString(5, vehicle.getExteriorColor());
		statement.setString(6, vehicle.getInteriorColor());
		statement.setInt(7, vehicle.getMileage());
		statement.setString(8, vehicle.getCondition());
		statement.setString(9, vehicle.getTitleStatus());
		statement.setString(10, vehicle.getDriveTrainType());
		statement.setString(11, vehicle.getTransmissionType());
		statement.setString(12, vehicle.getFuelType());
		statement.setDouble(13, vehicle.getPrice());
		
		int rowsAffected = statement.executeUpdate();
		statement.close();
		closeConnection();
		
		return rowsAffected > 0;
	}
	
	
//————————————————————————————————————————— delete methods:
	
	public boolean deleteVehicle(String vinNo) throws SQLException {
		establishConnection();
		
		String query = "DELETE FROM VehicleInventory.Cars WHERE vin = '" + vinNo + "'";
		Statement statement = dbConnection.createStatement();
		int rowsAffected = statement.executeUpdate(query);
		
		statement.close();
		closeConnection();
		return rowsAffected > 0;
	}
	
	public boolean deleteVehicle(Vehicle vehicle) throws SQLException {
		establishConnection();
		
		String query = "DELETE FROM VehicleInventory.Cars WHERE vin = '" + vehicle.getVehicleIdNumber() + "'";
		Statement statement = dbConnection.createStatement();
		int rowsAffected = statement.executeUpdate(query);
		
		statement.close();
		closeConnection();
		return rowsAffected > 0;
	}
	
	public boolean clearTable() throws SQLException {
		establishConnection();
		
		Statement statement = dbConnection.createStatement();
		List<String> allVins = this.listAllVins();
		for(String vin : allVins) {
			String query = "DELETE FROM VehicleInventory.Cars WHERE vin = '" + vin + "'";
			statement.execute(query); //use executeQuery() with ResultSet
		}
		
		ResultSet results = statement.executeQuery("SELECT * FROM VehicleInventory.Cars");
		
		int numRows = 0;
		while(results.next()) {
			numRows++;
		}
		
		statement.close();
		closeConnection();
		
		return numRows < 1;
	}
	
}
