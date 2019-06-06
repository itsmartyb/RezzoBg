package com.rezzobg.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler({ Exception.class})
    public void handleException(Exception e) throws Exception {
        throw e;
    }
}
