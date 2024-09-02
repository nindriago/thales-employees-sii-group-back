package org.nerioindriago.thales.controller;

import org.nerioindriago.thales.model.Employee;
import org.nerioindriago.thales.service.EmployeeBusinessService;
import org.nerioindriago.thales.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeBusinessService employeeBusinessService;

    public EmployeeController(EmployeeService employeeService, EmployeeBusinessService employeeBusinessService) {
        this.employeeService = employeeService;
        this.employeeBusinessService = employeeBusinessService;
    }
    @GetMapping
    public List<Employee> getAllEmployees() {
        return List.of(employeeService.getAllEmployees()).stream()
                .map(employee -> employeeBusinessService.getEmployeeWithAnnualSalary(employee.getId()))
                .collect(Collectors.toList());    }

    @GetMapping("{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeBusinessService.getEmployeeWithAnnualSalary(id);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }
}