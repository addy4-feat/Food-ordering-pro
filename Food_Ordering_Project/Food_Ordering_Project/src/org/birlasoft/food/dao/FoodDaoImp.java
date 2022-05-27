package org.birlasoft.food.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.birlasoft.food.model.Cart;
import org.birlasoft.food.model.Order;


public class FoodDaoImp implements FoodDao {
	Connection con=Connect.createc();
	static Order ot=new Order();
	static Cart cm1=new Cart();
	
	public void menu() throws SQLException{
		   
    	System.out.println("\t\t\t\t\tONLINE FOOD ORDERING SYSTEM");
    	System.out.println("+=====================================================================================================================+");
        System.out.println("\t\t\t\t\t         MENU LIST       ");
        System.out.println("+=====================================================================================================================+");
    	System.out.println("  \t\t\t\t ITEM_ID\t\tITEM NAME\t\tITEM_PRICE\t\tITEM_AVAILABILITY");
    	
		Statement st=con.createStatement();
		  ResultSet rs=st.executeQuery("select *from foodtable");
		  while(rs.next()) {
			  int a=rs.getInt(1);
			  String b=rs.getString(2);
			  int c= rs.getInt(3);
			  String d= rs.getString(4);
			  
			  System.out.println("\t\t\t\t"+a+"\t\t\t"+b+"\t\t\t "+c+"\t\t\t\t"+d );
			  
	 }
      System.out.println("+=========================================================================================================================+");
    }
	
	
	
public boolean order(int cho) throws SQLException{
	
	Statement st=con.createStatement();
    ResultSet rs=st.executeQuery("select * from  foodtable where item_no="+cho);
     if(rs.next()) {
    String i_name = rs.getString(2);
    cm1.setChoose_foodname(i_name);
    int i_price=rs.getInt(3);
    cm1.setChoose_foodp(i_price);
    return true;
	}
else {
	return false;
	
	//order();
	
}}}



