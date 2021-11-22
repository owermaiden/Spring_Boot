package com.cybertek.bootstrap;

import com.cybertek.entity.Department;
import com.cybertek.entity.Employee;
import com.cybertek.entity.Region;
import com.cybertek.enums.Gender;
import com.cybertek.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataGenerator implements CommandLineRunner {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {

        List<Employee> employeesList = new ArrayList<>();

        Employee e1 = new Employee("Berrie", "Manueau", "bmanueau0@dion.ne.jp", LocalDate.of(2006,04,20) , Gender.F, 4);
        Employee e2 = new Employee("Aeriell", "McNee", "amcnee1@google.es", LocalDate.of(2009,01,26), Gender.F, 3);
        Employee e3 = new Employee("Sydney", "Symonds", "ssymonds2@hhs.gov", LocalDate.of(2010,05,17), Gender.F, 4);
        Employee e4 = new Employee("Avrom", "Rowantree", null, LocalDate.of(2014,06,02), Gender.M, 7);
        Employee e5 = new Employee("Feliks", "Morffew", "fmorffew4@a8.net", LocalDate.of(2003,01,14), Gender.M, 5);

        Department d1 = new Department("Sports","Outdoors");
        Department d2 = new Department("Tools","Hardware");
        Department d3 = new Department("Clothing","Home");
        Department d4 = new Department("Phones & Tablets","Electronics");
        Department d5 = new Department("Computers","Electronics");

        Region r1 = new Region("Southwest", "United States");
        Region r2 = new Region("Northwest", "United States");
        Region r3 = new Region("Central", "Asia");
        Region r4 = new Region("Quebec", "Canada");
        Region r5 = new Region("Nova Scotia", "Canada");


        e1.setDepartment(d1);
        e2.setDepartment(d1);
        e3.setDepartment(d1);
        e4.setDepartment(d4);
        e5.setDepartment(d5);

        e1.setRegion(r1);
        e2.setRegion(r2);
        e3.setRegion(r3);
        e4.setRegion(r4);
        e5.setRegion(r5);

        employeesList.addAll(Arrays.asList(e1,e2,e3,e4,e5));

        employeeRepository.saveAll(employeesList);
        // departmentRepository.saveAll(departmentList);

        employeeRepository.deleteById(1);



    }
}
