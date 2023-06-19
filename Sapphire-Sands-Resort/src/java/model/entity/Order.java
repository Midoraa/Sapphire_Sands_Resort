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
public class Order {
    private String orderID, cusID;
    private Date date;
    private boolean orStatus;

    public Order() {
    }

    public Order(String orderID, String cusID, Date date, boolean orStatus) {
        this.orderID = orderID;
        this.cusID = cusID;
        this.date = date;
        this.orStatus = orStatus;
    }

    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", cusID=" + cusID + ", date=" + date + ", orStatus=" + orStatus + '}';
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isOrStatus() {
        return orStatus;
    }

    public void setOrStatus(boolean orStatus) {
        this.orStatus = orStatus;
    }

    
    
}
