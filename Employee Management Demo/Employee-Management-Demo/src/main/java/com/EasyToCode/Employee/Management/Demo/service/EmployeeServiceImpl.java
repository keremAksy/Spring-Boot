package com.EasyToCode.Employee.Management.Demo.service;


import com.EasyToCode.Employee.Management.Demo.dto.EmployeeDto;
import com.EasyToCode.Employee.Management.Demo.dto.EmployeeRequestDto;
import com.EasyToCode.Employee.Management.Demo.exception.CommonErrorResponse;
import com.EasyToCode.Employee.Management.Demo.exception.NotFoundException;
import com.EasyToCode.Employee.Management.Demo.mapper.EmployeeMapper;
import com.EasyToCode.Employee.Management.Demo.model.Employee;
import com.EasyToCode.Employee.Management.Demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    public List<EmployeeDto> getAll() {

        List<EmployeeDto> employees = employeeRepository.findAll() // Get all employees from database
                                                        .stream() // Stream it
                                                        .map(employee -> employeeMapper.employeeToDto(employee))  // Map them to dtos
                                                        .collect(Collectors.toList()); //COllect them and put it into a list

        return employees;
    }

    @Override
    public EmployeeDto getById(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        if (employee.isPresent()) {  // If employee exists
            return employeeMapper.employeeToDto(employee.get());
        } else {
            throw new NotFoundException("Employee with id: " + id + "not found! Please give a valid id.");
        }

    }

    @Override
    public EmployeeDto createEmployee(EmployeeRequestDto employeeRequest) {

        Employee employee = employeeMapper.employeeRequestDtoToEmployee(employeeRequest);


        EmployeeDto employeeDto = employeeMapper.employeeToDto(
                employeeRepository.save(employee)
        );

        return employeeDto;
    }

    @Override
    public EmployeeDto updateEmployee(long id, EmployeeRequestDto employeeRequest) {

        // If employee does not exist
        if (!employeeRepository.findById(id).isPresent()){
            return null;
        }

        // Mapping dto to employee and setting the id field
        Employee employee = employeeMapper.employeeRequestDtoToEmployee(employeeRequest);
        employee.setId(id);


        Employee employeeUpdated = employeeRepository.save(employee);

        return employeeMapper.employeeToDto(employeeUpdated);
    }


}
