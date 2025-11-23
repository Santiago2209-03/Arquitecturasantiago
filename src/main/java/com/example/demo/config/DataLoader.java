package com.example.demo.config;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(StudentRepository repo) {
        return args -> {
            try {
                if (repo.count() == 0) {
                    repo.save(new Student("Juan García", 85.5));
                    repo.save(new Student("María López", 92.0));
                    repo.save(new Student("Ana Martínez", 88.5));
                }
                System.out.println("✅ Estudiantes cargados exitosamente");
            } catch (Exception e) {
                System.err.println("⚠️  DataLoader: No se pudieron cargar los datos iniciales: " + e.getMessage());
            }
        };
    }
}
