package com.example.crud_springboot_react_javaguides.repository;

import com.example.crud_springboot_react_javaguides.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}