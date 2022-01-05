package com.financing;

import com.vehicles.Vehicle;
import java.math.*;

public class FinanceRecord{

	protected int financeId;
	protected int customerId;
	protected int creditScore;
	protected String associatedVin;

	protected int term;
	protected int installmentsPaid;
	protected double vehicleCost;
	protected double interestRate;
	protected double downPayment;
	protected double principal;
	protected double totalDebt;

	//these interest rates are ANNUAL, converted to monthly in calcMonthlyPayments()
	public static final double[] preownedInterestRates = {20.5, 17.75, 11.25, 6.0, 4.5};
	public static final double[] pristineInterestRates = {14.5, 12.0, 7.5, 4.7, 3.7};
	public static final int[] termOptions = {12, 24, 36, 48, 60, 72, 84};


	public FinanceRecord(int financeId){
		this.financeId = financeId;
	}

	public FinanceRecord(int financeId, int customerId, String associatedVin){
		this.financeId = financeId;
		this.customerId = customerId;
		this.associatedVin = associatedVin;
	}

	//constructor without Vehicle object as parameter
	public FinanceRecord(int financeId, int customerId, int creditScore, String associatedVin, int term, double interestRate, double vehicleCost, double downPayment, double principal, double totalDebt, int installmentsPaid){
		this.financeId = financeId;
		this.customerId = customerId;
		this.creditScore = creditScore;
		this.associatedVin = associatedVin;
		this.term = term;
		this.interestRate = interestRate;
		this.vehicleCost = priceFormat(vehicleCost);
		this.downPayment = priceFormat(downPayment);
		this.principal = priceFormat(principal);
		this.totalDebt = priceFormat(vehicleCost - downPayment);
		this.installmentsPaid = installmentsPaid;
	}
	
	public FinanceRecord(int financeId, int customerId, Vehicle vehicle, int creditScore, int term, double interestRate, double downPayment, double principal, double totalDebt, int installmentsPaid){
		this.financeId = financeId;
		this.customerId = customerId;
		this.creditScore = creditScore;
		this.associatedVin = vehicle.getVehicleIdNumber();
		this.term = term;
		this.interestRate = interestRate;
		
		double cost = priceFormat(vehicle.getPrice());
		
		this.vehicleCost = cost;
		this.downPayment = priceFormat(downPayment);
		this.principal = priceFormat(principal);
		this.totalDebt = priceFormat(cost - downPayment);
		this.installmentsPaid = installmentsPaid;
	}

	//------------------------------------------------- helper methods:

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

	//calculating amortized loan
	public double calcMonthlyPayments(double principal, double rate, int term){
		rate /= 12;
		double monthlyPayments = principal * ((rate * Math.pow((1 + rate), term)/(Math.pow(1 + rate, term) - 1)));
		return monthlyPayments;
	}

	public boolean isFullyPaidOff(){
		return installmentsPaid == term;
	}

	public boolean makePayment(){
		totalDebt -= (this.calcMonthlyPayments(this.principal, this.interestRate, this.term)); 
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

	//------------------------------------------------- getters:

	public int getFinanceId(){
		return this.financeId;
	}

	public int getCustomerId(){
		return this.customerId;
	}

	public String getAssociatedVin(){
		return this.associatedVin;
	}

	public int getTerm(){
		return this.term;
	}

	public double getPrincipal(){
		return this.principal;
	}

	public double getInterestRate(){
		return this.interestRate;
	}

	public double getTotalDebt(){
		return this.totalDebt;
	}

	public int getCreditScore(){
		return this.creditScore;
	}

	public double getDownPayment(){
		return this.downPayment;
	}

	public int getInstallmentsPaid(){
		return this.installmentsPaid;
	}

	public double getVehicleCost(){
		return this.vehicleCost;
	}

	//------------------------------------------------- setters:

	public void setfinanceId(int finId){
		this.financeId = finId;
	}

	public void setCustomerId(int custId){
		this.customerId = custId;
	}

	public void setAssociatedVin(String vin){
		this.associatedVin = vin;
	}

	public void setTerm(int length){
		this.term = length;
	}

	public void setPresetTerm(int index){
		try{
			this.interestRate = termOptions[index];
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Invalid Index");
		}
	}

	public void setPrincipalAmt(double amount){
		this.principal = priceFormat(amount);
	}

	public void setInterestRate(double rate){
		this.interestRate = rate;
	}

	public void setPreownedInterestRate(int index){
		try{
			this.interestRate = preownedInterestRates[index];
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Invalid Index");
		}
	}

	public void setPristineInterestRate(int index){
		try{
			this.interestRate = pristineInterestRates[index];
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Invalid Index");
		}
	}

	public void setTotalDebt(double debt){
		this.totalDebt = priceFormat(debt);
	}

	public void setCreditScore(int score){
		this.creditScore = score;
	}
	
	public void setDownPayment(double amount) {
		this.downPayment = priceFormat(amount);
	}
	
	public void setVehicleCost(double price) {
		this.vehicleCost = priceFormat(price);
	}

	public void setInstallmentsPaid(int installmentsPaid){
		this.installmentsPaid = installmentsPaid;
	}
}