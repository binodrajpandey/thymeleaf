/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.exception;

import org.springframework.validation.ObjectError;

/**
 *
 * @author binod
 */
class ApiObjectErrorResource {
    

    private String resource;
    private String code;
    private String defaultMessage;
    private Object[] arguments;

    public ApiObjectErrorResource(String resource, String code, String defaultMessage, Object[] arguments) {
        this.resource = resource;
        this.code = code;
        this.defaultMessage = defaultMessage;
        this.arguments = arguments;

    }

    public ApiObjectErrorResource(ObjectError ge) {
        this.resource = ge.getObjectName();
        this.code = ge.getCode();
        this.defaultMessage = ge.getDefaultMessage();
        this.arguments = ge.getArguments();
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    public Object[] getArguments() {
        return arguments;
    }

    public void setArguments(Object[] arguments) {
        this.arguments = arguments;
    }


}
