/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;

/**
 *
 * @author binod
 */
public class InvalidRequestException extends RuntimeException{
    

    private static final long serialVersionUID = -6657075052550800197L;

    private Errors errors;
    private ApiErrorResource errorResource;
    private HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;

    public InvalidRequestException(Errors errors) {
        this.errors = errors;

    }

    public InvalidRequestException(ApiErrorResource errors) {
        this.errorResource = errors;

    }

    public InvalidRequestException(Errors errors, HttpStatus status) {
        this.errors = errors;
        this.status = status;
    }

    public ApiErrorResource getErrorResrouce() {
        return errorResource;
    }

    public Errors getErrors() {
        return errors;
    }

    public HttpStatus getStatus() {
        return status;
    }


    
}
