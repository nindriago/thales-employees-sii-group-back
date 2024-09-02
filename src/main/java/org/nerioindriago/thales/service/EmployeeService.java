package org.nerioindriago.thales.service;

import org.nerioindriago.thales.model.Employee;
import org.nerioindriago.thales.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class EmployeeService {

    private final RestTemplate restTemplate;
    private final EmployeeRepository employeeRepository;
    private final String API_URL = "http://dummy.restapiexample.com/api/v1";

    public EmployeeService(RestTemplate restTemplate, EmployeeRepository employeeRepository) {
        this.restTemplate = restTemplate;
        this.employeeRepository = employeeRepository;
    }

    public Employee[] getAllEmployees() {
        try {
            return restTemplate.getForObject(API_URL + "/employees", Employee[].class);
        } catch (RestClientException e) {
            List<Employee> employees = employeeRepository.findAll();
            return employees.toArray(new Employee[0]);
        }
    }

    public Employee getEmployeeById(long id) {
        try {
            return restTemplate.getForObject(API_URL + "/employee/" + id, Employee.class);
        } catch (RestClientException e) {
            return employeeRepository.findById(id).orElse(null);
        }
    }

    @Transactional
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
