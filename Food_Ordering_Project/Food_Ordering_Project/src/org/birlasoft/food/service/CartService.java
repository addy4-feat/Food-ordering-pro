package org.birlasoft.food.service;

import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;

import org.birlasoft.food.dao.*;
import org.birlasoft.food.model.*;

public class CartService {
	static Login l= new Login();
	static FoodDaoImp fd=new FoodDaoImp();
	static LoginDaoImp ld=new LoginDaoImp();
	static Order ot=new Order();
	static Cart cm=new Cart();
	static OrderDaoImp otdi=new OrderDaoImp();
	static OrderService os=new OrderService();
	static CartDaoImp cd=new CartDaoImp();
	static Scanner se=new Scanner(System.in);
	public static double total=0,pay;
	
	@SuppressWarnings("static-access")
	public void startPage() throws ClassNotFoundException, SQLException {
		System.out.println("\n\n*choose 1 to order:\n*choose 2 to cancel order:\n*choose 3 to Display cart");
		int opt1 = se.nextInt();

	      switch(opt1) {
	    	  case 1:
	    		  fd.menu();
			      os.order1();
			 //fo.payment();
			 break;
	    	 
	    	  case 2:
	    		  os.cancelOrder1();
	    		  startPage();
	    		  break;
	    	  case 3:
	    		  displayCart1();
	    		  //Startpage();
	    		 
	    		  break;
	              
	         default:
	        	 System.out.println("Please Enter Correct Number to Choose");
	        	 startPage();}
	}
	
	
	
	public void cartOperation() throws SQLException, ClassNotFoundException {
		
		System.out.println("\n+=====================================================================================================================+\n");
		System.out.println(" 1.Order");
		System.out.println(" 2.Update Quantity");
		System.out.println(" 3.Delete Item: ");
		System.out.println("\n\nEnter Number to perform Above Operation: ");
		int num=se.nextInt();
		switch(num) {
		case 1:
			cd.orderCartItems();
			deliveryCart1();
			cartPayment1();
			
			break;
		 case 2:
			  quantityUpdate1();

			  break;
		case 3:
			deleteCartItem1();
			break;
		default:
	   	 System.out.println("Please Enter Correct Number to Choose");
	   	cartOperation();
		}
		
	}
	
	
public void deliveryCart1() throws SQLException {
	Time a=null;
	System.out.println("Enter Delivery location");
    String location=se.next();
    boolean dd=cd.deliveryCart(location,a);
    if(dd)
    {//System.out.println("Delivery location done");
    }
    else {
    	System.out.println("Enter location Again");
    	deliveryCart1();
    }
}

public static void cartPayment1() throws SQLException, ClassNotFoundException {
	@SuppressWarnings("rawtypes")
	ArrayList  EE= new ArrayList();
	@SuppressWarnings("rawtypes")
	ArrayList  FF= new ArrayList();
	EE=cd.cartPayment();
	FF=cd.cartPayment();
	for(int j=0;j<EE.size();j++) {
		total=total+(int) EE.get(j);
	}
  System.out.println("Total price is " + total);
    System.out.println("Enter a payment ");
    pay = se.nextDouble();
    if(pay==total) {
    cd.paymentInsert(EE,FF);
     System.out.println("Payment Successful");
    System.out.println("Thank you for your order");
    total=0;
    cd.deleteOrderCart();
    total=0;
   }
    else {
    	System.out.println("========Not enough payment===========");
}}
	

public void deleteCartItem1() throws SQLException, ClassNotFoundException {
	System.out.println("ENTER ITEMID WHICH YOU WANT TO REMOVE FROM CART :");
	int item=se.nextInt();
	boolean che=cd.check_item(item);
	if(che) {
	cd.deleteCartItem(item);
	cd.displayCart();
	cartOperation();}
	else {
		System.out.println("Item Not present");
	}
}

public void quantityUpdate1() throws SQLException, ClassNotFoundException {
	System.out.println("Enter Food Id Whcih You Want Update: ");
	int fid1=se.nextInt();
	if(fid1>0) {
		System.out.println("Enter How Much quantity you want to add More: ");
		int quantity=se.nextInt();
		if(quantity>0) {
			cd.quantityUpdate(fid1,quantity);
			System .out.println("Record updated scuccessfully");
			cd.displayCart();
			cartOperation();
		}
		else {
			System.out.println("Enter valid Quantity");
			quantityUpdate1();
		}
}else {
	System.out.println("Enter valid Food_id");
	quantityUpdate1();
}
}

public void displayCart1() throws SQLException, ClassNotFoundException {
	boolean di=cd.displayCart();
	if(di) {
		cartOperation();
	}
	else {
	System.out.println("Cart Is Empty");
	startPage();
}
}

public void checkCart1() throws SQLException {
	boolean ck=cd.checkCart();
	if(!ck) {
		cd.addCart();
	}
}




}

