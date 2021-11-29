package com.ower;

import com.ower.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringBoot09OrmCustomQueriesApplication {

    @Autowired
    EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot09OrmCustomQueriesApplication.class, args);
    }

    @PostConstruct
    public void testEmployee(){
        System.out.println(employeeRepository.getEmployeeDetail());
        System.out.println(employeeRepository.getEmployeeSalary());
        System.out.println(employeeRepository.getEmployeeByEmail("myakovlivf@ucsd.edu"));
        System.out.println(employeeRepository.getEmployeeByEmailAndSalary(75283, "abendelowg@google.com.hk"));
        System.out.println(employeeRepository.getEmployeesBySalary(114983));
        System.out.println(employeeRepository.getEmployeesByFirstNameOrSalary(114983, "Jodi"));

        employeeRepository.updateEmployeeJPQL(1);

        //named query
        System.out.println(employeeRepository.retrieveEmployeeSalaryGreaterThan(100000));
    }

}
