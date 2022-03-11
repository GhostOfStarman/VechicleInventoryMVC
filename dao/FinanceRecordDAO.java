package com.vehicleinventory.dao;

import java.util.List;

import com.vehicleinventory.entity.FinanceRecord;

public interface FinanceRecordDAO {
		
	public void saveFinanceRecord(FinanceRecord record);

	public List<FinanceRecord> getFinanceRecords();

	public FinanceRecord getFinanceRecord(int finId);

	public void deleteFinanceRecord(int finId);

}
