package com.cybertek.model;

import com.cybertek.enums.AddressType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "teacher"},ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)  // temperature comes null at first... that is why we add this line.. Non-Null olanları dahil et sadece diyor
public class Address extends BaseEntity {


    private String street;
    private String country;
    private String state;
    private String city;

    @Column(name = "postal_code")
    private String postalCode;

    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private Parent parent;

    @OneToOne(mappedBy = "address")
    private Teacher teacher;

    @OneToOne(mappedBy = "address")
    @JsonBackReference   // dont show this student in address api
    private Student student;

    private Integer currentTemperature;

    private Integer currentTemperature(){
        return consumeTemp(this.city);
    }

    public Integer consumeTemp(String city){
        return 5;
    }





}
