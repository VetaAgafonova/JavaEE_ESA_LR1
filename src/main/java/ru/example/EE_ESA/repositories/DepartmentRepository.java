package ru.example.EE_ESA.repositories;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ejb.Stateless;
import ru.example.EE_ESA.models.Department;

import java.util.List;

@Stateless
public class DepartmentRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Department> findAll() {
        return em.createQuery("select i from Department i", Department.class).getResultList();
    }

    public void persist(Department department) {
        em.persist(department);
    }

    public void delete(Long id) {
        Department department = em.find(Department.class, id);
        em.remove(department);
    }
}
