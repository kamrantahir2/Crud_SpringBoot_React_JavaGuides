package com.example.crud_springboot_react_javaguides.service;

import com.example.crud_springboot_react_javaguides.mapper.EmployeeMapper;
import com.example.crud_springboot_react_javaguides.model.Employee;
import com.example.crud_springboot_react_javaguides.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;


    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> employeeDtos = employees.stream()
                .map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
        return employeeDtos;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        return null;
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        return null;
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto) {
        return null;
    }

    @Override
    public void deleteEmployee(Long employeeId) {

    }
}