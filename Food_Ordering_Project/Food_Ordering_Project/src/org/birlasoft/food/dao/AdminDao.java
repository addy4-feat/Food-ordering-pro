package org.birlasoft.food.dao;

import java.sql.SQLException;
import java.util.List;

import org.birlasoft.food.exceptions.FoodException;
import org.birlasoft.food.model.Admin;
import org.birlasoft.food.model.Customer;
import org.birlasoft.food.model.Delivery;
import org.birlasoft.food.model.Food;
import org.birlasoft.food.model.Payment;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

public interface AdminDao {
	public boolean validAdmin(Admin admin) throws SQLException;
	
	public boolean addFood(Food af) throws SQLException, FoodException;
	public boolean isPresent(int Fid) throws SQLException;
	public int deleteFood(int Fid) throws SQLException;
	public Customer displayCustomer(int custid) throws SQLException;
	public List<Customer> displayCustomerAll() throws SQLException;
	public List<Food> displayFoodAll() throws SQLException;
	public Food displayFood(int fid) throws SQLException;
	public Order displayOrder(int oid) throws SQLException;
	public void displayOrderAll() throws SQLException ;
	public int deleteCustomer(int custid) throws SQLException;
	public int updatePrice(int fid,int fprice) throws SQLException;
	public int updateFName(int fid,String fname) throws SQLException;
	public List<Payment> checkpayment(int oid) throws SQLException;
	public int cancelorder(int oid) throws SQLException;
	//public void updateexpectedarrival(int oid) throws SQLException;
	//public void checkdelstatus(int delid) throws SQLException;
	public List<Delivery> displayDelivery() throws SQLException;
	public int updateArrTime(String time1,int oid) throws SQLException ;
	

}
