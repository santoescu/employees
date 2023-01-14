package co.com.cidenet.employees.api;
import co.com.cidenet.employees.model.employee.Employee;
import co.com.cidenet.employees.model.exception.BusinessException;
import co.com.cidenet.employees.usecase.manageemployee.EmployeeManagementUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
    private final EmployeeManagementUseCase employeeManagementUseCase;

    @GetMapping(path = "/path")
    public String commandName() {
        return "Hello World";
    }
    @PostMapping(path = "/save-employee")
    public Employee saveEmployee(@RequestBody Employee employee) {

        return employeeManagementUseCase.addEmployee(employee);
    }
    @DeleteMapping(path = "/delete-employee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        try {
            employeeManagementUseCase.deleteEmployee(id);
        } catch (BusinessException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getDescription());
        }

        return ResponseEntity.ok("El Empleado " + id + " fue eliminado exitosamente");
    }
    @GetMapping(path = "/list")
    public List<Employee> getEmployees() {

        return employeeManagementUseCase.getAll();
    }
}
