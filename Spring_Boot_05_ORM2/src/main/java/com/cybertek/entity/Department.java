package com.cybertek.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
@Getter
@Setter
@NoArgsConstructor
public class Department extends BaseEntity {    // this is child entity....

    private String department;
    private String division;

    /*
    @OneToOne(mappedBy = "department")  // do not put any foreign key in my table ... Employee is the owner...Business logic
    private Employee employee;
    */

    public Department(String department, String division) {
        this.department = department;
        this.division = division;
    }
}
