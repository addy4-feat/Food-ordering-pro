package org.birlasoft.food.inventory;
import java.sql.SQLException;
import java.util.*;

import org.birlasoft.food.dao.*;
import org.birlasoft.food.exceptions.FoodException;
import org.birlasoft.food.model.*;
import org.birlasoft.food.service.*;



public class Mainclass {

  
	
	
	static void registration()
	{
		System.out.println("+=====================================================Welcome to Food Ordering Portal==========================================================================+");
		System.out.println("\t\t\t\t\t\t\t\t1.Registration");
		System.out.println("\t\t\t\t\t\t\t\t2.Login");
		System.out.println("\t\t\t\t\t\t\t\t3.Admin login");
		System.out.println("+=============================================================================================================================================================  +");
		
	}
	public static  void menu()
	{
		System.out.println("+================================================================================================================================================================+");
		System.out.println("\t\t\t\t   1.Add New Item");
		System.out.println("\t\t\t\t   2.Delete item");
		System.out.println("\t\t\t\t   3.Check customer details");
		System.out.println("\t\t\t\t   4.Check customer ordered details");
		System.out.println("\t\t\t\t   5.Update Expected arrival time");
		System.out.println("\t\t\t\t   6.Check payment details");
		System.out.println("\t\t\t\t   7.Change price for item");
		System.out.println("\t\t\t\t   8.Check for delivery status");
		System.out.println("\t\t\t\t   9.Display items");
		System.out.println("\t\t\t\t   10.Change name of the item");
		System.out.println("\t\t\t\t   11.Delete customer");
		System.out.println("\t\t\t\t   12.Cancel ordered item");
		System.out.println("\t\t\t\t   Enter 0 to exit");
		System.out.println("+================================================================================================================================================================+");
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		int opt;
	
	    registration();
	 
     while(true) {
		try {
			System.out.println("Enter respected value to choose:");
			int opt1=sc.nextInt();

    	   switch(opt1) {
    	   		
    	   case 1:
    		   RegistrationService R=new RegistrationService();
    		   sc.nextLine();
    		   System.out.println("Enter username:");
    	
    		   String username=sc.nextLine();  
    		   if(R.isValidName(username))
    		   {
    			   System.out.println("Valid username");
    		   }
    		   else
    		   {
    			   System.out.println("Invalid username");
    			   System.out.println("Username must be Alphabetic");
    			   System.out.println("------------------------------------------------------");
    			   break;
    		   }
    		   System.out.println("Enter address:");
    		
    		   String address=sc.nextLine();
    		   if(R.isValidName(address))
    		   {  
    		   }
    		   else
    		   {
    			   System.out.println("Invalid Address");
    			   System.out.println("------------------------------------------------------");
    			   break;
    		   }
    		   
    		   System.out.println("Enter phono:");
    		   sc=new Scanner(System.in);//??
    		   long Phono=0;
    		   if(sc.hasNext("^[0-9]{10}$")) {
    			    Phono=sc.nextLong();
    		   }
    		   else {
    			   System.out.println("invalid phone number\n Please try to register again");
    			   System.out.println("------------------------------------------------------");
    			   break;
    		   }
    		   sc.nextLine();
    		   System.out.println("Create password:");
    		 
    		  String password=sc.nextLine(); 
    		  if(R.isValidPassword(password))
   		   {
   			   System.out.println("Valid Password");
   		   }
   		   else
   		   {
   			   System.out.println("Invalid username\\n Please try to register again");
   			   System.out.println("Minimum eight characters, at least one uppercase letter, one lowercase letter and one number:");
   			System.out.println("------------------------------------------------------");
   			   break;
   		   }
   		      R.registrationInsert(username, address, Phono, password);
    		   
    		   break;
    	  
    	   case 2:
    		   Login l= new Login();
         	  System.out.println("Enter username");
         	  String user=sc.next();
         	  l.setUsername(user);
         	  System.out.println("Enter password");
 			  String pass=sc.next();
         	   l.setPassword(pass);
         	  LoginDaoImp ld=new LoginDaoImp();
 				boolean log;
 						log = ld.validLogin(l);
 					
 					if(!log) {
 						System.out.println("Login Failed");
 						registration();
 					}
 					else {
 						Order ot=new Order();
 					    Cart cm=new Cart();
 					    OrderService os=new OrderService();
 					    CartService cs=new CartService();
 						System.out.println("*******VALID USER********");
 						int c=ld.custId(l);
 						System.out.println("YOUR CUSTOMER ID IS:"+c);
 					    ot.setCust_id(c);
 						cm.setCust_id(c);
 				     System.out.println("*choose 1 to order:\n*choose 2 to cancel order:\n*choose 3 to display cart:");
 					 int op = sc.nextInt();
 					     switch(op) {
 					     case 1:
 					    	FoodDaoImp fd=new FoodDaoImp();
 					    	 fd.menu();
 					    	 os.order1();
 					    	 cs.startPage();
 					    	 break;
 					     case 2:
 					    	 os.cancelOrder1();
 					    	 cs.startPage();
 					    	 break;
 					     case 3:
 					    	 cs.displayCart1();
 				    		  cs.startPage();
 				    		  break;
 				         default:
 				        	 System.out.println("Please Enter Correct Number to Choose");
 				         	 cs.startPage();
 				         	 
 					    	 
 					     }
 					}
 					break;	
   
     	 
    	 
 					
    	   case 3:
    		   AdminService as = new AdminServiceImpl();;
    		   AdminDao ad1=null;
    		   sc.nextLine();
         	   System.out.println("Enter username::");
         	
                String username2=sc.nextLine();
         	   
         	   System.out.println("Enter password::");
         	 
         	   String password2=sc.nextLine();
         	   Admin admin=new Admin(username2,password2);
         	   if(as.validAdmin(admin))
         	   {
         		   System.out.println("Valid Admin");
         		   Mainclass.menu();
         	   }
         	   else
         	   {
         		   System.out.println("Invalid Admin");
         		 Mainclass.main(null);  
         	   }
         	  
            	  
                while(true) {
                	
                	System.out.println("Please enter your choise between 1 to 12");
                	opt=sc.nextInt();
        			switch(opt) {
        			
		        			case 1:
		        				sc.nextLine();
		        				System.out.println("Enter item_name:");
		        				String fName=sc.nextLine();
		        			
		        				System.out.println("Enter item_price:");
		        				int fPrice=sc.nextInt();
		        				sc.nextLine();
		        				System.out.println("Enter item_avilabilty:");
		        				String fAval=sc.nextLine();
		        				Food af=new Food(fName, fPrice, fAval);
		        				if(as.addFood(af))
		        				{
		        					System.out.println("Data already exists");
		        					
		        				}
		        				else
		        				{
		        					System.out.println("Successfully added food item");
		        				}
		        				
		        				break;
		        				
		      
		        			case 2:
		        				
		        				  System.out.println("Enter Food id that you want to delete");
		        				  int Fid=sc.nextInt();
		        				  if(as.deleteFood(Fid)!=0)
		        				  {
		        					 System.out.println("Successfully deleted"); 
		        				  }
		        				  else
		        				  {
		        					  System.out.println("Data not found");
		        				  }
		        				break;
		        				
		        			case 3:
		        				
		        				System.out.println("Choose 1 for search by Id\n choose 2 for  displaying all:");
		        				
		        				int ch=sc.nextInt();
		        				if(ch==1) {
		        				System.out.println("Enter the cust_id of the username:");
		        	
		        			     int custid=sc.nextInt();
		        			     Customer cust=as.displayCustomer(custid);
		        			     if(cust!=null)
		        			     {
		        			    	 System.out.println(cust);		        					
		        				}
		        			     else
		        			     {
		        			    	 System.out.println("Data not found");
		        			     }
		        				}
		        				else if(ch==2) {
		        					List<Customer>list=as.displayCustomerAll();
		        					if(list.isEmpty())
		        					{
		        						System.out.println("Data Not found");
		        					}
		        					else
		        					{
		        						for(Customer c:list)
		        						{
		        							System.out.println(c);
		        						}
		        					}
		        				}
		        				else
		        				{
		        					System.out.println("Invalid input\n Please enter your choice from the above list");
		        				}       				
		        				break;
		        				
		        			case 4:
		        				
		        				System.out.println("Choose 1 for search by Order Id\n choose 2 for  displaying all:");
		        				
		        				int ch2=sc.nextInt();
		        				if(ch2==1) {
		        				System.out.println("Enter the Order_id:");
		        			
		        			     int oid=sc.nextInt();
		        			     as.displayOrder(oid);
		        				}
		        				else if(ch2==2) {
		        					as.displayOrderAll();
		        				}
		        				else
		        				{
		        					System.out.println("Invalid input \nChoose 1 for search by Id\\n choose 2 for  displaying all:");
		        				}       				
		        				break;
		        				
		        			case 5:
		        				System.out.println("Enter the Order ID :");
		        				int oid=sc.nextInt();
		        				System.out.println("Enter the Expected Arrival time to add ");
		        				String time1=sc.next(); 
		        				if(as.updateArrTime(time1,oid)==0)
		        				{
		        					throw new FoodException("Data not found");
		        				}
		        				else
		        				{
		        					System.out.println("Data updated successfully");
		        				}
		        				break;
		        				
		        			case 6:
		        				System.out.println("Enter the Order_id:");
		        				int oid2=sc.nextInt();
		        			     List<Payment>plist=as.checkpayment(oid2);
		        			     if(plist.isEmpty())
		        			     {
		        			    	 System.out.println("Data not Found");
		        			   
		        			     }
		        			     else
		        			     {
		        			    	 for(Payment p:plist)
		        			    	 {
		        			    		 System.out.println(p);
		        			    	 }
		        			     }
		        				 break;
		        				

		        
		        				
		        			case 7:
		        				System.out.println("Enter Food Id :");
		        				int fid1=sc.nextInt();
		        				System.out.println("Enter new price of the Food item");
		        				int fprice1=sc.nextInt();
		        				if(as.updatePrice(fid1,fprice1)==0)
		        				{
		        					throw new FoodException("Data not found");
		        				}
		        				else
		        				{
		        					System.out.println("Successfully update the Food Price");
		        					System.out.println("Please enter your choice from the above list");
		        				}
		        				
		        				break;
		   				
		        			case 8:
		        			List<Delivery>dlist=as.displayDelivery();
		        			if(dlist.isEmpty())
		        			{
		        				System.out.println("Data not found");
		        			}
		        			else
		        			{
		        				for(Delivery d:dlist)
		        				System.out.println(d);
		        			}
		        			break;
		        			case 9:
		        				sc.nextLine();
		        				System.out.println("Choose 1 for search by Id\n choose 2 for  displaying all:");
		        				
		        				int ch1=sc.nextInt();
		        				if(ch1==1) {
		        				System.out.println("Enter the id of the Food:");
		        		
		        			     int fid=sc.nextInt();
		        			     Food fobj=as.displayFood(fid);
		        			     if(fobj!=null)
		        			     {
		        			    	 System.out.println(fobj); 
		        			     }
		        			     
		        			     
		        				}
		        				else if(ch1==2) {
		        					List<Food>flist=as.displayFoodAll();
		        					if(flist.isEmpty())
		        					{
		        						System.out.println("Data not found");
		        					}
		        					else
		        					{
		        						for(Food f:flist)
		        						{
		        							System.out.println(f);
		        						}
		        					}
		        				}
		        				else
		        				{
		        					System.out.println("Invalid input \nChoose 1 for search by Id\\n choose 2 for  displaying all:");
		        				}
		        					
		        				 break; 				
		        			case 10:
		        				System.out.println("Enter Food Id :");
		        				int fid2=sc.nextInt();
		        				sc.nextLine();
		        				System.out.println("Enter new Name of the Food item");
		        				String fname=sc.nextLine();
		        				if(as.updateFName(fid2, fname)==0)
		        				{
		        					throw new FoodException("Data not found");
		        				}
		        				else
		        				{
		        					System.out.println("Successfully update the Food Name");
		        					System.out.println("Please enter your choice from the above list");
		        				}
		        				break;
		        				
		        			case 11:
		        				System.out.println("Please enter the customer Id");
		        				int cid=sc.nextInt();
		        				if(as.deleteCustomer(cid)==0)
		        				{
		        					//throw new FoodException("Data not found");
		        					System.out.println("Data not found");
		        				}
		        				else
		        				{
		        					System.out.println("Successfully deleted");
		        				}
		        				break;
		        				
		        			case 12:
		        				System.out.println("Enter order id ");
		        				int oid1=sc.nextInt();
		        				if(as.cancelorder(oid1)==0)
		        				{
		        					//throw new FoodException("Data not found");
		        					System.out.println("Data not found");
		        				}
		        				else
		        				{
		        					System.out.println("Order Cancelled Successfully ");
		        				}
		        				break;
		        			case 0: System.out.println("Thank you");
		        					System.exit(0);

		        			default:System.out.println("Please enter valid input");
		        			
		        				
		        				
        			}
        		
                }
                
                
    	   			default://System.out.println("Please enter valid input");
   		   			break;
    	   }
       
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}     
	}
     }
	
	