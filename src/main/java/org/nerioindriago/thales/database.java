package org.nerioindriago.thales;

import org.nerioindriago.thales.model.Employee;
import org.nerioindriago.thales.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class database {
    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {
        return args -> {
            repository.save(new Employee("John Doe", 1000, 61, 0));
            repository.save(new Employee("Jane Doe", 2000, 23, 0));
            repository.save(new Employee("Dory Doe", 5000, 42, 0));
            repository.save(new Employee("Iron Doe", 1800, 37, 0));
            repository.save(new Employee("Bruce Doe", 4000, 34, 0));
        };
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
