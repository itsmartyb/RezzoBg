package com.rezzobg.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "There is no such place!")
public class InvalidPlaceException extends Exception {
    private static final long serialVersionUID = 297154967614140559L;

    public InvalidPlaceException(String s) {
    }

    public InvalidPlaceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public InvalidPlaceException(Throwable cause) {
        super(cause);
    }

    public InvalidPlaceException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidPlaceException() {
    }

    @Override
    public Throwable fillInStackTrace() {
        return null;
    }
}
