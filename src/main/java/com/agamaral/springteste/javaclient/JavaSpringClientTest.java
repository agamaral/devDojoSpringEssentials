package com.agamaral.springteste.javaclient;

import com.agamaral.springteste.model.Student;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * @author Antonio Amaral
 */
public class JavaSpringClientTest {
    public static void main(String[] args){
        RestTemplate restTemplate = new RestTemplateBuilder()
                .rootUri("http://localhost:8080/v1/protected/students")
                .basicAuthentication("Nubia", "Helena")
                .build();
        Student student = restTemplate.getForObject("/{id}", Student.class, 1);
        ResponseEntity<Student> forEntity = restTemplate.getForEntity("/{id}", Student.class, 1);
        System.out.println(student);
        System.out.println(forEntity.getBody());
        Student[] students = restTemplate.getForObject("/", Student[].class);
        System.out.println(Arrays.toString(students));
    }
}
