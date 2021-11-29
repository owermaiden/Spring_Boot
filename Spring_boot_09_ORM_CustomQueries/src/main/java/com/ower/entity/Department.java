package com.ower.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "departments")
@NoArgsConstructor
@Getter
@Setter
@ToString
// we created named query in entity
@NamedQuery(name="Department.findOzzyDepartment",
        query = "SELECT d FROM Department d WHERE d.division=?1")
@NamedNativeQuery(name="Department.countAllDepartments",
        query="SELECT * FROM departments",
        resultClass = Department.class)
public class Department {

    @Id
    private String department;
    private String division;

}