/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import model.entity.Employee;
import model.repository.EmployeeRepository;

/**
 *
 * @author Admin
 */
public class EmployeeService {
    public static Employee login(String username, String password){
        return EmployeeRepository.login(username, password);
    }
}
