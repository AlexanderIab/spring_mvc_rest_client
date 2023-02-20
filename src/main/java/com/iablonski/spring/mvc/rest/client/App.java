package com.iablonski.spring.mvc.rest.client;

import com.iablonski.spring.mvc.rest.client.configuration.MyConfig;
import com.iablonski.spring.mvc.rest.client.entity.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App
{
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);
//        List<Student> allStudents = communication.getAllStudents();
//        System.out.println(allStudents);

//        Student byID = communication.getStudent(1);
//        System.out.println(byID);

//        Student student = new Student("John", "Doe", "Literature", 7);
//        student.setId(5);
//        communication.saveStudent(student);

//        communication.deleteStudent(6);

    }
}
