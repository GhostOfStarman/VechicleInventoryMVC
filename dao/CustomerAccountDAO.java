package com.vehicleinventory.dao;

import java.util.List;

import com.vehicleinventory.entity.CustomerAccount;
import com.vehicleinventory.entity.FinanceRecord;

public interface CustomerAccountDAO {
	
	public void saveCustomerAccount(CustomerAccount account);

	public List<CustomerAccount> getCustomerAccounts();

	public CustomerAccount getCustomerAccount(int custId);

	public void deleteCustomerAccount(int custId);

	List<FinanceRecord> getFinancedVehicles(int id);
}
