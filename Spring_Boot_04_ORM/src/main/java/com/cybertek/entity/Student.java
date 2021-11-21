package com.cybertek.entity;

import com.cybertek.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "studentFirstName")
    private String firstName;
    private String lastName;
    private String email;

    @Transient            // we dont want it to be in the table column...
    private String city;

    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Temporal(TemporalType.TIME)        // This is old java date-time....
    private Date birthTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDateTime;

    @Column(columnDefinition = "DATE")
    private LocalDate localDate;         // LocalDate come with Java8
    @Column(columnDefinition = "TIME")
    private LocalDate localTime;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate localDateTime;

    @Enumerated(EnumType.STRING)   // Bunu yazmazsak enum type Ordinal alır ve 0 and 1 alır değerleri....
    private Gender gender;

}
