package org.nerioindriago.thales.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.nerioindriago.thales.model.Employee;
import org.nerioindriago.thales.repository.EmployeeRepository;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class EmployeeServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllEmployees() {
        Employee[] mockEmployees = {
                new Employee("John Doe", 1000.0, 61, 0),
                new Employee("Jane Doe", 2000.0, 24, 0)
        };

        when(restTemplate.getForObject("http://dummy.restapiexample.com/api/v1/employees", Employee[].class))
                .thenReturn(mockEmployees);

        Employee[] employees = employeeService.getAllEmployees();

        assertThat(employees).isNotNull();
        assertThat(employees.length).isEqualTo(2);
        assertThat(employees[0].getEmployeeName()).isEqualTo("John Doe");
    }

    @Test
    void testGetEmployeeById() {
        Employee mockEmployee = new Employee("John Doe", 1000.0, 61, 0);

        when(restTemplate.getForObject("http://dummy.restapiexample.com/api/v1/employee/1", Employee.class))
                .thenReturn(mockEmployee);

        Employee employee = employeeService.getEmployeeById(1L);

        assertThat(employee).isNotNull();
        assertThat(employee.getEmployeeName()).isEqualTo("John Doe");
    }

    @Test
    void testSaveEmployee() {
        Employee mockEmployee = new Employee("John Doe", 1000.0, 61, 0);

        when(employeeRepository.save(mockEmployee)).thenReturn(mockEmployee);

        Employee savedEmployee = employeeService.saveEmployee(mockEmployee);

        assertThat(savedEmployee).isNotNull();
    }
}
