package com.rezzobg.exceptions;

public class InvalidPasswordException extends Exception {
    private static final long serialVersionUID = 2971549679844160059L;

    public InvalidPasswordException(String s) {
    }

    public InvalidPasswordException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public InvalidPasswordException(Throwable cause) {
        super(cause);
    }

    public InvalidPasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidPasswordException() {
    }

    @Override
    public Throwable fillInStackTrace() {
        return null;
    }
}
