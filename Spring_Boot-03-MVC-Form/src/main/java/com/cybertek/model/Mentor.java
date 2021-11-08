package com.cybertek.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Mentor {
    private String firstName;
    private String lastName;
    private String eMail;
    private String gender;
    private boolean graduated;
    private String batch;
    private String company;

}
