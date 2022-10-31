package com.yusuf.StudentManager.controller;


import com.yusuf.StudentManager.model.Student;
import com.yusuf.StudentManager.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @GetMapping("v1/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        final List<Student> students = service.getStudents();
        return new ResponseEntity<>(students,HttpStatus.OK);
    }

    @GetMapping("v1/student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") Long id){
        final Student student = service.findStudentById(id);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    @PostMapping("v1/student")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        final Student newStudent =  service.addStudent(student);
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }

    @PutMapping("v1/student")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        final Student updateStudent =  service.updateStudent(student);
        return new ResponseEntity<>(updateStudent,HttpStatus.OK);
    }

    @DeleteMapping("v1/student/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") Long id){
        service.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
