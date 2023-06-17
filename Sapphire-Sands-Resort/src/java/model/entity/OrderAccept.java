/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

/**
 *
 * @author Admin
 */
public class OrderAccept {
    String orderID, cusID, date, orStatus;

    public OrderAccept() {
    }

    public OrderAccept(String orderID, String cusID, String date, String orStatus) {
        this.orderID = orderID;
        this.cusID = cusID;
        this.date = date;
        this.orStatus = orStatus;
    }

    @Override
    public String toString() {
        return "OrderAccept{" + "orderID=" + orderID + ", cusID=" + cusID + ", date=" + date + ", orStatus=" + orStatus + '}';
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrStatus() {
        return orStatus;
    }

    public void setOrStatus(String orStatus) {
        this.orStatus = orStatus;
    }
    
}
