package com.cybertek.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String zipCode;

    @ManyToOne                                         // mappedBy cannot be used in Many to One...
    private Person person;

    public Address(String street, String zipCode) {
        this.street = street;
        this.zipCode = zipCode;
    }
}


// manytoOne yazınca otomatikman person_id koyuyor...Bunu mapped by ile silebilirdik..Ama ManytoOne da bu mümkün değil....

