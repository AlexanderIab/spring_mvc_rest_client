package com.iablonski.spring.mvc.rest.client;

import com.iablonski.spring.mvc.rest.client.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {

    private RestTemplate restTemplate;
    private static final String URL = "http://localhost:8080/spring_mvc_rest/api/students";

    public List<Student> getAllStudents() {
        ResponseEntity<List<Student>> responseEntity =
                restTemplate
                        .exchange(URL, HttpMethod.GET,
                                null, new ParameterizedTypeReference<List<Student>>() {
                                });
        return responseEntity.getBody();
    }

    public Student getStudent(int id) {
        return restTemplate.getForObject(URL + "/" + id, Student.class);
    }

    public void saveStudent(Student student) {
        int id = student.getId();
        if (id == 0) {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL, student, String.class);
            System.out.println("New student was added to Database");
            System.out.println(responseEntity.getBody());
        }
        restTemplate.put(URL, student);
        System.out.println("Student with ID = " + id + " was updated");
    }

    public void deleteStudent(int id) {
        restTemplate.delete(URL + "/" + id);
        System.out.println("Student with ID = " + id + " was deleted from Database");
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
