package com.vehicleinventory.entity;
import java.math.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="FinanceRecords")
public class FinanceRecord{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="financeId")
	private int financeId;
	
	@NotNull(message="cannot be blank")
	@Min(value=1, message="cannot be blank")
	@Column(name="customerId")
	private int customerId;
	
	@NotNull(message="cannot be blank")
	@Size(min=1, max=15, message="must be between 1-15 Characters")
	@Column(name="creditScore")
	private int creditScore;
	
	@NotNull(message="cannot be blank")
	@Size(min=1, max=15, message="must be between 1-15 Characters")
	@Column(name="vin")
	private String vehicleIdNumber;
	
	@NotNull(message="cannot be blank")
	@Column(name="VehiclePrice")
	private double vehiclePrice;
	
	@NotNull(message="cannot be blank")
	@Column(name="termLength")
	private int termLength;
	
	@NotNull(message="cannot be blank")
	@Column(name="paymentsMade")
	private int installmentsPaid;
	
	@NotNull(message="cannot be blank")
	@Column(name="apr")
	private double apr;
	
	@NotNull(message="cannot be blank")
	@Column(name="downPayment")
	// @Max(value=(long) this.vehiclePrice)
	private double downPayment;
	
	@NotNull(message="cannot be blank")
	@Column(name="balance")
	private double balance;
	
	@NotNull(message="cannot be blank")
	@Column(name="monthlyPmt")
	private double monthlyPaymentAmount;
	
	@NotNull(message="cannot be blank")
	@Column(name="currConditon")
	private String condition;
	
	@Column(name="paidOff")
	private boolean paidOff;
	
//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "financeId")
//	private Vehicle vehicle;

	// these interest rates are ANNUAL, converted to monthly in calcMonthlyPayments()
	public static final double[] preownedInterestRates = {20.5, 17.75, 11.25, 6.0, 4.5};
	public static final double[] pristineInterestRates = {14.5, 12.0, 7.5, 4.7, 3.7};
	public static final int[] termLengthOptions = {12, 24, 36, 48, 60, 72, 84};

	// ----------------------------------------------------------------------------------- >
	// Constructors
	
	public FinanceRecord() {}
	
	public FinanceRecord(int financeId){
 		this.financeId = financeId;
	}

	public FinanceRecord(int financeId, int customerId, String vehicleIdNumber){
		this.financeId = financeId;
		this.customerId = customerId;
		this.vehicleIdNumber = vehicleIdNumber;
	}

	
	public FinanceRecord(int financeId, int customerId, int creditScore, String vehicleIdNumber, int termLength, double apr, double vehiclePrice, 
			String currCondition, double downPayment, int installmentsPaid){
		
		this.financeId = financeId;
		this.customerId = customerId;
		this.creditScore = creditScore;
		this.vehicleIdNumber = vehicleIdNumber.toUpperCase();
		
		this.termLength = termLength;
		this.condition = currCondition.toUpperCase();
		
		double annualRate = 0.0;
		if(currCondition.equals("NEW")) {
			annualRate = calcPreownedInterestRate(creditScore);
		}else {
			annualRate = calcPristineInterestRate(creditScore);
		}
		this.apr = annualRate;
		
		this.installmentsPaid = installmentsPaid;
		this.vehiclePrice = priceFormat(vehiclePrice);
		this.downPayment = priceFormat(downPayment);
		
		double loanAmount = vehiclePrice - downPayment;
		double monthlyPayment = calcMonthlyPayments(loanAmount, annualRate, termLength);
		
		this.monthlyPaymentAmount = monthlyPayment;
		this.balance = termLength * monthlyPaymentAmount;
		this.paidOff = this.installmentsPaid == termLength;
	}

	// ------------------------------------------------- 
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
	public double calcMonthlyPayments(double principal, double apr, int term){
		apr /= 12;
		double monthPayments = principal * ((apr * Math.pow((1 + apr), term)/(Math.pow(1 + apr, term) - 1)));
		return priceFormat(monthPayments);
	}

//	public boolean makePayment(){
//		balance -= (this.calcMonthlyPayments(this.principal, this.apr, this.termLength)); 
//		installmentsPaid -= 1;
//		if(balance > 0){
//			return true;
//		}
//		return false;
//	}
	
	// ----------------------------------------------------------------------------------- >
	// Getters/Setters:
	
	public static double priceFormat(Double price) {
	    BigDecimal bdPrice = BigDecimal.valueOf(price);
	    return bdPrice.setScale(2, RoundingMode.HALF_UP).doubleValue();
	}

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

	public String getVehicleIdNumber() {
		return vehicleIdNumber;
	}

	public void setVehicleIdNumber(String vehicleIdNumber) {
		this.vehicleIdNumber = vehicleIdNumber;
	}

	public double getVehiclePrice() {
		return vehiclePrice;
	}

	public void setVehiclePrice(double vehiclePrice) {
		this.vehiclePrice = vehiclePrice;
	}

	public int getTermLength() {
		return termLength;
	}

	public void setTermLength(int termLength) {
		this.termLength = termLength;
	}

	public int getInstallmentsPaid() {
		return installmentsPaid;
	}

	public void setInstallmentsPaid(int installmentsPaid) {
		this.installmentsPaid = installmentsPaid;
	}

	public double getApr() {
		return apr;
	}

	public void setApr(double apr) {
		this.apr = apr;
	}

	public double getDownPayment() {
		return downPayment;
	}

	public void setDownPayment(double downPayment) {
		this.downPayment = downPayment;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getMonthlyPaymentAmount() {
		return monthlyPaymentAmount;
	}

	public void setMonthlyPaymentAmount(double monthlyPaymentAmount) {
		this.monthlyPaymentAmount = monthlyPaymentAmount;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public boolean isPaidOff() {
		return paidOff;
	}

	public void setPaidOff(boolean paidOff) {
		this.paidOff = paidOff;
	}
	
//	public Vehicle getVehicle() {
//		return vehicle;
//	}
//
//	public void setVehicle(Vehicle vehicle) {
//		this.vehicle = vehicle;
//	}


}
	
	