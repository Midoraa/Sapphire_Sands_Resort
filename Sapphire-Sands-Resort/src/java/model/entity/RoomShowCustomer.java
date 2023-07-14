/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class RoomShowCustomer {
    private String cusID, orderID, roomID, roomName;
    private int roomType, people;
    private Date timeIn, timeOut;
    private double roomPrice;

    public RoomShowCustomer() {
    }

    public RoomShowCustomer(String cusID, String roomID, String roomName, int people, Date timeIn, Date timeOut, double roomPrice) {
        this.cusID = cusID;
        this.roomID = roomID;
        this.roomName = roomName;
        this.people = people;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.roomPrice = roomPrice;
    }

    
    
    public RoomShowCustomer(String cusID, String roomID, String roomName, int roomType, int people, Date timeIn, Date timeOut, double roomPrice) {
        this.cusID = cusID;
        this.roomID = roomID;
        this.roomName = roomName;
        this.roomType = roomType;
        this.people = people;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.roomPrice = roomPrice;
    }

    
    
    public RoomShowCustomer(String cusID, String orderID, String roomID, String roomName, int roomType, int people, Date timeIn, Date timeOut, double roomPrice) {
        this.cusID = cusID;
        this.orderID = orderID;
        this.roomID = roomID;
        this.roomName = roomName;
        this.roomType = roomType;
        this.people = people;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.roomPrice = roomPrice;
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

    public int getRoomType() {
        return roomType;
    }

    public void setRoomType(int roomType) {
        this.roomType = roomType;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
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

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    @Override
    public String toString() {
        return "RoomShowCustomer{" + "cusID=" + cusID + ", orderID=" + orderID + ", roomID=" + roomID + ", roomName=" + roomName + ", roomType=" + roomType + ", people=" + people + ", timeIn=" + timeIn + ", timeOut=" + timeOut + ", roomPrice=" + roomPrice + '}';
    }
    
    
}
