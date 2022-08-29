package com.ibetar.testingdemo.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class EmployeeAppExceptions extends RuntimeException {

    private String message;
    private HttpStatus httpStatus;


    public EmployeeAppExceptions(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
