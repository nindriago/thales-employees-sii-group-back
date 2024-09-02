package org.nerioindriago.thales.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SalaryServiceTests {
    private final SalaryService salaryService = new SalaryService();

    @Test
    void testCalculateAnnualSalary() {
        double monthlySalary = 1000.0;
        double expectedAnnualSalary = 12000.0;

        double actualAnnualSalary = salaryService.calculateAnnualSalary(monthlySalary);

        assertThat(actualAnnualSalary).isEqualTo(expectedAnnualSalary);
    }
}
