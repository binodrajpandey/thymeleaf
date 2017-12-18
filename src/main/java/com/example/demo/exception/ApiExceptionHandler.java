/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author binod
 */
@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{
    

    @ExceptionHandler(InvalidRequestException.class)
    protected ResponseEntity<?> handleInvalidRequest(RuntimeException e, WebRequest request) {
        InvalidRequestException ire = (InvalidRequestException) e;
        ApiErrorResource errors = null;
        if (ire.getErrorResrouce() != null) {
            errors = ire.getErrorResrouce();
        } else {
            errors = new ApiErrorResource(ire.getErrors());
        }
        errors.setStatus(ire.getStatus().getReasonPhrase());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return handleExceptionInternal(e, errors, headers, ire.getStatus(), request);
    }


}
