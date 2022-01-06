package com.transactions;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.users.User;
import com.users.UserDao;
import com.vehicles.Vehicle;
import com.vehicles.VehicleDao;

public class CompleteTransaction {
	protected int transId;
	protected int buyerId;
	protected String vin;
	protected String make;
	protected String model;
	protected int modelYear;
	protected String extColor;
	protected String intColor;
	protected int mileage;
	protected String soldCondition;
	protected double askingPrice;
//	protected User buyer;
//	protected Vehicle car;
	protected double sellingPrice;
	
	
	public CompleteTransaction(){}

	public CompleteTransaction(int transId){
		this.transId = transId;
	}
	
	public CompleteTransaction(int transId, int buyerId, String vin) {
		this.transId = transId;
		this.buyerId = buyerId;
		this.vin = vin.toUpperCase();;
	}
	
	public CompleteTransaction(int transId, int buyerId, String vin, String make, String model, int modelYear, String extColor, String intColor, int mileage, String soldCondition,
			double askingPrice, double sellingPrice) {
			this(transId, buyerId, vin);
			this.make = make.toUpperCase();
			this.model = model.toUpperCase();;
			this.modelYear = modelYear;
			this.extColor = extColor.toUpperCase();;
			this.intColor = intColor.toUpperCase();;
			this.mileage = mileage;
			this.soldCondition = soldCondition.toUpperCase();;
			this.askingPrice = priceFormat(askingPrice);
			this.sellingPrice = priceFormat(sellingPrice);
	}
	
//	public CompleteTransaction(int transId, int buyerId, String vin, double sellingPrice) throws SQLException {
//			this(transId, buyerId, vin);
//			this.buyer = new UserDao().getUserById(buyerId);
//			this.car = new VehicleDao().getByVin(vin);
//			this.make = car.getMake();
//			this.model = car.getModel();
//			this.modelYear = car.getYear();
//			this.extColor = car.getExteriorColor();
//			this.intColor = car.getInteriorColor();
//			this.mileage = car.getMileage();
//			this.soldCondition = car.getCondition();
//			this.askingPrice = car.getPrice();
//			this.sellingPrice = sellingPrice;
//	}

	//-------------------------------------------------

	public int getTransId(){
		return this.transId;
	}
	
	public int getBuyerId() {
		return this.buyerId;
	}
	
	public String getVin(){
		return this.vin;
	}

	public String getMake(){
		return this.make;
	}

	public String getModel(){
		return this.model;
	}

	public int getModelYear(){
		return this.modelYear;
	}

	public String getExtColor(){
		return this.extColor;
	}

	public String getIntColor(){
		return this.intColor;
	}
	
	public int getMileage(){
		return this.mileage;
	}
	
	public String getSoldCondition(){
		return this.soldCondition;
	}
	
	public double getAskingPrice(){
		return this.askingPrice;
	}
	
	public double getSellingPrice(){
		return this.sellingPrice;
	}


	//-------------------------------------------------

	public void setTransId(int id){
		this.transId = id;
	}
	
	public void setBuyerId(int id) {
		this.buyerId = id;
	}
	
	public void setVin(String vin){
		this.vin = vin;
	}

	public void setMake(String make){
		this.make = make;
	}

	public void setModel(String model){
		this.model = model;
	}

	public void setModelYear(int year){
		this.modelYear = year;
	}

	public void setExtColor(String color){
		this.extColor = color;
	}

	public void setIntColor(String color){
		this.intColor = color;
	}
	
	public void setMileage(int miles){
		this.mileage = miles;
	}
	
	public void setSoldCondition(String condition){
		this.soldCondition = condition;
	}
	
	public void setAskingPrice(double price){
		this.askingPrice = price;
	}
	
	public void setSellingPrice(double price){
		this.sellingPrice = price;
	}

	public static double priceFormat(Double price) {
	    BigDecimal bdPrice = BigDecimal.valueOf(price);
	    return bdPrice.setScale(2, RoundingMode.HALF_UP).doubleValue();
	}
}
