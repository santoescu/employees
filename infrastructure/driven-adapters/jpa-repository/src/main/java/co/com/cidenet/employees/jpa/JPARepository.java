package co.com.cidenet.employees.jpa;

import co.com.cidenet.employees.jpa.data.EmployeeData;
import co.com.cidenet.employees.model.employee.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface JPARepository extends CrudRepository<EmployeeData, Long>, QueryByExampleExecutor<EmployeeData> {
    List<EmployeeData> findByNameAndAndLastNameAndCountry(String name,String lastName, String country);
}
