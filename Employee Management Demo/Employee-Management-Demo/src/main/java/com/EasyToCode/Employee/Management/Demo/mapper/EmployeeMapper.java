package com.EasyToCode.Employee.Management.Demo.mapper;

import com.EasyToCode.Employee.Management.Demo.dto.EmployeeDto;
import com.EasyToCode.Employee.Management.Demo.dto.EmployeeRequestDto;
import com.EasyToCode.Employee.Management.Demo.model.Employee;
import org.springframework.stereotype.Service;


@Service
public class EmployeeMapper {

    public EmployeeDto employeeToDto(Employee employee) {
        // We first create our employee dto record, and return it
        EmployeeDto mappedEmployeeRecord = new EmployeeDto(
                employee.getId(),
                employee.getName(),
                employee.getSurName(),
                employee.getAge(),
                employee.getEmail(),
                employee.getTitle(),
                employee.getSalary()
        );

        return mappedEmployeeRecord;
    }

    public Employee employeeRequestDtoToEmployee(EmployeeRequestDto employeeRequestDto) {


        // Create empty employee
        Employee mappedEmployeeRecord = new Employee();

        // Map the fields
        mappedEmployeeRecord.setAge(employeeRequestDto.age());
        mappedEmployeeRecord.setEmail(employeeRequestDto.email());
        mappedEmployeeRecord.setName(employeeRequestDto.name());
        mappedEmployeeRecord.setSurName(employeeRequestDto.surName());
        mappedEmployeeRecord.setSalary(employeeRequestDto.salary());
        mappedEmployeeRecord.setTitle(employeeRequestDto.title());

        return mappedEmployeeRecord;
    }





}
