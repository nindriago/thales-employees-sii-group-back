package org.nerioindriago.thales.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employeeName;
    private double employeeSalary;
    private double employeeAge;
    private double employeeAnnualSalary;

    public Employee(String employeeName, double employeeSalary, double employeeAge, double employeeAnnualSalary) {
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
        this.employeeAge = employeeAge;
        this.employeeAnnualSalary = employeeAnnualSalary;
    }

    public Employee() {

    }
}