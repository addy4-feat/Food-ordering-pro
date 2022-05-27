package org.birlasoft.food.model;
import java.sql.SQLException;

import org.birlasoft.food.inventory.Mainclass;



public class Order {
	
	private int get_opt;
	public long date;
	private static  int food_price;
	private static int order_id;
	
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		Order.order_id = order_id;
	}

	public static int getFood_price() {
		return food_price;
	}
	public void setFood_price(int food_price) {
		Order.food_price = food_price;
	}
	
		

	

	public int getGet_opt() {
		return get_opt;
	}
	public void setGet_opt(int get_opt) throws SQLException {
		this.get_opt = get_opt;
		//add_order();
		
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}

private static int cust_id1;
private static int choose_foodid;
private static int choose_foodqty;

public void setCust_id(int c) {
	// TODO Auto-generated method stub
	Order.cust_id1=c;
	
}

public int getCust_id() {
	return cust_id1;
}

public void setChoose_foodid(int choose) {
	// TODO Auto-generated method stub
	Order.choose_foodid=choose;
	
}
public int getChoose_foodid() {
	return choose_foodid;
}

public void setChoose_foodqty(int quantity) {
	// TODO Auto-generated method stub
	Order.choose_foodqty=quantity;
	
}
public int getChoose_foodqty() {
	return choose_foodqty;
}
}
