package com.example.crud_springboot_react_javaguides.service;

import com.example.crud_springboot_react_javaguides.exception.ResourceNotFoundException;
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
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + employeeId));
        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        return employeeDto;
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto) {
        Employee existingEmployee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + employeeId));
        existingEmployee.setFirstName(employeeDto.getFirstName());
        existingEmployee.setLastName(employeeDto.getLastName());
        existingEmployee.setEmail(employeeDto.getEmail());

        employeeRepository.save(existingEmployee);
        return EmployeeMapper.mapToEmployeeDto(existingEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee existingEmployee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + employeeId));

        employeeRepository.delete(existingEmployee);
    }
}