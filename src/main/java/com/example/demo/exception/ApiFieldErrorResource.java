/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.exception;

import org.springframework.validation.FieldError;

/**
 *
 * @author binod
 */
class ApiFieldErrorResource extends ApiObjectErrorResource{
    

    private String field;
    private Object rejectedValue;

    public ApiFieldErrorResource(FieldError fieldError) {
        super(fieldError);
        this.field = fieldError.getField();
        this.rejectedValue = fieldError.getRejectedValue();

    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Object getRejectedValue() {
        return rejectedValue;
    }

    public void setRejectedValue(Object rejectedValue) {
        this.rejectedValue = rejectedValue;
    }


}
