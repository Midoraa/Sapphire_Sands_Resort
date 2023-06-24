package model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.config.DBConnect;
import model.entity.Employee;

public class EmployeeRepository {

    public static Employee login(String username, String password) {
        try (Connection conn = DBConnect.getConnection()) {
            String query = "SELECT * FROM Account JOIN Employee ON Account.accountID = Employee.empID WHERE Account.username = ? AND Account.password = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Employee emp = new Employee();
                emp.setEmpID(rs.getString("empID"));
                emp.setEmpNames(rs.getString("empName"));
                emp.setEmpGender(rs.getBoolean("empGender"));
                emp.setEmpDOB(rs.getDate("empDOB"));
                emp.setEmpAdress(rs.getString("empAddress"));
                emp.setEmpPhone(rs.getString("empPhone"));
                emp.setEmpEmail(rs.getString("empEmail"));
                emp.setUsername(rs.getString("username"));
                emp.setPassword(rs.getString("password"));
                emp.setRole(rs.getInt("role"));
                return emp;
            }
            rs.close();
            ps.close();
            conn.close();
            return null;
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("==============Loi Login Employee trong EmployeeRepo================");
        }
        return null;
    }
}
