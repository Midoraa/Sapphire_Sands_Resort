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
public class Employee {
    private String username, password;
    private int role;
    private String empID, empNames;
    private boolean empGender;
    private Date empDOB;
    private String empAdress, empPhone, empEmail;

    public Employee() {
    }

    public Employee(String username, String password, int role, String empID) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.empID = empID;
    }

    public Employee(String empID, String empNames, boolean empGender, Date empDOB, String empAdress, String empPhone, String empEmail) {
        this.empID = empID;
        this.empNames = empNames;
        this.empGender = empGender;
        this.empDOB = empDOB;
        this.empAdress = empAdress;
        this.empPhone = empPhone;
        this.empEmail = empEmail;
    }

    public Employee(String username, String password, int role, String empID, String empNames, boolean empGender, Date empDOB, String empAdress, String empPhone, String empEmail) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.empID = empID;
        this.empNames = empNames;
        this.empGender = empGender;
        this.empDOB = empDOB;
        this.empAdress = empAdress;
        this.empPhone = empPhone;
        this.empEmail = empEmail;
    }

    @Override
    public String toString() {
        return "Employee{" + "username=" + username + ", password=" + password + ", role=" + role + ", empID=" + empID + ", empNames=" + empNames + ", empGender=" + empGender + ", empDOB=" + empDOB + ", empAdress=" + empAdress + ", empPhone=" + empPhone + ", empEmail=" + empEmail + '}';
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

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getEmpNames() {
        return empNames;
    }

    public void setEmpNames(String empNames) {
        this.empNames = empNames;
    }

    public boolean isEmpGender() {
        return empGender;
    }

    public void setEmpGender(boolean empGender) {
        this.empGender = empGender;
    }

    public Date getEmpDOB() {
        return empDOB;
    }

    public void setEmpDOB(Date empDOB) {
        this.empDOB = empDOB;
    }

    public String getEmpAdress() {
        return empAdress;
    }

    public void setEmpAdress(String empAdress) {
        this.empAdress = empAdress;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }
    
    
}
