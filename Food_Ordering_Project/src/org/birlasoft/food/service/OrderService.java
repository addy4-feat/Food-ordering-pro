package org.birlasoft.food.service;

import java.sql.SQLException;
import java.sql.Time;
import java.util.Scanner;

import org.birlasoft.food.dao.*;
import org.birlasoft.food.model.*;


public class OrderService {
	
	static Login l= new Login();
	static FoodDaoImp fd=new FoodDaoImp();
	static LoginDaoImp ld=new LoginDaoImp();
	static Order ot=new Order();
	static Cart cm=new Cart();
	static OrderDaoImp otdi=new OrderDaoImp();
	static CartService cs=new CartService();
	static Scanner sc1=new Scanner(System.in);
	static CartDaoImp cd=new CartDaoImp();
	
	public static String more;
    public static String acart;
    static int count=0;
    public static int choose,quantity=1;
    public static double total=0,pay;
	
	
	
	public void order1() throws SQLException, ClassNotFoundException{
    	
	    System.out.print("ENTER ITEM_NO TO CHOOSE :");
	    choose = sc1.nextInt();
	    try {
			try {
				ot.setChoose_foodid(choose);
				cm.setChoose_foodid(choose);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	    boolean l=fd.order(choose);
	    if(l)
	    {
	    		System.out.println("You choose : "+cm.getChoose_foodname());
	    System.out.print("How much quantity you want to Buy? :");
	    quantity =sc1.nextInt();
	    ot.setChoose_foodqty(quantity);
	    cm.setChoose_foodqty(quantity);
	    
	   
	    
	   if(quantity>0) {
	    total = total +(quantity*cm.getChoose_foodp());
	    if(count==0) {
	    System.out.println("\n*press 1 to order \n*press 2 for add to cart  :");
	    @SuppressWarnings({ "resource" })
		Scanner sc=new Scanner(System.in);
	    int  opt = sc.nextInt();
	    //or.setGet_opt(opt);
	    switch(opt){
	      case 1:
	    	  otdi.addOrder();
	   	      otdi.getOrderId();
	   	      delivery1();
	   	      payment1();
	   	   cs.startPage();
	   	   count=0;
	   	   break;
	      case 2:
	    	  count=count+1;
	   	    cs.checkCart1();
	   	
	       System.out.println("YOU WANT TO ADD ANYTHING? ");
	       System.out.println("Press Y for Yes and N for No : ");
	      more = sc1.next();
	      
	      if(more.equalsIgnoreCase("Y")){
	    	   
	    	   order1();
	           //cart.add_cart();
	           
	           
	           }
	       else if(more.equalsIgnoreCase("N")) {
	    	   cd.displayCart();
	    	   cs.cartOperation();
	       }
	       else{
	       	System.out.println("You Enter Invalid value, Choose food again");
	       	total=0;
	       	order1();
	       	}
	       break;
	   	  default:
	   		  System.out.println("Enter valid Number to select  :");
	   		  break;
	    
	    }}
	    else{
	    	switch(2){
	       case 2:
	    	   count=count+1;
	     	 cs.checkCart1();
	         System.out.println("YOU WANT TO ADD ANYTHING? ");
	         System.out.println("Press Y for Yes and N for No : ");
	         more = sc1.next();
	        
	         if(more.equalsIgnoreCase("Y")){
	      	   order1();
	             //cart.add_cart();
	             
	             }
	         else if(more.equalsIgnoreCase("N")) {
	        	
	        	 
	        	 
	        	 cd.displayCart();
	        	 cs.cartOperation();
	        	 
	        	 }
	         else{
	         	System.out.println("You Enter Invalid value, Choose food again");
	         	total=0;
	         	order1();
	         	}
	     	 break;
	    	}
	    }}
	    
	    else {
	    	System.out.println("Enter valid Quantity, Choose food again");
	    	total=0;
	    	//order();
	    }}
	    else {
	    	System.out.println("Item not Present Enter valid Item Number");
	    	order1();
	    }
	   
	}
	    

public static void delivery1() throws SQLException {
		System.out.println("Enter delivery location:");
		Time a=null;
	    String location=sc1.next();
	    otdi.delivery(location,a);
		//System.out.println("Delivery location done");
	}

public static void payment1() throws SQLException {
    	
    	System.out.println("Total price is " + total);
        System.out.println("Enter a payment ");
        pay = sc1.nextDouble();
         otdi.payment(pay);
         if(pay==total){
        System.out.println("Payment Successful");
        System.out.println("Thank you for your order");
        total=0;
        
        }
        else {
        	System.out.println("========Enter Correct Amount To pay===========");
    }}




public void cancelOrder1() throws ClassNotFoundException, SQLException {
	 boolean s= otdi.cancelOrder();
	 if(s) {
	  System.out.println("Enter order_id to cancel the order");
	  int od_id=sc1.nextInt();
	  boolean i=otdi.checkId(od_id);
	  if(i) {
	  otdi.removeOrder(od_id);
	System.out.println("order cancelled");}
	  else {
		  System.out.println("Order Not Present");
	  }
	
	 }
	
	else {
		System.out.println("You don't have Any order to cancel");
	}
	
	
	
	


}
}
