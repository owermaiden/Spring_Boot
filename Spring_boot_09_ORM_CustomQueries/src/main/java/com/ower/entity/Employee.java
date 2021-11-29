package com.ower.entity;

import com.ower.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

//@Entity(name="Employees").....böyle de yazabiliriz..Entity name değişmiş olur...Query de Employees kullanırız....
@Entity
@Table(name = "employees")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Employee extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(columnDefinition = "DATE")
    private LocalDate hireDate;

    // we dont need to add cascade type because if you look at data.sql  department is already inserted and we dont need explicitly add cascade
    @ManyToOne
    @JoinColumn(name = "department")
    private Department department;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Integer salary;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

}

