package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    /**
     * GET /students - Listar todos los estudiantes
     */
    @GetMapping
    public List<Student> list() {
        return service.findAll();
    }

    /**
     * GET /students/{id} - Obtener un estudiante por ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Student> get(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * POST /students - Crear un nuevo estudiante
     */
    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student) {
        Student saved = service.save(student);
        return ResponseEntity.created(URI.create("/students/" + saved.getId())).body(saved);
    }

    /**
     * PUT /students/{id} - Actualizar un estudiante existente
     */
    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student studentDetails) {
        return service.findById(id)
                .map(student -> {
                    if (studentDetails.getName() != null) {
                        student.setName(studentDetails.getName());
                    }
                    if (studentDetails.getGrade() != null) {
                        student.setGrade(studentDetails.getGrade());
                    }
                    Student updated = service.save(student);
                    return ResponseEntity.ok(updated);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * DELETE /students/{id} - Eliminar un estudiante
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.findById(id).isPresent()) {
            service.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
