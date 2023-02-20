package com.iablonski.spring.mvc.rest.client.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Student {

    private int id;
    private String name;
    private String surname;
    private String faculty;
    private int grade;

    public Student(String name, String surname, String faculty, int grade) {
        this.name = name;
        this.surname = surname;
        this.faculty = faculty;
        this.grade = grade;
    }
}
