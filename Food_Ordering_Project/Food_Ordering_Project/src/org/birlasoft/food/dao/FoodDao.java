package org.birlasoft.food.dao;
import java.sql.SQLException;

import org.birlasoft.food.inventory.Mainclass;

public interface FoodDao {
	public void menu() throws SQLException;
	public boolean order(int choose) throws SQLException;
}
