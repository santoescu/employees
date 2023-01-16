package co.com.cidenet.employees.usecase.manageemployee;

import co.com.cidenet.employees.model.employee.Employee;
import co.com.cidenet.employees.model.employee.gateways.EmployeeRepository;
import co.com.cidenet.employees.model.exception.BusinessException;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class EmployeeManagementUseCase {
    private final String EMAIL_STRUCTURE = "%s.%s@%s";
    private final EmployeeRepository employeeRepository;
    public Employee addEmployee(Employee employee) {
        String domain="cidenet.com";
        if (employee.getCountry().equals("co")){
            domain="cidenet.com.co";
        }else if(employee.getCountry().equals("us")){
            domain="cidenet.com.us";
        }
        String email = String.format(EMAIL_STRUCTURE,employee.getName(),employee.getLastName().replace(" ",""),domain);
        List<Employee> employees = employeeRepository.findByNameAndAndLastNameAndCountry(employee.getName(),
                employee.getLastName(),employee.getCountry());
        employee.setEmail(email.toLowerCase());
        if(!employees.isEmpty()){
            int size= employees.size();
            employee.setEmail((String.format(EMAIL_STRUCTURE,employee.getName(),employee.getLastName().replace(" ","")+"."+size,domain)).toLowerCase());
        }
        return employeeRepository.addEmployee(employee);
    }
    public void deleteEmployee(Long id) throws BusinessException {
        employeeRepository.deleteEmployee(id);
    }
    public List<Employee> getAll() {

        return  employeeRepository.getAll();
    }
}
