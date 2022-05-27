package org.birlasoft.food.model;

public class Food {
private int foodId;
private String fName;
private int fPrice;
private String fAval;

public int getFoodId() {
	return foodId;
}
public void setFoodId(int foodId) {
	this.foodId = foodId;
}
public String getfName() {
	return fName;
}
public void setfName(String fName) {
	this.fName = fName;
}
public int getfPrice() {
	return fPrice;
}
public void setfPrice(int fPrice) {
	this.fPrice = fPrice;
}
public String getfAval() {
	return fAval;
}
public void setfAval(String fAval) {
	this.fAval = fAval;
}
public Food(String fName, int fPrice, String fAval) {
	super();
	this.fName = fName;
	this.fPrice = fPrice;
	this.fAval = fAval;
}
public Food(String fName) {
	super();
	this.fName = fName;

}

public Food(int foodId, String fName, int fPrice, String fAval) {
	super();
	this.foodId = foodId;
	this.fName = fName;
	this.fPrice = fPrice;
	this.fAval = fAval;
}
@Override
public String toString() {
	return "Food [foodId=" + foodId + ", fName=" + fName + ", fPrice=" + fPrice + ", fAval=" + fAval + "]";
}
}

