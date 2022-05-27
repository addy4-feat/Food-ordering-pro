package org.birlasoft.food.dao;

import java.sql.SQLException;

public interface OrderDao {
	 public void addOrder() throws SQLException;
	   public void getOrderId() throws SQLException;
	   public boolean cancelOrder() throws SQLException;
	   public void removeOrder(int od_id) throws SQLException;
	   public boolean checkId(int od_id) throws SQLException;
}
