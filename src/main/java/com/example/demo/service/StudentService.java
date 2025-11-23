package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Optional<Student> findById(Long id) {
        return repository.findById(id);
    }

    public List<Student> findAll() {
        return repository.findAll();
    }

    public Student save(Student s) {
        return repository.save(s);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
