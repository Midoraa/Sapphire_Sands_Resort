/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.sql.Date;


/**
 *
 * @author Admin
 */
public class Customer extends Account{
    private String cusName;
    private Date cusDOB;
    private String cusPhone, cusEmail, cusCCCD;
    private int cusType;

    public Customer(String cusName, Date cusDOB, String cusPhone, String cusEmail, String cusCCCD, int cusType) {
        this.cusName = cusName;
        this.cusDOB = cusDOB;
        this.cusPhone = cusPhone;
        this.cusEmail = cusEmail;
        this.cusCCCD = cusCCCD;
        this.cusType = cusType;
    }
    
    

    public Customer(String accountID, String username, String password, boolean role, String cusName, Date cusDOB, String cusPhone, String cusEmail, String cusCCCD, int cusType) {
        super(accountID, username, password, role);
        this.cusName = cusName;
        this.cusDOB = cusDOB;
        this.cusPhone = cusPhone;
        this.cusEmail = cusEmail;
        this.cusCCCD = cusCCCD;
        this.cusType = cusType;
    }

    @Override
    public String toString() {
        return "Customer{" + "cusName=" + cusName + ", cusDOB=" + cusDOB + ", cusPhone=" + cusPhone + ", cusEmail=" + cusEmail + ", cusCCCD=" + cusCCCD + ", cusType=" + cusType + '}';
    }

    
    
    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public Date getCusDOB() {
        return cusDOB;
    }

    public void setCusDOB(Date cusDOB) {
        this.cusDOB = cusDOB;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public String getCusEmail() {
        return cusEmail;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }

    public String getCusCCCD() {
        return cusCCCD;
    }

    public void setCusCCCD(String cusCCCD) {
        this.cusCCCD = cusCCCD;
    }

    public int getCusType() {
        return cusType;
    }

    public void setCusType(int cusType) {
        this.cusType = cusType;
    }
    
    
}
