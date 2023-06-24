package model.entity;

public class Service {
    private String serviceID, serviceName;
    private double servicePrice;

    public Service() {
    }

    public Service(String serviceID, String serviceName, double servicePrice) {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.servicePrice = servicePrice;
    }

    @Override
    public String toString() {
        return "Service{" + "serviceID=" + serviceID + ", serviceName=" + serviceName + ", servicePrice=" + servicePrice + '}';
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

    public double getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(double servicePrice) {
        this.servicePrice = servicePrice;
    }

    
}
