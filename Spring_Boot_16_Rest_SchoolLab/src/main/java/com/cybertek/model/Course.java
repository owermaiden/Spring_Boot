package com.cybertek.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "course")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value={"hibernateLazyInitializer"},ignoreUnknown = true)
public class Course extends BaseEntity{

    private String name;

    @Column(columnDefinition = "text")  // it gives advantage of unlimeted text...
    private String description;
}
