package com.vehicleinventory.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicleinventory.dao.VehicleDAO;
import com.vehicleinventory.entity.Vehicle;

@Service
public class VehicleServiceImp implements VehicleService{
	
	@Autowired
	VehicleDAO vehicleDAO;
	
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
	
}
