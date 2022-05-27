package org.birlasoft.food.dao;
import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import org.birlasoft.food.model.Order;

public class OrderDaoImp implements OrderDao {
	Connection con=Connect.createc();
	static Order ot=new Order();
	
	public void addOrder() throws SQLException {
		java.util.Date date=new java.util.Date();
	    java.sql.Date sqlDate=new java.sql.Date(date.getTime());
	    java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());
	    String sql= "insert into order_table (cust_id,food_id,order_date,order_time,food_qty)values (?,?,?,?,?);";
		PreparedStatement stmt =con.prepareStatement(sql);
		stmt.setInt(1,ot.getCust_id() );
		stmt.setInt(2,ot.getChoose_foodid());
		stmt.setDate(3,sqlDate);
		stmt.setTimestamp(4,sqlTime);
		stmt.setInt(5, ot.getChoose_foodqty());
	     stmt.executeUpdate();
		//System.out.println("order_details inserted");
		
		
	}
	
		
		
	public void getOrderId() throws SQLException {
		// TODO Auto-generated method stub
		java.util.Date date1=new java.util.Date();
		java.sql.Date sqlDate=new java.sql.Date(date1.getTime());
		PreparedStatement pstmt;
		pstmt = con.prepareStatement("select order_id from order_table where cust_id=? and order_date=?");
		pstmt.setInt(1,ot.getCust_id());
		pstmt.setDate(2,sqlDate);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			ot.setOrder_id(rs.getInt(1));
		}
		
		
	}
	
	public void delivery(String location,Time a) throws SQLException {
		
		@SuppressWarnings({ })
		String sql= "insert into delivery_table (delivery_location,expected_Arrival,order_id)values (?,?,?);";
		PreparedStatement stmt =con.prepareStatement(sql);
		stmt.setString(1,location);
		stmt.setTime(2,a);
		stmt.setInt(3,ot.getOrder_id());
		stmt.execute();
		}
	
	
public void payment(double pay) throws SQLException {
    	
    	
    	String sql= "insert into payment_table (paid_amount,order_id)values (?,?);";
    	PreparedStatement stmt =con.prepareStatement(sql);
    	stmt.setFloat(1,(float) pay);
    	stmt.setInt(2,ot.getOrder_id());
    	stmt.execute();
    	
         }


public boolean cancelOrder() throws SQLException {
	
	java.sql.Statement st=con.createStatement();
	
	ResultSet rs = st.executeQuery("select customer.username,order_table.order_id,order_table.cust_id,order_table.food_id,order_table.order_date,order_table.order_time,order_table.food_qty from customer, order_table where customer.cust_id=order_table.cust_id and customer.cust_id="+ot.getCust_id());
	if(rs.next()) {
	System.out.println("Items Selected for order");
	System.out.println("\t\tUSER_NAME\t\tORDER_ID\tCUST_ID\t\tFOOD_ID\t\tORDER_DATE\t\tORDER_TIME\t\tFOOD_QTY");
	
	do {
		  String g=rs.getString(1);
			int a=rs.getInt(2);
			int b=rs.getInt(3);
			int f=rs.getInt(4);
			String c=rs.getString(5);
			String d=rs.getString(6);
			int e=rs.getInt(7);
			System.out.println("\t\t"+g+"\t\t\t"+a+"\t\t"+b+"\t\t "+f+"\t\t"+c+"\t\t"+d+"\t\t"+e);
	 
	  }while(rs.next());
	System.out.println("+=========================================================================================================================+");
	return true;}
	else {
		return false;
	}
}
	
	
	
	//else {
		//System.out.println("You don't have Any order to cancel");
	//}
	
public boolean checkId(int od_id) throws SQLException {
	Connection con=Connect.createc();
	String q="select order_id from order_table where order_id=?";
	PreparedStatement pst=con.prepareStatement(q);
	pst.setInt(1,od_id);
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

public void removeOrder(int od_id) throws SQLException {
	//java.sql.Statement st=con.createStatement();
	
	  String sq1= "delete from  payment_table where order_id="+od_id;
		PreparedStatement stmt =con.prepareStatement(sq1);
		stmt.execute();
		
		String sq2= "delete from  delivery_table where order_id="+od_id;
		PreparedStatement stm1 =con.prepareStatement(sq2);
		stm1.execute();
	  
	  
	  
	String sql= "delete from  order_table where order_id="+od_id;
	PreparedStatement stmt2 =con.prepareStatement(sql);
	stmt2.execute();
	
}


}
	
	
	

