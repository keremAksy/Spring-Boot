package com.EasyToCode.Employee.Management.Demo.controller;

import com.EasyToCode.Employee.Management.Demo.dto.EmployeeDto;
import com.EasyToCode.Employee.Management.Demo.dto.EmployeeRequestDto;
import com.EasyToCode.Employee.Management.Demo.exception.CommonErrorResponse;
import com.EasyToCode.Employee.Management.Demo.exception.NotFoundException;
import com.EasyToCode.Employee.Management.Demo.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/employees")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeService;

    @GetMapping(value="")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){

        List<EmployeeDto> allEmployees = employeeService.getAll();

        return new ResponseEntity<>(allEmployees, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable long id){

       EmployeeDto employee = employeeService.getById(id);

       if (employee == null){ // If exception handling is added, can be removed
           return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
       }

        return new ResponseEntity<EmployeeDto>(employee, HttpStatus.OK);
    }

    @PostMapping(value="")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeRequestDto employeeRequest){

        EmployeeDto employee = employeeService.createEmployee(employeeRequest);

        if (employee == null){ // If exception handling is added, can removed
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<EmployeeDto>(employee, HttpStatus.CREATED);
    }

    @PutMapping(value="{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable long id, @RequestBody EmployeeRequestDto employeeRequest){

        System.out.println(id);

        EmployeeDto employee = employeeService.updateEmployee(id,employeeRequest);

        if (employee == null){ // If exception handling is added, can removed
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<EmployeeDto>(employee, HttpStatus.OK);
    }


    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<CommonErrorResponse> handleNoSuchElementFoundException(NotFoundException exception) {

        // Creating our own error response for the client by using message from exception raised earlier
        CommonErrorResponse errorResponse = new CommonErrorResponse(HttpStatus.NOT_FOUND , exception.getMessage());

        // Creating a response entity to response the request with the error message
        ResponseEntity<CommonErrorResponse> responseEntity = new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);


        return responseEntity;
    }


}
