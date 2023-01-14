package co.com.cidenet.employees.jpa;

import co.com.cidenet.employees.jpa.data.EmployeeData;
import co.com.cidenet.employees.jpa.helper.AdapterOperations;
import co.com.cidenet.employees.model.employee.Employee;
import co.com.cidenet.employees.model.employee.gateways.EmployeeRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JPARepositoryAdapter extends AdapterOperations<Employee, EmployeeData, Long, JPARepository>
 implements EmployeeRepository
{

    public JPARepositoryAdapter(JPARepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Employee.class));
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return super.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
         repository.deleteById(id);
    }

    @Override
    public List<Employee> getAll() {
        return super.findAll();
    }
}
