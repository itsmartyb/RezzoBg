package com.rezzobg.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotExistsException extends Exception {
    private static final long serialVersionUID = 297154957124160059L;

    public UserNotExistsException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public UserNotExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

    public UserNotExistsException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public UserNotExistsException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public UserNotExistsException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Throwable fillInStackTrace() {
        return null;
    }
}
