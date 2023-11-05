package com.example.crud_springboot_react_javaguides.mapper;

import com.example.crud_springboot_react_javaguides.model.Employee;
import com.example.crud_springboot_react_javaguides.service.EmployeeDto;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail());

        return employeeDto;
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(employeeDto.getId(), employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getEmail());

        return employee;
    }

}