package com.rezzobg.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "There is no such event")
public class InvalidEventException extends Exception {
    private static final long serialVersionUID = 245867867614160059L;

    public InvalidEventException(String s) {
    }

    public InvalidEventException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public InvalidEventException(Throwable cause) {
        super(cause);
    }

    public InvalidEventException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidEventException() {
    }

    @Override
    public Throwable fillInStackTrace() {
        return null;
    }
}
