package com.EasyToCode.Employee.Management.Demo.service;

import com.EasyToCode.Employee.Management.Demo.dto.EmployeeDto;
import com.EasyToCode.Employee.Management.Demo.dto.EmployeeRequestDto;

import java.util.List;

public interface EmployeService {
    public List<EmployeeDto> getAll();

    public EmployeeDto getById(long id);

    EmployeeDto createEmployee(EmployeeRequestDto employeeRequest);

    EmployeeDto updateEmployee(long id ,EmployeeRequestDto employeeRequest);
}
