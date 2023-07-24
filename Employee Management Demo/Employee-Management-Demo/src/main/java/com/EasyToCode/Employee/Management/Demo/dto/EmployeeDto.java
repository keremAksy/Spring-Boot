package com.EasyToCode.Employee.Management.Demo.dto;

public record EmployeeDto (
        long id,
        String name,
        String surName,
        int age,
        String email,
        String title,
        Double salary
    ) {


}

