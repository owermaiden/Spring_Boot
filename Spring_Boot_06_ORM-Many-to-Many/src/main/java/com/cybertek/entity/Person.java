package com.cybertek.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL)      // mapped by means..Dont create new joinTable for me... Person table will handle this...
    private List<Address> address;                                 // One to many needs adress list...Because we say there are more than one adresses

    //@OneToMany(cascade = CascadeType.ALL)  // cascade type yazmazsak "org.hibernate.TransientObjectException: object references an unsaved transient instance" bu hatayı alırız...
    //@JoinColumn(name = "person_id")
    //private List<Address> address;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}

// One to Many olduğu için buraya bir List vermemiz lazım... tek obje kabul etmiyor...
// eğer mappedBy koymazsak yeni bir join table oluşturuyor. Bu sefer 2 tane primary key oluşuyor..Bunu istemiyoruz..O yüzden mappedBy=person
// Cascade.ALL --> first create the child object and then creating the parent object...
