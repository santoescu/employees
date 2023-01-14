package co.com.cidenet.employees.model.employee.gateways;

import co.com.cidenet.employees.model.employee.Employee;
import co.com.cidenet.employees.model.exception.BusinessException;

import java.util.List;

public interface EmployeeRepository {

     Employee addEmployee(Employee employee);
     void deleteEmployee(Long id) throws BusinessException;
     List<Employee> getAll();
     List<Employee> findByNameAndAndLastNameAndCountry(String name,String lastName, String country);
}
