package org.birlasoft.food.service;

import java.sql.SQLException;

import java.util.List;

import org.birlasoft.food.dao.AdminDao;
import org.birlasoft.food.dao.AdminDaoImp;
import org.birlasoft.food.exceptions.FoodException;
import org.birlasoft.food.inventory.Mainclass;
import org.birlasoft.food.model.Admin;
import org.birlasoft.food.model.Customer;
import org.birlasoft.food.model.Delivery;
import org.birlasoft.food.model.Food;
import org.birlasoft.food.model.Payment;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

public class AdminServiceImpl implements AdminService {

private AdminDao dao;


public AdminServiceImpl() {
	dao=new AdminDaoImp();
	}

public boolean validAdmin(Admin admin) throws SQLException {
	return dao.validAdmin(admin);
}
public boolean addFood(Food af) throws SQLException, FoodException {
	return dao.addFood(af);

}

public int deleteFood(int Fid) throws SQLException {
	return dao.deleteFood(Fid);
}

public Customer displayCustomer(int custid) throws SQLException {
	return dao.displayCustomer(custid);
}

@Override
public List<Customer> displayCustomerAll() throws SQLException {
	return dao.displayCustomerAll();
}

@Override
public List<Food> displayFoodAll() throws SQLException {
	return dao.displayFoodAll();
}

@Override
public Food displayFood(int fid) throws SQLException {
	return dao.displayFood(fid);

}

@Override
public Order displayOrder(int oid) throws SQLException {
	return dao.displayOrder(oid);
}

@Override
public void displayOrderAll() throws SQLException {
	// TODO Auto-generated method stub

}

@Override
public int deleteCustomer(int custid) throws Exception {
	return dao.deleteCustomer(custid);	
}


@Override
public int updatePrice(int fid, int fprice) throws SQLException {
	return dao.updatePrice(fid, fprice);

}


@Override
public int updateFName(int fid, String fname) throws SQLException {
	return dao.updateFName(fid, fname);

}


public List<Payment>checkpayment(int oid) throws SQLException {
	return dao.checkpayment(oid);


}
public int cancelorder(int oid) throws SQLException {
	return dao.cancelorder(oid);
}

public List<Delivery> displayDelivery() throws SQLException {
	return dao.displayDelivery();
}

public int updateArrTime(String time1, int oid) throws SQLException {
	return dao.updateArrTime(time1, oid);

}

}		


