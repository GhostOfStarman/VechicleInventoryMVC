package com.vehicleinventory.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicleinventory.dao.CustomerAccountDAO;
import com.vehicleinventory.dao.FinanceRecordDAO;
import com.vehicleinventory.dao.VehicleDAO;
import com.vehicleinventory.entity.CustomerAccount;
import com.vehicleinventory.entity.Vehicle;

@Service
public class VehicleServiceImp implements VehicleService{
	
	@Autowired
	VehicleDAO vehicleDAO;
	@Autowired
	CustomerAccountDAO customerAccountDAO;
	@Autowired
	FinanceRecordDAO financeRecordDAO;
	
	// ----------------------------------------------------------------------------------- >
	@Override
	@Transactional
	public List<Vehicle> getVehicles(){
		return vehicleDAO.getVehicles();
	}

	@Override
	@Transactional
	public Vehicle getVehicle(String vin) {
		return vehicleDAO.getVehicle(vin);
	}
	
	@Override
	@Transactional
	public void saveVehicle(Vehicle car) {
		vehicleDAO.saveVehicle(car);
	}
	

	@Override
	@Transactional
	public void deleteVehicle(String vin) {
		vehicleDAO.deleteVehicle(vin);
	}
	
	// ----------------------------------------------------------------------------------- >
	@Override
	@Transactional
	public List<CustomerAccount> getCustomerAccounts() {
		return customerAccountDAO.getCustomerAccounts();
	}

	@Override
	@Transactional
	public CustomerAccount getCustomerAccount(int id) {
		return customerAccountDAO.getCustomerAccount(id);
	}

	@Override
	@Transactional
	public void saveCustomerAccount(CustomerAccount account) {
		customerAccountDAO.saveCustomerAccount(account);
		
	}

	@Override
	@Transactional
	public void deleteCustomerAccount(int id) {
		customerAccountDAO.deleteCustomerAccount(id);
		
	}
	
	// ----------------------------------------------------------------------------------- >
	
}
