package com.rezzobg.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class InvalidRestaurantException extends Exception {
    private static final long serialVersionUID = 297156767614160059L;

    public InvalidRestaurantException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public InvalidRestaurantException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

    public InvalidRestaurantException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public InvalidRestaurantException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public InvalidRestaurantException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Throwable fillInStackTrace() {
        return null;
    }
}
