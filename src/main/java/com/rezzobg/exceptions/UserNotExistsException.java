package com.rezzobg.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User with such username/password does not exist!")
public class UserNotExistsException extends Exception {
    private static final long serialVersionUID = 297154957124160059L;

    public UserNotExistsException(String s) {
    }

    public UserNotExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public UserNotExistsException(Throwable cause) {
        super(cause);
    }

    public UserNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotExistsException() {
    }

    @Override
    public Throwable fillInStackTrace() {
        return null;
    }
}
