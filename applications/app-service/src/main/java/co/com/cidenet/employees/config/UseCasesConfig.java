package co.com.cidenet.employees.config;

import co.com.cidenet.employees.model.employee.gateways.EmployeeRepository;
import co.com.cidenet.employees.usecase.manageemployee.EmployeeManagementUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class UseCasesConfig {
        @Bean
        public EmployeeManagementUseCase employeeManagementUseCase(EmployeeRepository mutantRepository){
                return new EmployeeManagementUseCase(mutantRepository);
        }
}
