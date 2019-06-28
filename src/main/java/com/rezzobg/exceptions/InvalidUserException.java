package com.rezzobg.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "This user has no rights for this operation")
public class InvalidUserException extends Exception {
    private static final long serialVersionUID = 2651129414844160059L;

    public InvalidUserException(String s) {
    }

    public InvalidUserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public InvalidUserException(Throwable cause) {
        super(cause);
    }

    public InvalidUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidUserException() {
    }

    @Override
    public Throwable fillInStackTrace() {
        return null;
    }
}
