package model.entity;

public class OrderCart {
    private String cusID, orderID;
    private int orStatus;

    private String roomID, roomName;
    
    public OrderCart() {
    }

    public OrderCart(String cusID, String orderID, int orStatus) {
        this.cusID = cusID;
        this.orderID = orderID;
        this.orStatus = orStatus;
    }

    public OrderCart(String orderID, int orStatus, String roomID, String roomName) {
        this.orderID = orderID;
        this.orStatus = orStatus;
        this.roomID = roomID;
        this.roomName = roomName;
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

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
    
    

    @Override
    public String toString() {
        return "cusID = " + cusID + ", orderID = " + orderID + ", orStatus = " + orStatus;
    }
    
    
    
}
