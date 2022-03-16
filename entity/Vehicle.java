package com.vehicleinventory.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Cars")
public class Vehicle{
	
	@Id
	@Column(name="vin")
	@NotNull(message="cannot be blank")
	@Size(min=17, max=17, message="must be 17 Characters")
	private String vehicleIdNumber;
	
	@NotNull(message="cannot be blank")
	@Size(min=1, max=20, message="must be between 1-20 Characters")
	@Column(name="make")
	private String make;
	
	@NotNull(message="cannot be blank")
	@Size(min=1, max=20, message="must be between 1-20 Characters")
	@Column(name="model")
	private String model;
	
	@NotNull(message="cannot be blank")
	@Min(value=1900, message="must be more than 1900")
	@Max(value=2022, message="must be less than 2022")
	@Column(name="modelYear")
	private int year;
	
	@NotNull(message="cannot be blank")
	@Size(min=1, max=20, message="must be between 1-20 Characters")
	@Column(name="extColor")
	private String exteriorColor;
	
	@NotNull(message="cannot be blank")
	@Size(min=1, max=20, message="must be between 1-20 Characters")
	@Column(name="intColor")
	private String interiorColor;
	
	@NotNull(message="cannot be blank")
	@Min(value=0, message="must be at least 0")
	@Max(value=500000, message="must be less than 500000")
	@Column(name="mileage")
	private int mileage;
	
	@NotNull(message="cannot be blank")
	@Column(name="currCondition")
	private String condition;
	
	@NotNull(message="cannot be null")
	@Column(name="title")
	private String titleStatus;
	
	@NotNull(message="cannot be null")
	@Column(name="driveTrain")
	private String drivetrainType;
	
	@NotNull(message="cannot be null")
	@Column(name="transmission")
	private String transmissionType;
	
	@NotNull(message="cannot be null")
	@Column(name="fuel")
	private String fuelType;

	@NotNull(message="cannot be blank")
	@Min(value=0, message="must be at least $0.00")
	@Max(value=10000000, message="must be less than $10,000,000")
	@Column(name="price")
	private double price;
	
	// ----------------------------------------------------------------------------------- >
	
	// links the PK from FinanceRecord (financeId) table to the FK column in the Cars table (financeId)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="financeId")
    private FinanceRecord financeRecord;
	
	// ---------------------------------------------------------------------------------------------------------
	
	public Vehicle() {}
	
	public Vehicle(String vehicleIdNumber) {
		this.vehicleIdNumber = vehicleIdNumber;
	}
	
	public Vehicle(String vehicleIdNumber, String make, String model, int year, String exteriorColor, String interiorColor, int mileage, String condition, String titleStatus, 
			String drivetrainType, String transmissionType, String fuelType, double price) {
		this.vehicleIdNumber = vehicleIdNumber.toUpperCase();
		this.make = make.toUpperCase();
		this.model = model.toUpperCase();
		this.year = year;
		this.exteriorColor = exteriorColor.toUpperCase();
		this.interiorColor = interiorColor.toUpperCase();
		this.mileage = mileage;
		this.condition = condition.toUpperCase();
		this.titleStatus = titleStatus.toUpperCase();
		this.drivetrainType = drivetrainType.toUpperCase();
		this.transmissionType = transmissionType.toUpperCase();
		this.fuelType = fuelType.toUpperCase();
		this.price = priceFormat(this.price);
	}
	
	// ---------------------------------------------------------------------------------------------------------
	// A nested class for employing builder pattern
	
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
	
		private String drivetrainType;
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

		public CarBuilder usageHist(int mileage, String titleStatus, String condition){
			this.mileage = mileage;
			this.titleStatus = titleStatus.toUpperCase();
			this.condition = condition.toUpperCase();
			return this;
		}

		public CarBuilder engine(String drivetrainType, String transmissionType, String fuelIndex){
			this.drivetrainType = drivetrainType;
			this.transmissionType = transmissionType;
			this.fuelType = fuelIndex;
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
			car.drivetrainType = this.drivetrainType;
			car.transmissionType = this.transmissionType;
			car.fuelType = this.fuelType;
			car.price = priceFormat(this.price);
			car.titleStatus = this.titleStatus;
			
			return car;
		}	
	}
	
	// ---------------------------------------------------------------------------------------------------------
	public static double priceFormat(Double price) {
	    BigDecimal bdPrice = BigDecimal.valueOf(price);
	    return bdPrice.setScale(2, RoundingMode.HALF_UP).doubleValue();
	}

	public String getVehicleIdNumber() {
		return vehicleIdNumber;
	}

	public void setVehicleIdNumber(String vehicleIdNumber) {
		this.vehicleIdNumber = vehicleIdNumber.toUpperCase();	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make.toUpperCase();;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model.toUpperCase();;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getExteriorColor() {
		return exteriorColor;
	}

	public void setExteriorColor(String exteriorColor) {
		this.exteriorColor = exteriorColor.toUpperCase();;
	}

	public String getInteriorColor() {
		return interiorColor;
	}

	public void setInteriorColor(String interiorColor) {
		this.interiorColor = interiorColor.toUpperCase();;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getTitleStatus() {
		return titleStatus;
	}

	public void setTitleStatus(String titleStatus) {
		this.titleStatus = titleStatus;
	}

	public String getdrivetrainType() {
		return drivetrainType;
	}

	public void setdrivetrainType(String drivetrainType) {
		this.drivetrainType = drivetrainType;
	}

	public String getTransmissionType() {
		return transmissionType;
	}

	public void setTransmissionType(String transmissionType) {
		this.transmissionType = transmissionType;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = priceFormat(price);
	}
	
}
	