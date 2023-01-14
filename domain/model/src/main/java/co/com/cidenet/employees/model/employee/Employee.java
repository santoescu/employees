package co.com.cidenet.employees.model.employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
   private Long id;
   private String name;
   private String surName;
   private String lastName;
   private String email;
   private String country;

}
