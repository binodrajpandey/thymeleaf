/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.exception;

import org.springframework.http.HttpStatus;

/**
 *
 * @author binod
 */
class ApiResponseResrouce {
    

    protected String status = HttpStatus.OK.getReasonPhrase();

    public ApiResponseResrouce() {
    }

    public ApiResponseResrouce(HttpStatus httpStatus) {
        this.status = httpStatus.getReasonPhrase();
    }

    public ApiResponseResrouce(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
