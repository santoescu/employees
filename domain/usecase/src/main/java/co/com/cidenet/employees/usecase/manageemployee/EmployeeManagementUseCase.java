package co.com.cidenet.employees.usecase.manageemployee;

import co.com.cidenet.employees.model.employee.Employee;
import co.com.cidenet.employees.model.employee.gateways.EmployeeRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class EmployeeManagementUseCase {
    private final EmployeeRepository employeeRepository;
    public Employee addEmployee(Employee employee) {

        return employeeRepository.addEmployee(employee);
    }
    public void deleteEmployee(Long id) {
        employeeRepository.deleteEmployee(id);
    }
    public List<Employee> getAll() {

        return  employeeRepository.getAll();
    }
}
