package ru.example.EE_ESA.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ru.example.EE_ESA.repositories.DepartmentRepository;
import ru.example.EE_ESA.models.Department;

import java.util.List;

@Stateless
public class DepartmentService {

    @Inject
    private DepartmentRepository departmentRepository;

    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    public Long create(Department department) {
        departmentRepository.persist(department);
        return department.getId();
    }

    public void delete(Long id) {
        departmentRepository.delete(id);
    }

}
