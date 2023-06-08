package model.entity;

import java.sql.Date;

public class FoodCart {
    private String orderID, foodID, foodName, empID, cusID;
    private double foodPrice;
    private Date orDate;
    private int amount;
    private boolean orStatus;

    public FoodCart() {
    }

    public FoodCart(String orderID, String foodID, String foodName, double foodPrice, String empID, String cusID, Date orDate, int amount, boolean orStatus) {
        this.orderID = orderID;
        this.foodID = foodID;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.empID = empID;
        this.cusID = cusID;
        this.orDate = orDate;
        this.amount = amount;
        this.orStatus = orStatus;
    }

    public FoodCart(String cusID, String orderID, String foodID, String foodName, double foodPrice, int amount, Date orDate, boolean orStatus) {
        this.cusID = cusID;
        this.orderID = orderID;
        this.foodID = foodID;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.amount = amount;
        this.orDate = orDate;
        this.orStatus = orStatus;
    }
    
    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    public Date getOrDate() {
        return orDate;
    }

    public void setOrDate(Date orDate) {
        this.orDate = orDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isOrStatus() {
        return orStatus;
    }

    public void setOrStatus(boolean orStatus) {
        this.orStatus = orStatus;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "orderID=" + orderID + ", foodID=" + foodID + ", foodName=" + foodName + ", foodPrice=" + foodPrice + ", empID=" + empID + ", cusID=" + cusID + ", orDate=" + orDate + ", amount=" + amount + ", orStatus=" + orStatus + '}';
    }

    
    
}
