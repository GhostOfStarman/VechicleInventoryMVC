package com.vehicleinventory.entity;
import java.math.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="FinanceRecords")
public class FinanceRecord{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="FinanceId")
	private int financeId;
	
	@NotNull(message="cannot be blank")
	@Min(value=1, message="cannot be blank")
	@Column(name="CustomerId")
	private int customerId;
	
	@NotNull(message="cannot be blank")
	@Size(min=1, max=15, message="must be between 1-15 Characters")
	@Column(name="creditScore")
	private int creditScore;
	
	@NotNull(message="cannot be blank")
	@Size(min=1, max=15, message="must be between 1-15 Characters")
	@Column(name="VehicleId")
	private String vehicleId;
	
	@NotNull(message="cannot be blank")
	@Column(name="VehiclePrice")
	private double vehiclePrice;
	
	@NotNull(message="cannot be blank")
	@Column(name="termLength")
	private int termLength;
	
	@NotNull(message="cannot be blank")
	@Column(name="PaymentsMade")
	private int installmentsPaid;
	
	@NotNull(message="cannot be blank")
	@Column(name="InterestRate")
	private double interestRate;
	
	@NotNull(message="cannot be blank")
	@Column(name="DownPayment")
	private double downPayment;
	
	@NotNull(message="cannot be blank")
	@Column(name="Principal")
	private double principal;
	
	@NotNull(message="cannot be blank")
	@Column(name="TotalOwed")
	private double totalDebt;

	// these interest rates are ANNUAL, converted to monthly in calcMonthlyPayments()
	public static final double[] preownedInterestRates = {20.5, 17.75, 11.25, 6.0, 4.5};
	public static final double[] pristineInterestRates = {14.5, 12.0, 7.5, 4.7, 3.7};
	public static final int[] termLengthOptions = {12, 24, 36, 48, 60, 72, 84};

	// ----------------------------------------------------------------------------------- >
	// Constructors

	public FinanceRecord(int financeId){
		this.financeId = financeId;
	}

	public FinanceRecord(int financeId, int customerId, String vehicleId){
		this.financeId = financeId;
		this.customerId = customerId;
		this.vehicleId = vehicleId;
	}

	// constructor without Vehicle object as parameter
	public FinanceRecord(int financeId, int customerId, int creditScore, String vehicleId, int termLength, double interestRate, double vehicleCost, double downPayment, double principal, double totalDebt, int installmentsPaid){
		this.financeId = financeId;
		this.customerId = customerId;
		this.creditScore = creditScore;
		this.vehicleId = vehicleId;
		this.termLength = termLength;
		this.interestRate = interestRate;
		this.vehiclePrice = priceFormat(vehicleCost);
		this.downPayment = priceFormat(downPayment);
		this.principal = priceFormat(principal);
		this.totalDebt = priceFormat(vehicleCost - downPayment);
		this.installmentsPaid = installmentsPaid;
	}
	
	public FinanceRecord(int financeId, int customerId, Vehicle vehicle, int creditScore, int termLength, double interestRate, double downPayment, double principal, double totalDebt, int installmentsPaid){
		this.financeId = financeId;
		this.customerId = customerId;
		this.creditScore = creditScore;
		this.vehicleId = vehicle.getVehicleIdNumber();
		this.termLength = termLength;
		this.interestRate = interestRate;
		
		double price = priceFormat(vehicle.getPrice());
		
		this.vehiclePrice = price;
		this.downPayment = priceFormat(downPayment);
		this.principal = priceFormat(principal);
		this.totalDebt = priceFormat(price - downPayment);
		this.installmentsPaid = installmentsPaid;
	}

	//------------------------------------------------- 
	// calculation methods:

	public double calcPreownedInterestRate(int score){
		if(score <= 579){
			return preownedInterestRates[0];
		}else if(score > 579 && score <= 619){
			return preownedInterestRates[1];
		}else if(score > 619 && score <= 659){
			return preownedInterestRates[2];
		}else if(score > 659 && score <= 719){
			return preownedInterestRates[3];
		}else {
			return preownedInterestRates[4];
		}
	}

	public double calcPristineInterestRate(int score){
		if(score <= 579){
			return pristineInterestRates[0];
		}else if(score > 579 && score <= 619){
			return pristineInterestRates[1];
		}else if(score > 619 && score <= 659){
			return pristineInterestRates[2];
		}else if(score > 659 && score <= 719){
			return pristineInterestRates[3];
		}else {
			return pristineInterestRates[4];
		}
	}

	// calculating amortized loan
	public double calcMonthlyPayments(double principal, double rate, int term){
		rate /= 12;
		double monthlyPayments = principal * ((rate * Math.pow((1 + rate), term)/(Math.pow(1 + rate, term) - 1)));
		return monthlyPayments;
	}

	public boolean isFullyPaidOff(){
		return installmentsPaid == termLength;
	}

	public boolean makePayment(){
		totalDebt -= (this.calcMonthlyPayments(this.principal, this.interestRate, this.termLength)); 
		installmentsPaid -= 1;
		if(totalDebt > 0){
			return true;
		}
		return false;
	}
	
	public static double priceFormat(Double price) {
	    BigDecimal bdPrice = BigDecimal.valueOf(price);
	    return bdPrice.setScale(2, RoundingMode.HALF_UP).doubleValue();
	}
	
	// ----------------------------------------------------------------------------------- >
	// Getters/Setters

	public int getFinanceId() {
		return financeId;
	}

	public void setFinanceId(int financeId) {
		this.financeId = financeId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public double getVehiclePrice() {
		return vehiclePrice;
	}

	public void setVehiclePrice(double vehiclePrice) {
		this.vehiclePrice = vehiclePrice;
	}

	public int gettermLength() {
		return termLength;
	}

	public void settermLength(int termLength) {
		this.termLength = termLength;
	}

	public int getInstallmentsPaid() {
		return installmentsPaid;
	}

	public void setInstallmentsPaid(int installmentsPaid) {
		this.installmentsPaid = installmentsPaid;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getDownPayment() {
		return downPayment;
	}

	public void setDownPayment(double downPayment) {
		this.downPayment = downPayment;
	}

	public double getPrincipal() {
		return principal;
	}

	public void setPrincipal(double principal) {
		this.principal = principal;
	}

	public double getTotalDebt() {
		return totalDebt;
	}

	public void setTotalDebt(double totalDebt) {
		this.totalDebt = totalDebt;
	}

}
	
	