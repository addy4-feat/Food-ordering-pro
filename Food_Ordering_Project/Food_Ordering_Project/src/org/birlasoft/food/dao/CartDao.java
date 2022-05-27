package org.birlasoft.food.dao;


import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

public interface CartDao {
	public boolean displayCart() throws SQLException;
	public boolean checkCart() throws SQLException;
	public void addCart() throws SQLException;
	public void orderCartItems() throws SQLException, ClassNotFoundException;
	public void deleteOrderCart() throws SQLException, ClassNotFoundException;
	public boolean deliveryCart(String location,Time a) throws SQLException;
	@SuppressWarnings("rawtypes")
	public ArrayList cartPayment() throws SQLException ;
	@SuppressWarnings("rawtypes")
	public ArrayList cartPayment2() throws SQLException;
	public void paymentInsert(@SuppressWarnings("rawtypes") ArrayList BB,@SuppressWarnings("rawtypes") ArrayList CC) throws SQLException ;
	public void quantityUpdate(int fid1,int quantity) throws SQLException, ClassNotFoundException;
	public void deleteCartItem(int item) throws SQLException;
}
