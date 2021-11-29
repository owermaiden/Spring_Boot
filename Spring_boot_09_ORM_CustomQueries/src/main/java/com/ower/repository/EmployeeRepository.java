package com.ower.repository;

import com.ower.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    @Query("SELECT e FROM Employee e WHERE e.email='sdubber7@t-online.de'")
    Employee getEmployeeDetail();


    @Query("SELECT e.salary FROM Employee e WHERE e.email = 'sdubber7@t-online.de'")
    Integer getEmployeeSalary();

    // single bind parameter
    @Query("SELECT e FROM Employee e WHERE e.email = ?1")
    Employee getEmployeeByEmail(String email);

    // multiple bind parameter
    @Query("SELECT e FROM Employee e WHERE e.salary=?1  AND e.email=?2")
    Employee getEmployeeByEmailAndSalary(Integer salary, String email);

    // single named parameter
    @Query("SELECT e FROM Employee e WHERE e.salary=:salary")
    List<Employee> getEmployeesBySalary(@Param("salary") int salary);

    // multiple named parameter
    @Query("SELECT e FROM Employee e WHERE e.firstName=:name OR e.salary=:salary")
    List<Employee> getEmployeesByFirstNameOrSalary(@Param("salary") int salary, @Param("name") String firstName);
 }
