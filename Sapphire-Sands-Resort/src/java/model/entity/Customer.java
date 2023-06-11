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
public class Customer {

    private String accountID, username, password;
    private int role=0;
    private String cusID;
    private String cusName;
    private Date cusDOB;
    private String cusPhone, cusEmail, cusCCCD;
    private int cusType;

    public Customer() {
    }

    public Customer(String accountID, String username, String password, int role, String cusID, String cusName, Date cusDOB, String cusPhone, String cusEmail, String cusCCCD, int cusType) {
        this.accountID = accountID;
        this.username = username;
        this.password = password;
        this.role = role;
        this.cusID = cusID;
        this.cusName = cusName;
        this.cusDOB = cusDOB;
        this.cusPhone = cusPhone;
        this.cusEmail = cusEmail;
        this.cusCCCD = cusCCCD;
        this.cusType = cusType;
    }

    @Override
    public String toString() {
        return "Customer{" + "accountID=" + accountID + ", username=" + username + ", password=" + password + ", role=" + role + ", cusID=" + cusID + ", cusName=" + cusName + ", cusDOB=" + cusDOB + ", cusPhone=" + cusPhone + ", cusEmail=" + cusEmail + ", cusCCCD=" + cusCCCD + ", cusType=" + cusType + '}';
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
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