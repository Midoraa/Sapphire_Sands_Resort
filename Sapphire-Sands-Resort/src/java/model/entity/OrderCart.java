package model.entity;

public class OrderCart {
    private String cusID, orderID;
    private int orStatus;

    public OrderCart() {
    }

    public OrderCart(String cusID, String orderID, int orStatus) {
        this.cusID = cusID;
        this.orderID = orderID;
        this.orStatus = orStatus;
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public int getOrStatus() {
        return orStatus;
    }

    public void setOrStatus(int orStatus) {
        this.orStatus = orStatus;
    }

    @Override
    public String toString() {
        return "cusID = " + cusID + ", orderID = " + orderID + ", orStatus = " + orStatus;
    }
    
    
    
}
