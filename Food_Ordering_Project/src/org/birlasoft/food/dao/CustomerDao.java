package org.birlasoft.food.dao;

import java.sql.SQLException;

import org.birlasoft.food.model.Customer;

public interface CustomerDao {
	
	public void insertCustomer(Customer r) throws SQLException;
	public boolean validCustomer(Customer r) throws SQLException;
}
