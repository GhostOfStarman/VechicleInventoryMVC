package com.vehicleinventory.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vehicleinventory.entity.Vehicle;

@Repository
public class VehicleDAOImp implements VehicleDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	// READ list
	@Override
	public List<Vehicle> getVehicles() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Vehicle> theQuery = currentSession.createQuery("from Vehicle order by year", Vehicle.class);
		List<Vehicle> Vehicles = theQuery.getResultList();
				
		return Vehicles;
	}
	
	// CREATE/UPDATE
	@Override
	public void saveVehicle(Vehicle car) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(car);
	}

	
	// READ single
	@Override
	public Vehicle getVehicle(String vin) {
		Session currentSession = sessionFactory.getCurrentSession();
		Vehicle car = currentSession.get(Vehicle.class, vin);
		
		return car;
	}
	
	// DELETE
	@SuppressWarnings("rawtypes")
	@Override
	public void deleteVehicle(String vin) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query carQuery = currentSession.createQuery("delete from Vehicle where id=:vin");
		carQuery.setParameter("vin", vin);
		carQuery.executeUpdate();		
	}
}






