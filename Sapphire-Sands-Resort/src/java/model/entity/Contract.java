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
public class Contract {
    String roomID, orderID;
    String timeIn, timeOut;
    int people;
    Date timeRegister;

    public Contract() {
    }

    public Contract(String roomID, String timeIn, String timeOut, int people) {
        this.roomID = roomID;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.people = people;
    }

    public Contract(String roomID, String orderID, String timeIn, String timeOut, int people, Date timeRegister) {
        this.roomID = roomID;
        this.orderID = orderID;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.people = people;
        this.timeRegister = timeRegister;
    }

    @Override
    public String toString() {
        return "Contract{" + "roomID=" + roomID + ", orderID=" + orderID + ", timeIn=" + timeIn + ", timeOut=" + timeOut + ", people=" + people + ", timeRegister=" + timeRegister + '}';
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public Date getTimeRegister() {
        return timeRegister;
    }

    public void setTimeRegister(Date timeRegister) {
        this.timeRegister = timeRegister;
    }

    

}