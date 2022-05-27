package org.birlasoft.food.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.birlasoft.food.exceptions.FoodException;
import org.birlasoft.food.inventory.Mainclass;
import org.birlasoft.food.model.Admin;
import org.birlasoft.food.model.Customer;
import org.birlasoft.food.model.Delivery;
import org.birlasoft.food.model.Food;
import org.birlasoft.food.model.Payment;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import com.mysql.cj.xdevapi.Statement;

public class AdminDaoImp implements AdminDao {
	
	public boolean validAdmin(Admin admin) throws SQLException
	{
		Connection con=Connect.createc();
		String q="select admin_id from admin where username=? and password=?";
		PreparedStatement pst=con.prepareStatement(q);
		pst.setString(1,admin.getUsername());
		pst.setString(2,admin.getPassword());
		ResultSet set=pst.executeQuery();
		if(set.next())
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	//for adding the food
	public boolean addFood(Food af) throws SQLException, FoodException
	{
		Connection con=Connect.createc();
		boolean flag;
		try {
			String q="insert into foodtable(item_name,item_price,item_avail) values(?,?,?)";
			PreparedStatement pst=con.prepareStatement(q);
			pst.setString(1,af.getfName());
			pst.setInt(2,af.getfPrice());
			pst.setString(3,af.getfAval());
			flag=pst.execute();
			System.out.println(flag);
			return flag;
			//		System.out.println("Successfully added the item to the food table");
			//		}

		}catch(Exception e)
		{
			throw new FoodException("Data already exists");
		}
	}	
	public boolean isPresent(int Fid) throws SQLException
	{
		Connection con=Connect.createc();
		String q="Select * from foodtable where item_no=?";
		PreparedStatement pst=con.prepareStatement(q);
		pst.setInt(1,Fid);
		ResultSet set=pst.executeQuery();
		if(set.next())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//for deleting the food
	public int deleteFood(int Fid) throws SQLException
	{
		int records=0;
		Connection con=Connect.createc();
		String q="delete from foodtable where item_no=?";
		PreparedStatement pst=con.prepareStatement(q);
		pst.setInt(1,Fid);
		records=pst.executeUpdate();
		return records;
	}
	public Food displayFood(int fid) throws SQLException
	{
		Connection con=Connect.createc();
		String q="select * from foodtable where item_no=?";
		PreparedStatement pst=con.prepareStatement(q);
		pst.setInt(1,fid);
		ResultSet set=pst.executeQuery();
		if(set.next())
		{
			Food fobj=new Food(set.getInt(1),set.getString(2),set.getInt(3),set.getString(4));
			return fobj;
		}
		else
		{
			System.out.println("Invalid Food id");
			System.out.println("Please enter your choice from the above list\n");
		}
		return null;
	}
	public List<Food> displayFoodAll() throws SQLException
	{
		Connection con=Connect.createc();
		List<Food>flist=new ArrayList<Food>();
		String q="select * from Foodtable";
		PreparedStatement pst=con.prepareStatement(q);
		ResultSet set=pst.executeQuery();
		if(set.isBeforeFirst())
		{
		while(set.next())
		{
			Food fobj=new Food(set.getInt(1),set.getString(2),set.getInt(3),set.getString(4));
			flist.add(fobj);
		}
		//System.out.println("Please enter your choice from the above list");
	
		}
		return flist;
//		}
//		else
//		{
//			System.out.println("Empty records");
//			System.out.println("Please enter your choice from the above list");
//		}
//		return null;
	}
	
	//for displaying customer details
	public Customer displayCustomer(int custid) throws SQLException
	{
		Connection con=Connect.createc();
		String q="select * from customer where cust_id=?";
		PreparedStatement pst=con.prepareStatement(q);
		pst.setInt(1, custid);
		ResultSet set=pst.executeQuery();
		if(set.next())
		{
		Customer cust=new Customer(set.getInt(1),set.getString(2),set.getString(3),+set.getLong(4),set.getString(5));
		return cust;
		}
		else
		{
			return null;
		}
		
		
	}
	
	public List<Customer> displayCustomerAll() throws SQLException
	{
		List<Customer>list=new ArrayList<Customer>();
		Connection con=Connect.createc();
		String q="select * from customer";
		PreparedStatement pst=con.prepareStatement(q);
		ResultSet set=pst.executeQuery();
		while(set.next())
		{
			Customer cust=new Customer(set.getInt(1),set.getString(2),set.getString(3),+set.getLong(4),set.getString(5));
			list.add(cust);
		}
		return list;
	}
	//for displaying Order detail
	public Order displayOrder(int oid) throws SQLException {//not completed
		Connection con=Connect.createc();
		PreparedStatement pst=con.prepareStatement("select * from Order_table where order_id=?");
		pst.setInt(1, oid);
		ResultSet rs=pst.executeQuery();
		if(rs.next())
		{
//			System.out.println("Order_id\tCust_Id\t\tFood_Id\t\tOrder_Date\tOrde_Time\tFood_qty");
//			System.out.println("----------------------------------------------------------------------------------");
//			System.out.println(rs.getInt(1)+"\t\t"+rs.getInt(2)+"\t\t"+rs.getInt(3)+"\t\t"+rs.getDate(4)+"\t"+rs.getTime(5)+"\t"+rs.getInt(6));
//			System.out.println("----------------------------------------------------------------------------------------------------------");
			//Order or=new Order(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getDate(4),rs.getTime(5),rs.getInt(6));
			System.out.println("Please enter your choice from the above list\n");
		}
		else
		{
			System.out.println("Invalid Order id");
			System.out.println("Please enter your choice from the above list\n");
		
		}
		return null;
		
	}
	
	public void displayOrderAll() throws SQLException {///not completed
		Connection con=Connect.createc();
		String q="select * from Order_table";
		PreparedStatement pst=con.prepareStatement(q);
		ResultSet rs=pst.executeQuery();
		System.out.println("Order_id\tCust_Id\t\tFood_Id\t\tOrder_Date\tOrde_Time\tFood_qty");
		System.out.println("----------------------------------------------------------------------------------");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"\t\t"+rs.getInt(2)+"\t\t"+rs.getInt(3)+"\t\t"+rs.getDate(4)+"\t"+rs.getTime(5)+"\t"+rs.getInt(6));
			System.out.println("----------------------------------------------------------------------------------------------------------");

		}
		System.out.println("Please enter your choice from the above list\n");

		
	}
	
	public int updatePrice(int fid,int fprice) throws SQLException
	{
		int record=0;
		Connection con=Connect.createc();
		String q="update foodtable set item_price=? where item_no=?";
		PreparedStatement pst=con.prepareStatement(q);
		pst.setInt(1, fprice);
		pst.setInt(2, fid);
		record=pst.executeUpdate();
		return record;
	}
		
	
	public List<Payment> checkpayment(int oid) throws SQLException {//?????
		List<Payment>plist=new ArrayList<Payment>();
		Connection con=Connect.createc();
		String q="select * from payment_table where order_id=?";
		PreparedStatement pst=con.prepareStatement(q);
		pst.setInt(1, oid);
		ResultSet rs=pst.executeQuery();
		if(rs.next())
		{
		Payment pobj=new Payment(rs.getInt(1),rs.getInt(2),rs.getInt(3));
		plist.add(pobj);
		System.out.println("Found");
		//System.out.println("Please enter your choice from the above list\n");
		}
		return plist;
	}
//		}
//		else
//		{
//			System.out.println("Invalid Order id");
//			System.out.println("Please enter your choice from the above list\n");
//		
//		}
//		return null;
		
	//}
	
public List<Delivery> displayDelivery() throws SQLException
	{
		Connection con=Connect.createc();
		List<Delivery>list1=new ArrayList<Delivery>();
		String q="select delivery_table.del_id,delivery_table.delivery_location,delivery_table.expected_arrival,delivery_table.order_id,order_table.order_time from order_table inner join delivery_table on order_table.order_id=delivery_table.order_id group by delivery_table.del_id;";
		PreparedStatement pst1=con.prepareStatement(q);
		ResultSet rs=pst1.executeQuery();
		while(rs.next()) {
			Delivery dlist=new Delivery(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5));	
			list1.add(dlist);
		}
		return list1;
}
		
public int updateArrTime(String time1,int oid) throws SQLException {
		int record=0;
		Connection con=Connect.createc();
		Time time = new Time(00-00-00);		         
		String q="update Delivery_table set expected_Arrival = ? where order_id=?";
		PreparedStatement pst=con.prepareStatement(q);
		pst.setTime(1,time.valueOf(time1));
		pst.setInt(2,oid);
		record=pst.executeUpdate();
		return record;
	}

public int updateFName(int fid,String fname) throws SQLException
{
	int row=0;
	Connection con=Connect.createc();
	String q="update foodtable set item_name=? where item_no=?";
	PreparedStatement pst=con.prepareStatement(q);
	pst.setString(1,fname);
	pst.setInt(2, fid);
	row=pst.executeUpdate();	
	return row;
}
public int deleteCustomer(int custid) throws SQLException
{
	int row=0;
	Connection con=Connect.createc();
	String q="delete from customer where cust_id=?";
	PreparedStatement pst=con.prepareStatement(q);
	pst.setInt(1,custid);
	row=pst.executeUpdate();
	return row;	
}

public int cancelorder(int oid) throws SQLException
{
	int row=0;
	Connection con=Connect.createc();
	String k="delete from order_table where order_id=?";
	PreparedStatement pst=con.prepareStatement(k);
	pst.setInt(1,oid);
	row=pst.executeUpdate();
	return row;
	
}


}
	


