package model.service;

import model.entity.Employee;
import model.repository.EmployeeRepository;

public class EmployeeService {
    public static Employee login(String username, String password){
        return EmployeeRepository.login(username, password);
    }
}
