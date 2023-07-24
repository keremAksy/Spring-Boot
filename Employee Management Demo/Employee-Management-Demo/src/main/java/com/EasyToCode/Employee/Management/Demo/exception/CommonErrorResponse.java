package com.EasyToCode.Employee.Management.Demo.exception;

import org.springframework.http.HttpStatus;

public record CommonErrorResponse (
        HttpStatus status,
        String message
){
}
