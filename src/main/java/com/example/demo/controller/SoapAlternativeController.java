package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/soap-alt")
public class SoapAlternativeController {

    private final StudentService service;

    public SoapAlternativeController(StudentService service) {
        this.service = service;
    }

    /**
     * Alternativa JSON a SOAP - Obtener estudiante por ID
     */
    @GetMapping("/student/{id}")
    public ResponseEntity<?> getStudent(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
