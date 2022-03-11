package com.vehicleinventory.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vehicleinventory.entity.CustomerAccount;


@Repository
public class CustomerAccountDAOImp implements CustomerAccountDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<CustomerAccount> getCustomerAccounts() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<CustomerAccount> theQuery = currentSession.createQuery("from CustomerAccount order by lastName", CustomerAccount.class);
		List<CustomerAccount> CustomerAccounts = theQuery.getResultList();
				
		return CustomerAccounts;
	}
	
	@Override
	public void saveCustomerAccount(CustomerAccount account) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(account);
	}

	
	@Override
	public CustomerAccount getCustomerAccount(int custId) {
		Session currentSession = sessionFactory.getCurrentSession();
		CustomerAccount car = currentSession.get(CustomerAccount.class, custId);
		
		return car;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public void deleteCustomerAccount(int custId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query carQuery = currentSession.createQuery("delete from CustomerAccounts where id=:custId");
		carQuery.setParameter("custId", custId);
		carQuery.executeUpdate();		
	}
}
