package org.birlasoft.food.service;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.birlasoft.food.dao.CustomerDao;
import org.birlasoft.food.dao.CustomerDaoImp;
import org.birlasoft.food.inventory.Mainclass;
import org.birlasoft.food.model.Customer;


public class RegistrationService {
	public void registrationInsert(String username,String address,long phono,String password) throws SQLException, ClassNotFoundException
	{

		
		CustomerDao cd=new CustomerDaoImp();
		Customer r=new Customer(username,address,phono,password);

		 if(cd.validCustomer(r)) {
			 System.out.println("username already present");
		 }
		 else {
			 
			 cd.insertCustomer(r);
		
			 System.out.println("Congratulation you have successfully registered\nPlease login your account");
			Mainclass.main(null);
		
	        }
	}
	
	public boolean isValidName(String name)
    {

       
        String regex = "^[A-Za-z]{5,29}$";
        Pattern p = Pattern.compile(regex);
        if (name == null) {
            return false;
        }
    
        Matcher m = p.matcher(name);
        return m.matches();
    }
	
	public  boolean isValidPassword(String creat_password)
    {
        String regex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,20}$";
        Pattern p = Pattern.compile(regex);

        
        if (creat_password == null) {
            return false;
        }

        Matcher m = p.matcher(creat_password);

        return m.matches();
    }


	//@SuppressWarnings("static-access")
//	public void registration_details(ArrayList<Customer> arr) {
//		
//
//	for( Customer registration:arr)
//	{ System.out.println("Username:"+registration.username);
//	System.out.println("Address:"+registration.adderss);
//	System.out.println("Phono:"+registration.phono);
//	System.out.println("Createpass"+registration.create_password);
//	System.out.println("Re-Enter_password:"+registration.reenter_password);
//	if(registration.create_password.equals(registration.reenter_password))
//	{
//		Mainclass.menu();
//
//	}
//	else {
//		System.out.println("Mismatch with pasword");
//		Mainclass.registration();
//		}
//
//	}
//	}


	

}
