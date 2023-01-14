package co.com.cidenet.employees.model.employee.gateways;

import co.com.cidenet.employees.model.employee.Employee;

import java.util.List;

public interface EmployeeRepository {

     Employee addEmployee(Employee employee);
     void deleteEmployee(Long id);
     List<Employee> getAll();

}
