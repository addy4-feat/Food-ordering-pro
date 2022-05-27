package org.birlasoft.food.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
     static Connection con; 
     public static Connection createc(){
    	 try {
    		 Class.forName("com.mysql.cj.jdbc.Driver");
    		 String user="root";
    		 String password="12345";
    		 String url="jdbc:mysql://localhost:3306/food_database";
    		 con =DriverManager.getConnection(url,user,password);
    	 }
    	 catch(Exception e) {
    		 e.printStackTrace();
    	 }
    	 
		return con;
	}
     //Connection con=Connect.createc();

}
