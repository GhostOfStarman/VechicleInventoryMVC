package vehicleInv2;

import java.util.*;

import vehicleInv2.Vehicle2.vehicleEnums.driveTrain;
import vehicleInv2.Vehicle2.vehicleEnums.power;
import vehicleInv2.Vehicle2.vehicleEnums.titleStatus;
import vehicleInv2.Vehicle2.vehicleEnums.transmission;


public class Vehicle2{
	
	private String VehicleIdNumber;
	private String make;
	private String model;
	private int year;
	
	private String exteriorColor;
	private String interiorColor;

	private int mileage;
	private String condition;
	
	private titleStatus title;
	private driveTrain driveTrainType;
	private transmission transmissionType;
	private power fuelType;

	private double price;
	
	//-------------defining enum types:
	public static class vehicleEnums{
		public enum driveTrain{
			AWD("AWD"), FWD("FWD"), RWD("RWD"), FOURWD("FOURWD");
			private String dt;
			driveTrain(String dt){
				this.dt = dt;
			}
			@Override
			public String toString() {
				return dt;
			}
		}
		public enum transmission{
			AT("AT"), MT("MT"), AM("AM"), CVT("CVT");
			private String trans;
			transmission(String trans){
				this.trans = trans;
			}
			@Override
			public String toString() {
				return trans;
			}
		}
		public enum power{
			GAS("GAS"), ELECTRIC("ELECTRIC"), HYBRID("HYBRID");
			private String pwr;
			power(String pwr){
				this.pwr = pwr;
			}
			@Override
			public String toString() {
				return pwr;
			}
		}
		public enum titleStatus{
			CLEAN("CLEAN"), CLEAR("CLEAR"), SALVAGE("SALVAGE"), REBUILT("REBUILT");
			private String ttl;
			titleStatus(String ttl){
				this.ttl = ttl;
			}
			@Override
			public String toString() {
				return ttl;
			}
		}
	}

//-------------building the car:
	public static class CarBuilder{
		private String make;
		private String model;
		private String VehicleIdNumber;
		private int year;

		private String exteriorColor;
		private String interiorColor;

		private int mileage;
		private String condition;
		private titleStatus title;
	
		private driveTrain driveTrainType;
		private transmission transmissionType;
		private power fuel;

		private double price;

		public CarBuilder(String VehicleIdNumber, String make, String model, int year) {
			this.VehicleIdNumber = VehicleIdNumber.toUpperCase();
			this.make = make.toUpperCase();
			this.model = model.toUpperCase();
			this.year = year;
		}

		public CarBuilder color(String exteriorColor, String interiorColor){
			this.exteriorColor = exteriorColor.toUpperCase();
			this.interiorColor = interiorColor.toUpperCase();
			
			return this;
		}

		public CarBuilder usageHist(int mileage, titleStatus title, String condition){
			this.mileage = mileage;
			this.title = title;
			this.condition = condition;
			
			return this;
		}

		public CarBuilder engine(driveTrain driveTrainType, transmission transmissionType, power fuelType){
			this.driveTrainType = driveTrainType;
			this.transmissionType = transmissionType;
			this.fuel = fuelType;

			return this;
		}

		public CarBuilder cost(double price){
			this.price = price;
	
			return this;
		}

		public Vehicle2 build(){
			Vehicle2 car = new Vehicle2();
			car.make = this.make;
			car.model = this.model;
			car.year = this.year;
			car.VehicleIdNumber = this.VehicleIdNumber;
			car.exteriorColor = this.exteriorColor;
			car.interiorColor = this.interiorColor;
			car.mileage = this.mileage;
			car.condition = this.condition;
			car.driveTrainType = this.driveTrainType;
			car.transmissionType = this.transmissionType;
			car.fuelType = this.fuel;
			car.price = this.price;
			car.title = this.title;
			
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
		return this.VehicleIdNumber;
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
		return this.driveTrainType.toString();
	}
	
	public String getTransmissionType() {
		return this.transmissionType.toString();
	}
	
	public String getFuelType() {
		return this.fuelType.toString();
	}
	
	public String getTitleStatus() {
		return this.title.toString();
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
	
	public void setVehicleIdNumber(String VehicleIdNumber) {
		this.VehicleIdNumber = VehicleIdNumber;
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
	
	public void setDriveTrain(driveTrain driveTrainType) {
		this.driveTrainType = driveTrainType;
	}
	
	public void setTranmission(transmission trans) {
		this.transmissionType = trans;
	}
	
	public void setFuelType(power fuel) {
		this.fuelType = fuel;
	}
	
	public void setTitleStatus(titleStatus title) {
		this.title = title;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
}
	
	
