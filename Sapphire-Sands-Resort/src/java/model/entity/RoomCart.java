package model.entity;

import java.sql.Timestamp;
import java.util.Date;

public class RoomCart {
    private String orderID, roomID, roomName, roomType;
    private Timestamp timeRegister;
    private Date timeIn, timeOut;
    private int people;
    private double roomPrice;
    private int dayStay;

    public RoomCart() {
    }

    public RoomCart(String orderID, String roomID, String roomName, String roomType, Timestamp timeRegister, Date timeIn, Date timeOut, int people, double roomPrice) {
        this.orderID = orderID;
        this.roomID = roomID;
        this.roomName = roomName;
        this.roomType = roomType;
        this.timeRegister = timeRegister;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.people = people;
        this.roomPrice = roomPrice;
    }

    public RoomCart(String orderID, String roomID, String roomName, String roomType, Timestamp timeRegister, Date timeIn, Date timeOut, int people, double roomPrice, int dayStay) {
        this.orderID = orderID;
        this.roomID = roomID;
        this.roomName = roomName;
        this.roomType = roomType;
        this.timeRegister = timeRegister;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.people = people;
        this.roomPrice = roomPrice;
        this.dayStay = dayStay;
    }
    
    

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
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

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Timestamp getTimeRegister() {
        return timeRegister;
    }

    public void setTimeRegister(Timestamp timeRegister) {
        this.timeRegister = timeRegister;
    }

    public Date getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(Date timeIn) {
        this.timeIn = timeIn;
    }

    public Date getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Date timeOut) {
        this.timeOut = timeOut;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public int getDayStay() {
        return dayStay;
    }

    public void setDayStay(int dayStay) {
        this.dayStay = dayStay;
    }

    @Override
    public String toString() {
        return "RoomCart{" + "orderID=" + orderID + ", roomID=" + roomID + ", roomName=" + roomName + ", roomType=" + roomType + ", timeRegister=" + timeRegister + ", timeIn=" + timeIn + ", timeOut=" + timeOut + ", people=" + people + ", roomPrice=" + roomPrice + ", dayStay=" + dayStay + '}';
    }
    
    
    
}
