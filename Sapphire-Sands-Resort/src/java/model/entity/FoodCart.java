package model.entity;

import java.sql.Timestamp;

public class FoodCart {
    private String orderID, foodID, foodName, cusID;
    private double foodPrice;
    private Timestamp orTime;
    private int amount;
    private int orStatus;
    
    public FoodCart() {
    }

    public FoodCart(String foodID, int amount) {
        this.foodID = foodID;
        this.amount = amount;
    }

    public FoodCart(String foodID, String foodName, double foodPrice, int amount) {
        this.foodID = foodID;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.amount = amount;
    }
    

    public FoodCart(String foodID, String foodName, String cusID, double foodPrice, Timestamp orTime, int amount) {
        this.foodID = foodID;
        this.foodName = foodName;
        this.cusID = cusID;
        this.foodPrice = foodPrice;
        this.orTime = orTime;
        this.amount = amount;
    }

    public FoodCart(String orderID, String foodID, String foodName, String cusID, double foodPrice, Timestamp orTime, int amount, int orStatus) {
        this.orderID = orderID;
        this.foodID = foodID;
        this.foodName = foodName;
        this.cusID = cusID;
        this.foodPrice = foodPrice;
        this.orTime = orTime;
        this.amount = amount;
        this.orStatus = orStatus;
    }

    public FoodCart(String orderID, String foodID, Timestamp orTime, int amount, int orStatus) {
        this.orderID = orderID;
        this.foodID = foodID;
        this.orTime = orTime;
        this.amount = amount;
        this.orStatus = orStatus;
    }

    public FoodCart(String orderID, String foodID, String foodName, double foodPrice, Timestamp orTime, int amount, int orStatus) {
        this.orderID = orderID;
        this.foodID = foodID;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.orTime = orTime;
        this.amount = amount;
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

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public Timestamp getOrTime() {
        return orTime;
    }

    public void setOrTime(Timestamp orTime) {
        this.orTime = orTime;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getOrStatus() {
        return orStatus;
    }

    public void setOrStatus(int orStatus) {
        this.orStatus = orStatus;
    }

//    @Override
//    public String toString() {
////        return foodID + ":" + amount + "/";
//        return foodID + ":" + foodName + ":" + foodPrice + ":" + amount;
//    }

    @Override
    public String toString() {
        return "FoodCart{" + "orderID=" + orderID + ", foodID=" + foodID + ", foodName=" + foodName + ", cusID=" + cusID + ", foodPrice=" + foodPrice + ", orTime=" + orTime + ", amount=" + amount + ", orStatus=" + orStatus + '}';
    }
    
}
