package org.birlasoft.food.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.birlasoft.food.inventory.*;
import org.birlasoft.food.model.Customer;

public class CustomerDaoImp implements CustomerDao{

	public void insertCustomer(Customer r) throws SQLException
	{
	
		Connection con=Connect.createc();
		String sql= "insert into customer (username,address,phono,create_password)values (?,?,?,?);";
		PreparedStatement stmt =con.prepareStatement(sql);
	
		stmt.setString(1,r.getUsername());
	stmt.setString(2,r.getAddress());
		stmt.setLong(3,r.getPhono());
	stmt.setString(4,r.getCreate_password());
		stmt.execute();
		
	}
	
	public boolean validCustomer(Customer r)throws SQLException
	{
		boolean flag=false;
		Connection con=Connect.createc();
		 String q="select cust_id from customer where username=? and create_password=?";
		 PreparedStatement stmt =con.prepareStatement(q);
		 stmt.setString(1,r.getUsername());
		 stmt.setString(2,r.getCreate_password());
		 ResultSet rs=stmt.executeQuery();
		
		 if(rs.next())
		 {
			 return true;
		 }
		 else
		 {
			 return false;
		 }
	
	}

	
}
