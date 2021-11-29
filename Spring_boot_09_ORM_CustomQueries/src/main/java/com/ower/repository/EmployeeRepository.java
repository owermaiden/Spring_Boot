package com.ower.repository;

import com.ower.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
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

    // Not equal
    @Query("SELECT e FROM Employee e WHERE e.salary <>:salary")
    List<Employee> getEmployeeBySlaryNotEquals(@Param("salary") int salary);

    // Like / Contains / Startswith / Ends With
    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE ?1")
    List<Employee> getEmployeeByFirstNameLike(String pattern);

    //Less Than
    @Query("SELECT e FROM Employee e WHERE e.salary < ?1")
    List<Employee> getEmployeeBySalaryLessThan(int salary);

    //Greater Than
    @Query("SELECT e FROM Employee e WHERE e.salary > ?1")
    List<Employee> getEmployeeBySalaryGreaterThan(Integer salary);

    //Between
    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN ?1 AND ?2")
    List<Employee> getEmployeeBySalaryBetween(int salary1,int salary2);

    //Before
    @Query("SELECT e FROM Employee e WHERE e.hireDate > ?1")
    List<Employee> getEmployeeByHireDateBefore(LocalDate date);

    //Null
    @Query("SELECT e FROM Employee e WHERE e.email IS NULL")
    List<Employee> getEmployeeByEmailIsNull();

    //Not Null
    @Query("SELECT e FROM Employee e WHERE e.email IS NOT NULL")
    List<Employee> getEmployeeByEmailIsNotNull();

    //Sort Salary in ascending order
    @Query("SELECT e FROM Employee e ORDER BY e.salary")
    List<Employee> getEmployeeBySalaryOrderByAsc();

    //Sort Salary in descending order
    @Query("SELECT e FROM Employee e ORDER BY e.salary DESC ")
    List<Employee> getEmployeeBySalaryOrderByDesc();

    @Modifying
    @Transactional
    @Query("UPDATE Employee e SET e.email ='admin@email.com' WHERE e.id=:id")
    void updateEmployeeJPQL(@Param("id") Integer id);

    //Native Query // Pure SQL --------------------------------------------------------------------native query---|

    @Query(value = "SELECT * FROM employees WHERE salary = ?1",nativeQuery = true )
    List<Employee> readEmployeeBySalary(int salary);

    @Modifying
    @Transactional
    @Query(value = "UPDATE employees SET email='admin@email.com' WHERE id=:id",nativeQuery = true)
    void updateEmployeeNativeQuery(@Param("id") Integer id);

    //Named Query
    List<Employee> retrieveEmployeeSalaryGreaterThan(Integer salary);



}
