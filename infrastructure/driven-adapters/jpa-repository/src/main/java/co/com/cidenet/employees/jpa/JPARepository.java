package co.com.cidenet.employees.jpa;

import co.com.cidenet.employees.jpa.data.EmployeeData;
import co.com.cidenet.employees.model.employee.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPARepository extends CrudRepository<EmployeeData, Long>, QueryByExampleExecutor<EmployeeData> {
}
