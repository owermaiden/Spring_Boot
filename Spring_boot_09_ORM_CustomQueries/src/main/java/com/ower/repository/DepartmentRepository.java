package com.ower.repository;

import com.ower.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {

    @Query("SELECT d FROM Department d WHERE d.division IN ?1")
    List<Department> getDepartmentByDivisionIn(List<String> division);

    //Named queries...Please look at jpa-named-queries.properties...................................................

    List<Department> retrieveDepartmentByDivision(String division);

    @Query(nativeQuery = true)
    List<Department> retrieveDepartmentByDivisionContains(String pattern);
    /*
    List<Department> findOzzyDepartment(String division);

    List<Department> countAllDepartments();

     */
}
