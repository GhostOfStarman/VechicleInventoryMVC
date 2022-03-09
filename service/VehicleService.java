package com.vehicleinventory.service;

import java.util.List;

import com.vehicleinventory.entity.Vehicle;

public interface VehicleService {

	List<Vehicle> getVehicles();
	
	Vehicle getVehicle(String vin);

	void deleteVehicle(String vin);

	void saveVehicle(Vehicle car);

}
