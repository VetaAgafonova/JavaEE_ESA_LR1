package ru.example.EE_ESA.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ru.example.EE_ESA.repositories.StudentRepository;
import ru.example.EE_ESA.models.Student;

import java.util.List;

@Stateless
public class StudentService {

    @Inject
    private StudentRepository studentRepository;

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Long create(Student student) {
        studentRepository.persist(student);
        return student.getId();
    }

    public void delete(Long id) {
        studentRepository.delete(id);
    }
}

