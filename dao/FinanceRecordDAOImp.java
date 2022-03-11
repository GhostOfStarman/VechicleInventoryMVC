package com.vehicleinventory.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vehicleinventory.entity.FinanceRecord;

@Repository
public class FinanceRecordDAOImp implements FinanceRecordDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<FinanceRecord> getFinanceRecords() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<FinanceRecord> theQuery = currentSession.createQuery("from FinanceRecord order by financeId", FinanceRecord.class);
		List<FinanceRecord> FinanceRecords = theQuery.getResultList();
				
		return FinanceRecords;
	}
	
	@Override
	public void saveFinanceRecord(FinanceRecord record) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(record);
	}


	@Override
	public FinanceRecord getFinanceRecord(int finId) {
		Session currentSession = sessionFactory.getCurrentSession();
		FinanceRecord car = currentSession.get(FinanceRecord.class, finId);
		
		return car;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public void deleteFinanceRecord(int finId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query carQuery = currentSession.createQuery("delete from FinanceRecords where id=:finID");
		carQuery.setParameter("finID", finId);
		carQuery.executeUpdate();		
	}
}
