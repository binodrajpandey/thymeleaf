/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;

/**
 *
 * @author binod
 */
class ApiErrorResource extends ApiResponseResrouce{
    

    private boolean hasErrors = false;
    private boolean hasGlobalErrors = false;
    private boolean hasFieldErrors = false;
    private Map<String, ApiFieldErrorResource> fieldErrors = new HashMap<>();
    private List<ApiObjectErrorResource> globalErrors = new ArrayList<>();

    public ApiErrorResource(String resource, String code, String message, Object[] arguments, HttpStatus status) {
        super(status);
        addGlobalError(new ApiObjectErrorResource(resource, code, message, arguments));
    }

    public ApiErrorResource(String message, HttpStatus status) {
        super(status);
        addGlobalError(new ApiObjectErrorResource("", "", message, null));

    }

    public ApiErrorResource(String message) {
        this(message, HttpStatus.BAD_REQUEST);

    }

    public ApiErrorResource() {
        super(HttpStatus.BAD_REQUEST);
    }

    public ApiErrorResource(Errors errors) {
        this();
        fromErrors(errors);

    }

    private void fromErrors(Errors errors) {
        fieldErrors.clear();
        globalErrors.clear();
        if (errors.hasErrors()) {
            setHasErrors(errors.hasErrors());
            if (errors.hasGlobalErrors()) {
                errors.getGlobalErrors().forEach((ge) -> {
                    globalErrors.add(new ApiObjectErrorResource(ge));
                });
            }
            if (errors.hasFieldErrors()) {
                errors.getFieldErrors().forEach((fe) -> {
                    fieldErrors.put(fe.getField(), new ApiFieldErrorResource(fe));
                });
            }
        }
        setHasGlobalErrors(!globalErrors.isEmpty());
        setHasFieldErrors(!fieldErrors.isEmpty());

    }

    public Map<String, ApiFieldErrorResource> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(Map<String, ApiFieldErrorResource> fieldErrors) {
        this.fieldErrors = fieldErrors;
        setHasFieldErrors(!fieldErrors.isEmpty());
        setHasErrors(!fieldErrors.isEmpty());
    }

    public boolean isHasErrors() {
        return hasErrors;
    }

    public void setHasErrors(boolean hasErrors) {
        this.hasErrors = hasErrors;
    }

    public List<ApiObjectErrorResource> getGlobalErrors() {
        return globalErrors;
    }

    public void setGlobalErrors(List<ApiObjectErrorResource> globalErrors) {
        this.globalErrors = globalErrors;
        setHasGlobalErrors(!globalErrors.isEmpty());
        setHasErrors(!globalErrors.isEmpty());

    }

    public boolean isHasFieldErrors() {
        return hasFieldErrors;
    }

    public void setHasFieldErrors(boolean hasFieldErrors) {
        this.hasFieldErrors = hasFieldErrors;
    }

    public boolean isHasGlobalErrors() {
        return hasGlobalErrors;
    }

    public void setHasGlobalErrors(boolean hasGlobalErrors) {
        this.hasGlobalErrors = hasGlobalErrors;
    }

    public void addFieldError(ApiFieldErrorResource error) {
        fieldErrors.put(error.getField(), error);
        setHasFieldErrors(true);
        setHasErrors(true);
    }

    public void addGlobalError(ApiObjectErrorResource error) {
        globalErrors.add(error);
        setHasGlobalErrors(true);
        setHasErrors(true);
    }


}
