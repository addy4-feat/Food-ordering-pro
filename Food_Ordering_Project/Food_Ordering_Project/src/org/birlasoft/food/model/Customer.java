package org.birlasoft.food.model;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.birlasoft.food.dao.*;

@SuppressWarnings("unused")
public class Customer {
private int custid;

public int getCustid() {
	return custid;
}
public void setCustid(int custid) {
	this.custid = custid;
}
private static String username1;
private String username;
private String address;
private long phono;
private String create_password;
//private String  reenter_password;
public static int check=0;
public static int check1=0;
public static String getUsername1() {
	return username1;
}
public static void setUsername1(String username1) {
	Customer.username1 = username1;
}
public  String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getAddress() {
	return address;
}
public void setAddress(String adderss) {
	this.address = adderss;
}
public long getPhono() {
	return phono;
}
public void setPhono(long phono) {
	this.phono = phono;
}
public String getCreate_password() {
	return create_password;
}
public void setCreate_password(String create_password) {
	this.create_password = create_password;
}
//public String getReenter_password() {
//	return reenter_password;
//}
//public void setReenter_password(String reenter_password) {
//	this.reenter_password = reenter_password;
//}
public static int getCheck() {
	return check;
}
public static void setCheck(int check) {
	Customer.check = check;
}
public static int getCheck1() {
	return check1;
}
public static void setCheck1(int check1) {
	Customer.check1 = check1;
}
public Customer(String username,String address, long phono, String create_password) {
	super();
	this.username=username;
	this.address = address;
	this.phono = phono;
	this.create_password = create_password;

}
public Customer(int custid, String username, String adderss, long phono, String create_password) {
	super();
	this.custid = custid;
	this.username = username;
	this.address = adderss;
	this.phono = phono;
	this.create_password = create_password;
	
}
public Customer() {
	super();
	
}
@Override
public String toString() {
	return "Customer [custid=" + custid + ", username=" + username + ", address=" + address + ", phono=" + phono
			+ ", create_password=" + create_password + "]";
}


}




//@SuppressWarnings("static-access")



