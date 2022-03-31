package com.student.app.model.repr;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRepr implements Serializable {
    private static final long serialVersionUID = 2;
    private long id;
    private String firstName;
    private String lastName;
    private float grade;
    private String school;
}
