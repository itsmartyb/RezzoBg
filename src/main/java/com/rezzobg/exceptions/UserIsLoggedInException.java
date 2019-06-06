package com.rezzobg.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "User already logged out!")
public class UserIsLoggedInException extends Exception {
    private static final long serialVersionUID = 2971512679844160059L;

    public UserIsLoggedInException(String s) {
    }

    public UserIsLoggedInException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public UserIsLoggedInException(Throwable cause) {
        super(cause);
    }

    public UserIsLoggedInException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserIsLoggedInException() {
    }

    @Override
    public Throwable fillInStackTrace() {
        return null;
    }
}
