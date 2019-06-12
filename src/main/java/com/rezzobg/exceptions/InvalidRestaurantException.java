package com.rezzobg.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "There is no such restaurant")
public class InvalidRestaurantException extends Exception {
    private static final long serialVersionUID = 297156767614160059L;

    public InvalidRestaurantException(String s) {
    }

    public InvalidRestaurantException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public InvalidRestaurantException(Throwable cause) {
        super(cause);
    }

    public InvalidRestaurantException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidRestaurantException() {
    }

    @Override
    public Throwable fillInStackTrace() {
        return null;
    }
}
