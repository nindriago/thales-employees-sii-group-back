package org.nerioindriago.thales.repository;

import org.nerioindriago.thales.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}