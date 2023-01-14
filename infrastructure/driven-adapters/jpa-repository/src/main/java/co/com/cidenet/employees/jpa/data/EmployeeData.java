package co.com.cidenet.employees.jpa.data;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employee")
public class EmployeeData {
    @Id
    @SequenceGenerator(name = "pmgd_document_type_dctp_id_generator",
            sequenceName = "pmgd_document_type_s", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pmgd_document_type_dctp_id_generator")
    @Column(name = "id", nullable = false, precision = 8)
    private Long id;
    @Column
    private String name;
    @Column
    private String surName;
    @Column
    private String lastName;
    @Column
    private String email;
    @Column
    private String country;
}
