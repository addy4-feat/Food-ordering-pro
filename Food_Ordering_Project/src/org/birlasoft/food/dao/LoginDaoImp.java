package org.birlasoft.food.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.birlasoft.food.inventory.Mainclass;
import org.birlasoft.food.model.Login;

/*import org.birlasoft.food.inventory.Cartt;
import org.birlasoft.food.inventory.Conect;
import org.birlasoft.food.inventory.Food_OrderingSystem;
import org.birlasoft.food.inventory.login;
import org.birlasoft.food.inventory.order_table;*/

public class LoginDaoImp implements LoginDao{
	
	public boolean validLogin(Login l) throws SQLException
	{
		boolean flag=false;
		Connection con=Connect.createc();
		String q="select cust_id from customer where username=? and create_password=?";
		PreparedStatement pst=con.prepareStatement(q);
		pst.setString(1,l.getUsername());
		pst.setString(2,l.getPassword());
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
	public int custId(Login l) throws SQLException
	{
		int id = 0;
		Connection con=Connect.createc();
		String q="select cust_id from customer where username=? and create_password=?";
		PreparedStatement pst=con.prepareStatement(q);
		pst.setString(1,l.getUsername());
		pst.setString(2,l.getPassword());
		ResultSet rs=pst.executeQuery();
		if(rs.next())
		{
			id=rs.getInt(1);
		}
		return id;
		
	}
	
	
	
	

}
