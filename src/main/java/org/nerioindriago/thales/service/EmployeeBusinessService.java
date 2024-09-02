package org.nerioindriago.thales.service;

import org.nerioindriago.thales.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeBusinessService {
    private final EmployeeService employeeService;
    private final SalaryService salaryService;

    public EmployeeBusinessService(EmployeeService employeeService, SalaryService salaryService) {
        this.employeeService = employeeService;
        this.salaryService = salaryService;
    }

    public Employee getEmployeeWithAnnualSalary(long id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            double annualSalary = salaryService.calculateAnnualSalary(employee.getEmployeeSalary());
            employee.setEmployeeAnnualSalary(annualSalary);
        }
        return employee;
    }
}
