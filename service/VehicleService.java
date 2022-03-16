package com.vehicleinventory.service;

import java.util.List;

import com.vehicleinventory.entity.CustomerAccount;
import com.vehicleinventory.entity.Vehicle;

public interface VehicleService {

	List<Vehicle> getVehicles();
	
	Vehicle getVehicle(String vin);

	void saveVehicle(Vehicle car);
	
	void deleteVehicle(String vin);
	
	List<CustomerAccount> getCustomerAccounts();
	
	CustomerAccount getCustomerAccount(int id);

	void saveCustomerAccount(CustomerAccount account);
	
	void deleteCustomerAccount(int id);

}
