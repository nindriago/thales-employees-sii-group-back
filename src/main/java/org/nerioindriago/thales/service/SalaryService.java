package org.nerioindriago.thales.service;

import org.springframework.stereotype.Service;

@Service
public class SalaryService {
    public double calculateAnnualSalary(double monthlySalary) {
        return monthlySalary * 12;
    }
}
