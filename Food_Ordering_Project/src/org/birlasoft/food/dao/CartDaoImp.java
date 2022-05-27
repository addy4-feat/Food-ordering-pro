package org.birlasoft.food.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import org.birlasoft.food.model.*;
import org.birlasoft.food.service.CartService;
import org.birlasoft.food.service.OrderService;


public class CartDaoImp implements CartDao {
	Connection con=Connect.createc();
	
	static Login l= new Login();
	static FoodDaoImp fd=new FoodDaoImp();
	static LoginDaoImp ld=new LoginDaoImp();
	static Order ot=new Order();
	static Cart cm=new Cart();
	static OrderDaoImp otdi=new OrderDaoImp();
	static OrderService os=new OrderService();
	static CartService cs=new CartService();
	
	
	
public boolean displayCart() throws SQLException {
		PreparedStatement pstmt;
		pstmt = con.prepareStatement("select *from cart1_table where cart_id=?");
		pstmt.setInt(1,cm.getCust_id()+1000);
		ResultSet rs = pstmt.executeQuery(); 
	if(rs.next()) {
		System.out.println("\t\t\t\t\t         Customer Cart       ");
		System.out.println("+=====================================================================================================================+");
		System.out.println("\t\t\t ITEM_ID\t\tITEM NAME\t\tITEM_QUANTITY\t\tITEM_PRICE");
		
		
		  do {
			  int a=rs.getInt(3);
			  String b=rs.getString(4);
			  int c= rs.getInt(5);
			  int d= rs.getInt(6);
			  
			  System.out.println("\t\t\t"+a+"\t\t\t"+b+"\t\t\t "+c+"\t\t\t"+d);
		
		  }while(rs.next());
		  return true;
		 }
	else {
		return false;
		
	}
		
	}
	
public boolean checkCart() throws SQLException {
	
	PreparedStatement pstmt;
	pstmt = con.prepareStatement("select *from cart1_table where cart_id=? and food_id=?");
	pstmt.setInt(1,cm.getCust_id()+1000);
	pstmt.setInt(2,cm.getChoose_foodid());
	ResultSet rs = pstmt.executeQuery(); 
	if(rs.next()) {
        int aa=rs.getInt(5);
        int bb=rs.getInt(6);
		PreparedStatement pstmt2;
		pstmt2 = con.prepareStatement("update cart1_table set food_quantity=?,food_price=? where cart_id=? and food_id=?");
		pstmt2.setInt(1,aa+cm.getChoose_foodqty());
		pstmt2.setInt(2,bb+(cm.getChoose_foodp()*cm.getChoose_foodqty()));
		pstmt2.setInt(3,cm.getCust_id()+1000);
		pstmt2.setInt(4,cm.getChoose_foodid());
		pstmt2.executeUpdate();
      return true;
		
	}
	else {
		return false;
	}
	
}

public void addCart() throws SQLException {
	
    //a=getCust_id()+1000;
   
    
    ArrayList<Cart> cartarr = new ArrayList<Cart>();
    Cart c1=new Cart(cm.getCust_id(),cm.getChoose_foodid(),cm.getChoose_foodname(),cm.getChoose_foodqty(),cm.getChoose_foodp());
    cartarr.add(c1);
    Connection con=Connect.createc();
	String sql= "insert into cart1_table (cust_id,cart_id,food_id,food_name,food_quantity,Food_price)values (?,?,?,?,?,?);";
	PreparedStatement stmt =con.prepareStatement(sql);
	for(int i=0;i<cartarr.size();i++) {
	stmt.setInt(1,cartarr.get(i).getCust_id());
	stmt.setInt(2,cartarr.get(i).getCust_id()+1000);
	stmt.setInt(3,cartarr.get(i).getChoose_foodid());
	stmt.setString(4,cartarr.get(i).getChoose_foodname());
	stmt.setInt(5, cartarr.get(i).getChoose_foodqty());
	stmt.setInt(6,cartarr.get(i).getChoose_foodp()*cm.getChoose_foodqty());
	
	
	stmt.execute();}
	
	}





public void orderCartItems() throws SQLException, ClassNotFoundException {
	   
	 //To fetch data from cart table 
	 ArrayList<Cart> corder = new ArrayList<Cart>();
	 java.util.Date date1=new java.util.Date();
		java.sql.Date sqlDate=new java.sql.Date(date1.getTime());
		java.sql.Timestamp sqlTime=new java.sql.Timestamp(date1.getTime());
		PreparedStatement pstmt;
		pstmt = con.prepareStatement(
				  "select *from cart1_table where cart_id=?");
		pstmt.setInt(1,cm.getCust_id()+1000);
		ResultSet rs = pstmt.executeQuery(); 
	
		  while(rs.next()) {
			  int a=rs.getInt(1);
			  int c= rs.getInt(3);
			  int d= rs.getInt(5);
			  Cart ca=new Cart(a,c,d);
			  corder.add(ca);
			  
			  
			  }
		  //order from the cart
		  
		  
		  String sql12= "insert into order_table (cust_id,food_id,order_date,Order_time,food_qty)values (?,?,?,?,?);";
			PreparedStatement stmt =con.prepareStatement(sql12);
			for(int i=0;i<corder.size();i++) {
			stmt.setInt(1,corder.get(i).cuid);
			stmt.setInt(2,corder.get(i).ffid);
			stmt.setDate(3,sqlDate);
			stmt.setTimestamp(4,sqlTime);
			stmt.setInt(5,corder.get(i).ffq);
			stmt.execute();
			}
			//System.out.println("order inserted");
			
			
		  
	 
}
public void deleteOrderCart() throws SQLException, ClassNotFoundException {
	String q1="delete  from cart1_table where cust_id=?";
	PreparedStatement pst=con.prepareStatement(q1);
	pst.setInt(1,cm.getCust_id());
	pst.executeUpdate();
	cs.startPage();
	
}

public void getcartorderid() throws SQLException {
	java.util.Date date1=new java.util.Date();
	java.sql.Date sqlDate=new java.sql.Date(date1.getTime());
	PreparedStatement pstmt;
	pstmt = con.prepareStatement("select order_id from order_table where cust_id=? and order_date=?");
	pstmt.setInt(1,cm.getCust_id());
	pstmt.setDate(2,sqlDate);
	ResultSet rs = pstmt.executeQuery();
	while(rs.next()) {
		
	}
	
}
@SuppressWarnings("unchecked")
public boolean deliveryCart(String location,Time a) throws SQLException {
	@SuppressWarnings("rawtypes")
	ArrayList  AA= new ArrayList();
	java.util.Date date1=new java.util.Date();
	java.sql.Date sqlDate=new java.sql.Date(date1.getTime());
	PreparedStatement pstmt;
	pstmt = con.prepareStatement("select order_id from order_table where cust_id=? and order_date=?");
	pstmt.setInt(1,cm.getCust_id());
	pstmt.setDate(2,sqlDate);
	ResultSet rs = pstmt.executeQuery();
	while(rs.next()) {
		AA.add(rs.getInt(1));
	}
	
	@SuppressWarnings("rawtypes")
	ArrayList DD=new ArrayList();
	pstmt = con.prepareStatement("select Food_price from cart1_table where cust_id=?");
	pstmt.setInt(1,cm.getCust_id());
	//pstmt.setDate(2,sqlDate);
	
	ResultSet rs2 = pstmt.executeQuery();
	while(rs2.next()) {
		DD.add(rs2.getInt(1));
		
	}

	
	
	
	String sql= "insert into delivery_table (delivery_location,expected_Arrival,order_id)values (?,?,?);";
	PreparedStatement stmt =con.prepareStatement(sql);
	
	//stmt.setLong(3,expected_arriv);
	for(int i=0;i<DD.size();i++) {
	stmt.setString(1,location);
	stmt.setTime(2,a);
	stmt.setInt(3,(int) AA.remove(AA.size()-1));
	
	stmt.execute();}
	return true;
	}

@SuppressWarnings({ "unchecked", "rawtypes" })
public ArrayList cartPayment() throws SQLException {
	ArrayList  BB= new ArrayList();
	PreparedStatement pstmt;
	pstmt = con.prepareStatement("select Food_price from cart1_table where cust_id=?");
	pstmt.setInt(1,cm.getCust_id());
	ResultSet rs = pstmt.executeQuery();
	while(rs.next()) {
		BB.add(rs.getInt(1));
		
	}
return BB;	
}
	
	
@SuppressWarnings({ "unchecked", "rawtypes" })
public ArrayList cartPayment2() throws SQLException	{
	ArrayList  CC= new ArrayList();
	PreparedStatement pstmt;
	java.util.Date date1=new java.util.Date();
	java.sql.Date sqlDate=new java.sql.Date(date1.getTime());
	pstmt = con.prepareStatement("select order_id from order_table where cust_id=? and order_date=?");
	pstmt.setInt(1,cm.getCust_id());
	pstmt.setDate(2,sqlDate);
	
	ResultSet rs1 = pstmt.executeQuery();
	while(rs1.next()) {
		CC.add(rs1.getInt(1));
		
	}
	return CC;}

@SuppressWarnings("rawtypes")
public void paymentInsert(ArrayList BB,ArrayList CC) throws SQLException {
	String sql= "insert into payment_table (paid_amount,order_id)values (?,?);";
	PreparedStatement stmt =con.prepareStatement(sql);
	for(int i=0;i<BB.size();i++) {
	stmt.setInt(1,(int)BB.get(i));
	stmt.setInt(2,(int) CC.remove(CC.size()-1));
	stmt.execute();}
}

public void quantityUpdate(int fid1,int quantity) throws SQLException, ClassNotFoundException {
	
			Connection con=Connect.createc();
			PreparedStatement pstmt;
			pstmt = con.prepareStatement("select Food_quantity from cart1_table where cart_id=? and food_id=?");
			pstmt.setInt(1,cm.getCust_id()+1000);
			pstmt.setInt(2,fid1);
			ResultSet rs = pstmt.executeQuery(); 
			rs.next();
				  int c1= rs.getInt(1);
				 
				  
		
	          PreparedStatement pstmt1;
	         pstmt1 = con.prepareStatement("select * from foodtable where item_no=?");
					pstmt1.setInt(1,fid1);
					ResultSet rs1 = pstmt1.executeQuery();
					rs1.next();
					int p=rs1.getInt(3);
					
				  
					

			          PreparedStatement pstmt2;
			         pstmt2 = con.prepareStatement("update cart1_table set food_quantity=?,food_price=? where cart_id=? and food_id=?");
			                pstmt2.setInt(1,quantity+c1);
			                pstmt2.setInt(2,(quantity+c1)*p);
			                pstmt2.setInt(3,cm.getCust_id()+1000);
							pstmt2.setInt(4,fid1);
							pstmt2.executeUpdate();
							
	
	}



public boolean check_item(int item) throws SQLException {
	
	PreparedStatement pstmt;
	pstmt = con.prepareStatement("select *from cart1_table where cart_id=? and food_id=?");
	pstmt.setInt(1,cm.getCust_id()+1000);
	pstmt.setInt(2,item);
	ResultSet rs = pstmt.executeQuery(); 
	if(rs.next()) {
      return true;
		
	}
	else {
		return false;
	}
	
}

public void deleteCartItem(int item) throws SQLException {
	
	
	
		String q="delete  from cart1_table where food_id=? and cust_id=?";
		PreparedStatement pst=con.prepareStatement(q);
		pst.setInt(1,item);
		pst.setInt(2,cm.getCust_id());
		pst.executeUpdate();
		System.out.println("Item Removed ");
	
	
}


	
	
}
