package org.birlasoft.food.dao;


import java.sql.SQLException;

import org.birlasoft.food.model.Login;

public interface LoginDao {
	
	
	public boolean validLogin(Login l) throws SQLException;
	public int custId(Login l) throws SQLException;
}
