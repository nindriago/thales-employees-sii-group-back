package org.nerioindriago.thales.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.nerioindriago.thales.model.Employee;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class EmployeeBusinessServiceTests {
    @Mock
    private EmployeeService employeeService;

    @Mock
    private SalaryService salaryService;

    @InjectMocks
    private EmployeeBusinessService employeeBusinessService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetEmployeeWithAnnualSalary() {
        Employee mockEmployee = new Employee("John Doe", 1000.0, 24, 0);
        double annualSalary = 12000.0;

        when(employeeService.getEmployeeById(1L)).thenReturn(mockEmployee);
        when(salaryService.calculateAnnualSalary(mockEmployee.getEmployeeSalary())).thenReturn(annualSalary);

        Employee employee = employeeBusinessService.getEmployeeWithAnnualSalary(1L);

        assertThat(employee).isNotNull();
        assertThat(employee.getEmployeeName()).isEqualTo("John Doe");
        assertThat(employee.getEmployeeAnnualSalary()).isEqualTo(annualSalary);
    }
}
