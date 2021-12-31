package com.vehicles;

//import java.util.*;

public class Vehicle{
	
	private String vehicleIdNumber;
	private String make;
	private String model;
	private int year;
	
	private String exteriorColor;
	private String interiorColor;

	private int mileage;
	private String condition;
	
	private String titleStatus;
	private String driveTrainType;
	private String transmissionType;
	private String fuelType;

	private double price;
	
	public static final String[] DRIVETRAIN = {"AWD", "FWD", "RWD", "FOURWD"};
	public static final String[] TRANSMISSION = {"AT", "MT", "AM", "CVT"};
	public static final String[] FUELTYPE = {"GAS", "ELECTRIC", "HYBRID"};    
	public static final String[] TITLESTATUS ={"CLEAN", "CLEAR", "SALVAGE", "REBUILT"};
	
	
	public Vehicle() {}
	
	public Vehicle(String vehicleIdNumber) {
		this.vehicleIdNumber = vehicleIdNumber;
	}
	

	//this constructor is used to create vehicles by restricting the choices of input for title, drivetrain, transmission, and fueltype
	//each each index is used in reference to the constant arrays that belong to every Vehicle object
	//converting each category into enums was also considered and used before chaning to arrays
	public Vehicle(String vehicleIdNumber, String make, String model, int year, String exteriorColor, String interiorColor, int mileage, String condition, int titleIndex, 
			int dtIndex, int transmissionIndex, int fuelIndex, double price) {
		this.vehicleIdNumber = vehicleIdNumber;
		this.make = make;
		this.model = model;
		this.year = year;
		this.exteriorColor = exteriorColor;
		this.interiorColor = interiorColor;
		this.mileage = mileage;
		this.condition = condition;
		this.titleStatus = TITLESTATUS[titleIndex];
		this.driveTrainType = DRIVETRAIN[dtIndex];
		this.transmissionType = TRANSMISSION[transmissionIndex];
		this.fuelType = FUELTYPE[fuelIndex];
		this.price = price;
	}
	
	public Vehicle(String vehicleIdNumber, String make, String model, int year, String exteriorColor, String interiorColor, int mileage, String condition, String titleStatus, 
			String driveTrainType, String transmissionType, String fuelType, double price) {
		this.vehicleIdNumber = vehicleIdNumber;
		this.make = make;
		this.model = model;
		this.year = year;
		this.exteriorColor = exteriorColor;
		this.interiorColor = interiorColor;
		this.mileage = mileage;
		this.condition = condition;
		this.titleStatus = titleStatus;
		this.driveTrainType = driveTrainType;
		this.transmissionType = transmissionType;
		this.fuelType = fuelType;
		this.price = price;
	}
	

//-------------building the car:
	public static class CarBuilder{
		private String make;
		private String model;
		private String vehicleIdNumber;
		private int year;

		private String exteriorColor;
		private String interiorColor;

		private int mileage;
		private String condition;
		private String titleStatus;
	
		private String driveTrainType;
		private String transmissionType;
		private String fuelType;

		private double price;

		public CarBuilder(String vehicleIdNumber, String make, String model, int year) {
			this.vehicleIdNumber = vehicleIdNumber.toUpperCase();
			this.make = make.toUpperCase();
			this.model = model.toUpperCase();
			this.year = year;
		}

		public CarBuilder color(String exteriorColor, String interiorColor){
			this.exteriorColor = exteriorColor.toUpperCase();
			this.interiorColor = interiorColor.toUpperCase();
			return this;
		}

		public CarBuilder usageHist(int mileage, int titleIndex, String condition){
			this.mileage = mileage;
			this.titleStatus = TITLESTATUS[titleIndex];
			this.condition = condition;
			return this;
		}

		public CarBuilder engine(int dtIndex, int transmIndex, int fuelIndex){
			this.driveTrainType = DRIVETRAIN[dtIndex];
			this.transmissionType = TRANSMISSION[transmIndex];
			this.fuelType = FUELTYPE[fuelIndex];
			return this;
		}

		public CarBuilder cost(double price){
			this.price = price;
			return this;
		}

		public Vehicle build(){
			Vehicle car = new Vehicle();
			car.make = this.make;
			car.model = this.model;
			car.year = this.year;
			car.vehicleIdNumber = this.vehicleIdNumber;
			car.exteriorColor = this.exteriorColor;
			car.interiorColor = this.interiorColor;
			car.mileage = this.mileage;
			car.condition = this.condition;
			car.driveTrainType = this.driveTrainType;
			car.transmissionType = this.transmissionType;
			car.fuelType = this.fuelType;
			car.price = this.price;
			car.titleStatus = this.titleStatus;
			
			return car;
		}	
	}
	
//---------------------------------------------------------------------------------------------------------
	public int getYear() {
		return this.year;
	}
	
	public String getMake() {
		return this.make;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public String getVehicleIdNumber() {
		return this.vehicleIdNumber;
	}
	
	public String getExteriorColor() {
		return this.exteriorColor;
	}
	
	public String getInteriorColor() {
		return this.interiorColor;
	}
	
	public int getMileage() {
		return this.mileage;
	}
	
	public String getCondition() {
		return this.condition;
	}
	
	public String getDriveTrainType() {
		return this.driveTrainType;
	}
	
	public String getTransmissionType() {
		return this.transmissionType;
	}
	
	public String getFuelType() {
		return this.fuelType;
	}
	
	public String getTitleStatus() {
		return this.titleStatus;
	}
	
	public double getPrice() {
		return this.price;
	}
	
//---------------------------------------------------------------------------------------------------------
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public void setvehicleIdNumber(String vehicleIdNumber) {
		this.vehicleIdNumber = vehicleIdNumber;
	}
	
	public void setExteriorColor(String color) {
		this.exteriorColor = color;
	}
	
	public void setInteriorColor(String color) {
		this.interiorColor = color;
	}
	
	public void setMileage(int mile) {
		this.mileage = mile;
	}
	
	public void setCondition(String cond) {
		this.condition = cond;
	}
	
	public void setDriveTrain(int index) {
		try {
			this.driveTrainType = DRIVETRAIN[index];
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Invalid input");
		}
	}
	
	public void setDriveTrain(String dtType) {
		this.driveTrainType = dtType;
	}
	
	public void setTranmission(int index) {
		try {
			this.transmissionType = TRANSMISSION[index];
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Invalid input");
		}
	}
	
	public void setTranmission(String trans) {
		this.transmissionType = trans;
	}
	
	public void setFuelType(int index) {
		try {
			this.fuelType = FUELTYPE[index];
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Invalid input");
		}
	}
	
	public void setFuelType(String fuel) {
		this.fuelType = fuel;
	}
	
	public void setTitleStatus(int index) {
		try {
			this.titleStatus = TITLESTATUS[index];
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Invalid input");
		}
	}
	
	public void setTitleStatus(String title) {
		this.titleStatus = title;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	//---------------------------------------------------------------------------------------------------------
//	public double priceFormat(Double price) {
//		
//	}
	
}
	