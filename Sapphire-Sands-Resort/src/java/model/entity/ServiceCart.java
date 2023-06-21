package model.entity;

import java.sql.Timestamp;

public class ServiceCart {
    private String serviceID, serviceName, orderID;
    private int amount, serviceStatus;
    private double servicePrice;
    private Timestamp serviceTime;

    public ServiceCart() {
    }

    public ServiceCart(String serviceID, String serviceName, int amount, double servicePrice) {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.amount = amount;
        this.servicePrice = servicePrice;
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

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(int serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public double getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(double servicePrice) {
        this.servicePrice = servicePrice;
    }

    public Timestamp getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(Timestamp serviceTime) {
        this.serviceTime = serviceTime;
    }

    @Override
    public String toString() {
        return "ServiceCart{" + "serviceID=" + serviceID + ", serviceName=" + serviceName + ", orderID=" + orderID + ", amount=" + amount + ", serviceStatus=" + serviceStatus + ", servicePrice=" + servicePrice + ", serviceTime=" + serviceTime + '}';
    }
    
}
