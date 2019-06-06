package com.rezzobg.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.IM_USED, reason = "User with such username already exists")
public class UsernameExistsException extends Exception {

    private static final long serialVersionUID = 2971549414844160059L;

    public UsernameExistsException(String s) {
    }

    public UsernameExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public UsernameExistsException(Throwable cause) {
        super(cause);
    }

    public UsernameExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameExistsException() {
    }

    @Override
    public Throwable fillInStackTrace() {
        return null;
    }
}
