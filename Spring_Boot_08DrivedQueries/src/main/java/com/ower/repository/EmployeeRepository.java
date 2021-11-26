package com.ower.repository;

import com.ower.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //Display all employees with email address ''
    List<Employee> findEmployeesByEmail(String email);

    //Display all employees with first name '' and last name '', also show all employees with a email address ''
    List<Employee> findEmployeesByFirstNameAndLastNameOrEmail(String firstname, String lastname, String email);

    //Display all employees that first name is not ''
    List<Employee> findEmployeesByFirstNameIsNot(String firstname);

    //Display all employees where last name starts with ''
    List<Employee> findEmployeesByLastNameStartingWith(String pattern);

    //Display all employees with salaries higher than ''
    List<Employee> findEmployeesBySalaryIsGreaterThan(Integer salary);

    //Display all employees with salaries less than ''
    List<Employee> findEmployeesBySalaryIsLessThanEqual(Integer salary);

    //Display all employees that has been hired between '' and ''
    List<Employee> findEmployeesByHireDateBetween(LocalDate startDate, LocalDate endDate);

    //Display all employees where salaries greater and equal to '' in order
    List<Employee> findBySalaryIsGreaterThanEqualOrderBySalaryDesc(Integer salary);

    //Display top unique 3 employees that is making less than ''
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    //Display all employees that do not have email address
    List<Employee> findByEmailIsNull();
}
