package ru.example.EE_ESA.repositories;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ejb.Stateless;
import ru.example.EE_ESA.models.Student;

import java.util.List;

@Stateless
public class StudentRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Student> findAll() {
        return em.createQuery("select i from Student i", Student.class).getResultList();
    }

    public void persist(Student student) {
        em.persist(student);
    }

    public void delete(Long id) {
        Student student = em.find(Student.class, id);
        em.remove(student);
    }
}
