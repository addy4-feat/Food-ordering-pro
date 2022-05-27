package org.birlasoft.food.model;
import java.sql.SQLException;
import java.util.Scanner;

import org.birlasoft.food.inventory.Mainclass;



public class Cart {
   
	private static int choose_foodid;
	private static int choose_foodqty;
	
	private int get_opt;
	public  int cuid;
	public  int ffid;
	public  int ffq;
	
	
	
	private static int choose_foodp;
	private static String choose_foodname;
	private static int cust1_id;
 public Cart(int cid,int fid,String fname,int fq,int fp){
		setCust_id(cid);
		Cart.choose_foodid=fid;
		this.setChoose_foodname(fname);
		Cart.choose_foodqty=fq;
		Cart.choose_foodp=fp;
		
		
	}
	public Cart(){
		
	}
	public Cart(int cuid,int ffid,int ffq){
		this.cuid=cuid;
		this.ffid=ffid;
		this.ffq=ffq;
	}

 
	public int getChoose_foodid() {
		return choose_foodid;
	}
	public void setChoose_foodid(int choose_foodid) {
		Cart.choose_foodid = choose_foodid;
	}
	public int getChoose_foodqty() {
		return choose_foodqty;
	}
	public void setChoose_foodqty(int choose_foodqty) {
		Cart.choose_foodqty = choose_foodqty;
	}

	public int getGet_opt() {
		return get_opt;
	}
	public void setGet_opt(int get_opt) throws SQLException {
		this.get_opt = get_opt;
		//add_order(0);
		
	}
	
	public int getChoose_foodp() {
		return choose_foodp;
	}
	public void setChoose_foodp(int choose_foodp) {
		Cart.choose_foodp = choose_foodp;
	}
	
	
	public void setCust_id(int c) {
		// TODO Auto-generated method stub
		Cart.cust1_id=c;
	}
	public int getCust_id() {
		return cust1_id;
	}
	
	public void setChoose_foodname(String choose_foodname) {
		
		Cart.choose_foodname = choose_foodname;
	}
	public String getChoose_foodname() {
		
		return choose_foodname;
	}
	
	
	
	
}
