package com.vehicleinventory.dao;

import java.util.List;

import com.vehicleinventory.entity.Vehicle;

public interface VehicleDAO {

	public void saveVehicle(Vehicle car);

	public List<Vehicle> getVehicles();

	public Vehicle getVehicle(String vin);

	public void deleteVehicle(String vin);

}
