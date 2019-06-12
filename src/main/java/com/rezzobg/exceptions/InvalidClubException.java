package com.rezzobg.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "There is no such club!")
public class InvalidClubException extends Exception {
    private static final long serialVersionUID = 297154967614160059L;

    public InvalidClubException(String s) {
    }

    public InvalidClubException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public InvalidClubException(Throwable cause) {
        super(cause);
    }

    public InvalidClubException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidClubException() {
    }

    @Override
    public Throwable fillInStackTrace() {
        return null;
    }
}
