/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Admin
 */
public class ServiceCart {
    
    private String orderID, serviceID, serviceName, cusID;
    private double servicePrice;
    private Timestamp svTime;
    private int amount;
    private int svStatus;

    public ServiceCart() {
    }

    public ServiceCart(String serviceID, int amount) {
        this.serviceID = serviceID;
        this.amount = amount;
    }

    public ServiceCart(String serviceID, String serviceName, double servicePrice, int amount) {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.servicePrice = servicePrice;
        this.amount = amount;
    }

    public ServiceCart(String serviceID, String serviceName, String cusID, double servicePrice, Timestamp svTime, int amount) {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.cusID = cusID;
        this.servicePrice = servicePrice;
        this.svTime = svTime;
        this.amount = amount;
    }

    public ServiceCart(String orderID, String serviceID, Timestamp svTime, int amount, int svStatus) {
        this.orderID = orderID;
        this.serviceID = serviceID;
        this.svTime = svTime;
        this.amount = amount;
        this.svStatus = svStatus;
    }
  
    public ServiceCart(String orderID, String serviceID, String serviceName, String cusID, double servicePrice, Timestamp svTime, int amount, int svStatus) {
        this.orderID = orderID;
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.cusID = cusID;
        this.servicePrice = servicePrice;
        this.svTime = svTime;
        this.amount = amount;
        this.svStatus = svStatus;
    }

    @Override
    public String toString() {
        return "ServiceCart{" + "orderID=" + orderID + ", serviceID=" + serviceID + ", serviceName=" + serviceName + ", cusID=" + cusID + ", servicePrice=" + servicePrice + ", svTime=" + svTime + ", amount=" + amount + ", svStatus=" + svStatus + '}';
    }

    

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    public double getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(double servicePrice) {
        this.servicePrice = servicePrice;
    }

    

    public Timestamp getSvTime() {
        return svTime;
    }

    public void setSvTime(Timestamp svTime) {
        this.svTime = svTime;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getSvStatus() {
        return svStatus;
    }

    public void setSvStatus(int svStatus) {
        this.svStatus = svStatus;
    }
    
    
}
