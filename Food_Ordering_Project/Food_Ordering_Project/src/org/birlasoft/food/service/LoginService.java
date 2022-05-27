package org.birlasoft.food.service;
//package org.birlasoft.food.service;
//import java.sql.*;
//import java.util.Scanner;
//import org.birlasoft.food.dao.*;
//import org.birlasoft.food.model.Login;
//import org.birlasoft.food.inventory.Food_OrderingSystem;
//import org.birlasoft.food.inventory.order_table;
//
//public class LoginService {
//	public void validate_login(String username,String password) throws SQLException, ClassNotFoundException
//	{ 
//		LoginDao ld=new LoginDaoImp();
//		Login l=new Login(username,password);
//		
//		//int  check=0;
// 		
//            
//			if(ld.validLogin(l)) 
//			{
//				//check=check+1;
//			System.out.println("*******VALID USER********");
//			 System.out.println("YOUR CUSTOMER ID IS: "+ld.custId(l));
//		     System.out.println("*choose 1 to order:\n*choose 2 to cancel order:");
//			//@SuppressWarnings("resource")
//			Scanner se=new Scanner(System.in);
//	    	  int opt1 = se.nextInt();
//	    
//				      switch(opt1) {
//				    	  case 1:
//						Food_OrderingSystem fo=new Food_OrderingSystem();
//						 fo.menu();
//						 fo.order();
//						 //fo.payment();
//						 break;
//				    	  case 2:
//				    		  order_table.cancel_order();
//				    		  break;
//				              }
//			}
//			else
//			{
//				System.out.println("Invalid user");
//				
//			}
//			order_table or =new order_table();
//			//or.setCust_id(rs11.getInt(3))
//	
////	
////     if (check!=1) 
////            {
////            	System.out.println("New user Register yourself:");
////            	System.out.println("Choose option above for selection:");
////  
////            }
//           
//      
//    }
//
//}
