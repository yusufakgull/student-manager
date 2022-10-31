package com.yusuf.StudentManager.service;


import com.yusuf.StudentManager.exception.StudentNotFoundException;
import com.yusuf.StudentManager.model.Student;
import com.yusuf.StudentManager.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repository;

    public Student addStudent(Student student) {
        student.setStudentCode(UUID.randomUUID().toString());
        return repository.save(student);
    }

    public List<Student> getStudents() {
        return repository.findAll();
    }

    public Student updateStudent(Student student) {
        return repository.save(student);
    }

    public Student findStudentById(Long id) {
        return repository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student by id " + id + " was not found."));
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}
