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
public class ContractOrder {
    private String orderID, roomID, cusID, cusName;
    private String timeRegister;
    private Date timeIn, timeOut;
    private int people;

    public ContractOrder() {
    }

    public ContractOrder(String orderID, String roomID, String cusID, String cusName, String timeRegister, Date timeIn, Date timeOut, int people) {
        this.orderID = orderID;
        this.roomID = roomID;
        this.cusID = cusID;
        this.cusName = cusName;
        this.timeRegister = timeRegister;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.people = people;
    }

    @Override
    public String toString() {
        return "ContractOrder{" + "orderID=" + orderID + ", roomID=" + roomID + ", cusID=" + cusID + ", cusName=" + cusName + ", timeRegister=" + timeRegister + ", timeIn=" + timeIn + ", timeOut=" + timeOut + ", people=" + people + '}';
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

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getTimeRegister() {
        return timeRegister;
    }

    public void setTimeRegister(String timeRegister) {
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
    
    
}
