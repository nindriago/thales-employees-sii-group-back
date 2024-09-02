package org.nerioindriago.thales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class EmployeeAppApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(EmployeeAppApplication.class, args);
    }
}