package com.ower.repository;

import com.ower.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {

    //Display all departments in the Furniture Department
    List<Department> findByDepartment(String department);

    //Display all departments in the Health Division
    List<Department> findDepartmentsByDivision(String division);
    List<Department> findByDivisionIs(String division);
    List<Department> findByDivisionEquals(String division);

    //Display all departments with division name ends with 'ics'
    List<Department> findDepartmentsByDivisionEndingWith(String pattern);

    //Display top 3 departments with division name includes 'Hea',without duplicates
    List<Department> findDistinctTop3ByDivisionContaining(String pattern);


}
