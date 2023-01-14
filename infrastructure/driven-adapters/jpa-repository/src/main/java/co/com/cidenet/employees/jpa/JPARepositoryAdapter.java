package co.com.cidenet.employees.jpa;

import co.com.cidenet.employees.jpa.data.EmployeeData;
import co.com.cidenet.employees.jpa.helper.AdapterOperations;
import co.com.cidenet.employees.model.employee.Employee;
import co.com.cidenet.employees.model.employee.gateways.EmployeeRepository;
import co.com.cidenet.employees.model.exception.BusinessException;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public void deleteEmployee(Long id) throws BusinessException {
        Employee employee = super.findById(id);
        if(Objects.isNull(employee)){
           throw new BusinessException(404,"No se encontro el empleado " + id);
        }

        repository.deleteById(id);
    }

    @Override
    public List<Employee> getAll() {
        return super.findAll();
    }

    @Override
    public List<Employee> findByNameAndAndLastNameAndCountry(String name,String lastName, String country) {
        List<Employee> employees = new ArrayList<>();
        repository.findByNameAndAndLastNameAndCountry(name,lastName,country)
                .forEach(x -> employees.add(mapper.map(x,Employee.class)));

        return employees;
    }
}
