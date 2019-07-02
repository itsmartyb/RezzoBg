package com.rezzobg.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class UserIsNotLoggedInException extends Exception {
    private static final long serialVersionUID = 2971512679844160567L;

    public UserIsNotLoggedInException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public UserIsNotLoggedInException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

    public UserIsNotLoggedInException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public UserIsNotLoggedInException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public UserIsNotLoggedInException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Throwable fillInStackTrace() {
        return null;
    }
}
