package com.rezzobg.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidPasswordException extends Exception {
    private static final long serialVersionUID = 2971549679844160059L;

    public InvalidPasswordException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public InvalidPasswordException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

    public InvalidPasswordException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public InvalidPasswordException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public InvalidPasswordException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Throwable fillInStackTrace() {
        return null;
    }
}
