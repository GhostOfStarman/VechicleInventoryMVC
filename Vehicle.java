package vehInvOne;
import java.util.*;

public class Vehicle{
	
	public enum driveTrain{AWD, FWD, RWD, FOURWD}
	public enum transmission{AT, MT, AM, CVT}
	public enum power{gas, electric, hybrid}
	public enum titleStatus{CLEAN, CLEAR, SALVAGE, REBUILT}

	private String make;
	private String model;
	private String VIN;
	private int year;

	private String extColor;
	private String intColor;

	private int mileage;
	private String condition;
	private titleStatus title;

	private driveTrain driveTrainType;
	private transmission transmissionType;
	private power fuel;

	private double price;

	public static class CarBuilder{
		private String make;
		private String model;
		private String VIN;
		private int year;

		private String extColor;
		private String intColor;

		private int mileage;
		private String condition;
		private titleStatus title;
	
		private driveTrain driveTrainType;
		private transmission transmissionType;
		private power fuel;

		private double price;

		public CarBuilder(String VIN, String make, String model, int year) {
			this.VIN = VIN;
			this.make = make;
			this.model = model;
			this.year = year;

		}

		public CarBuilder color(String extColor, String intColor){
			this.extColor = extColor;
			this.intColor = intColor;
			
			return this;
		}

		public CarBuilder usageHist(int mileage, titleStatus title, String condition){
			this.mileage = mileage;
			this.title = title;
			this.condition = condition;
			
			return this;
		}

		public CarBuilder engine(driveTrain driveTrainType, transmission transmissionType, power fuel){
			this.driveTrainType = driveTrainType;
			this.transmissionType = transmissionType;
			this.fuel = fuel;

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
			car.VIN = this.VIN;
			car.extColor = this.extColor;
			car.intColor = this.intColor;
			car.mileage = this.mileage;
			car.condition = this.condition;
			car.driveTrainType = this.driveTrainType;
			car.transmissionType = transmissionType;
			car.fuel = this.fuel;
			car.price = price;
			car.title = this.title;
			
			return car;
		}	
	}

	//private Vehicle(){}
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
	
	public String getVIN() {
		return this.VIN;
	}
	
	public String getExtClr() {
		return this.extColor;
	}
	
	public String getIntClr() {
		return this.intColor;
	}
	
	public int getMileage() {
		return this.mileage;
	}
	
	public String getCondition() {
		return this.condition;
	}
	
	public driveTrain getDriveTrain() {
		return this.driveTrainType;
	}
	
	public transmission getTrans() {
		return this.transmissionType;
	}
	
	public power getFuel() {
		return this.fuel;
	}
	
	public titleStatus getTitleStatus() {
		return this.title;
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
	
	public void setVIN(String vin) {
		this.VIN = vin.toUpperCase();
	}
	
	public void setExtClr(String color) {
		this.extColor = color.toUpperCase();
	}
	
	public void setIntClr(String color) {
		this.intColor = color.toUpperCase();
	}
	
	public void setMileage(int mile) {
		this.mileage = mile;
	}
	
	public void setCondition(String cond) {
		this.condition = cond.toUpperCase();
	}
	
	public void setDriveTrain(driveTrain dt) {
		this.driveTrainType = dt;
	}
	
	public void setTrans(transmission trans) {
		this.transmissionType = trans;
	}
	
	public void setFuel(power fuel) {
		this.fuel = fuel;
	}
	
	public void setTitleStatus(titleStatus title) {
		this.title = title;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
}
	
	
