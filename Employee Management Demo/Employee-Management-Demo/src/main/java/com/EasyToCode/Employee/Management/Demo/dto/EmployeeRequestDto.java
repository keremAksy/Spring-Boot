package com.EasyToCode.Employee.Management.Demo.dto;

public record EmployeeRequestDto (
        String name,
        String surName,
        int age,
        String email,
        String title,
        Double salary
) {


}