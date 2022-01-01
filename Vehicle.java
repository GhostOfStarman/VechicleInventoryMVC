package com.vehicles;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
		this.vehicleIdNumber = vehicleIdNumber.toUpperCase();
		this.make = make.toUpperCase();
		this.model = model.toUpperCase();
		this.year = year;
		this.exteriorColor = exteriorColor.toUpperCase();
		this.interiorColor = interiorColor.toUpperCase();
		this.mileage = mileage;
		this.condition = condition.toUpperCase();
		this.titleStatus = TITLESTATUS[titleIndex];
		this.driveTrainType = DRIVETRAIN[dtIndex];
		this.transmissionType = TRANSMISSION[transmissionIndex];
		this.fuelType = FUELTYPE[fuelIndex];
		this.price = priceFormat(this.price);
	}
	
	public Vehicle(String vehicleIdNumber, String make, String model, int year, String exteriorColor, String interiorColor, int mileage, String condition, String titleStatus, 
			String driveTrainType, String transmissionType, String fuelType, double price) {
		this.vehicleIdNumber = vehicleIdNumber.toUpperCase();
		this.make = make.toUpperCase();
		this.model = model.toUpperCase();
		this.year = year;
		this.exteriorColor = exteriorColor.toUpperCase();
		this.interiorColor = interiorColor.toUpperCase();
		this.mileage = mileage;
		this.condition = condition.toUpperCase();
		this.titleStatus = titleStatus.toUpperCase();
		this.driveTrainType = driveTrainType.toUpperCase();
		this.transmissionType = transmissionType.toUpperCase();
		this.fuelType = fuelType.toUpperCase();
		this.price = priceFormat(this.price);
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
			this.condition = condition.toUpperCase();
			return this;
		}

		public CarBuilder engine(int dtIndex, int transmIndex, int fuelIndex){
			this.driveTrainType = DRIVETRAIN[dtIndex];
			this.transmissionType = TRANSMISSION[transmIndex];
			this.fuelType = FUELTYPE[fuelIndex];
			return this;
		}

		public CarBuilder cost(double price){
			this.price = priceFormat(price);
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
			car.price = priceFormat(this.price);
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
		this.make = make.toUpperCase();
	}
	
	public void setModel(String model) {
		this.model = model.toUpperCase();
	}
	
	public void setvehicleIdNumber(String vehicleIdNumber) {
		this.vehicleIdNumber = vehicleIdNumber.toUpperCase();
	}
	
	public void setExteriorColor(String color) {
		this.exteriorColor = color.toUpperCase();
	}
	
	public void setInteriorColor(String color) {
		this.interiorColor = color.toUpperCase();
	}
	
	public void setMileage(int miles) {
		this.mileage = miles;
	}
	
	public void setCondition(String cond) {
		this.condition = cond.toUpperCase();
	}
	
	public void setDriveTrain(int index) {
		try {
			this.driveTrainType = DRIVETRAIN[index];
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Invalid input");
		}
	}
	
	public void setDriveTrain(String dtType) {
		this.driveTrainType = dtType.toUpperCase();
	}
	
	public void setTranmission(int index) {
		try {
			this.transmissionType = TRANSMISSION[index];
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Invalid input");
		}
	}
	
	public void setTranmission(String trans) {
		this.transmissionType = trans.toUpperCase();
	}
	
	public void setFuelType(int index) {
		try {
			this.fuelType = FUELTYPE[index];
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Invalid input");
		}
	}
	
	public void setFuelType(String fuel) {
		this.fuelType = fuel.toUpperCase();
	}
	
	public void setTitleStatus(int index) {
		try {
			this.titleStatus = TITLESTATUS[index];
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Invalid input");
		}
	}
	
	public void setTitleStatus(String title) {
		this.titleStatus = title.toUpperCase();
	}
	
	public void setPrice(double price) {
		this.price = priceFormat(price);
	}
	
	//--------------------------------------------------------------------------- Helper methods:
	
	public static double priceFormat(Double price) {
	    BigDecimal bdPrice = BigDecimal.valueOf(price);
	    return bdPrice.setScale(2, RoundingMode.HALF_UP).doubleValue();
	}
	
}
	