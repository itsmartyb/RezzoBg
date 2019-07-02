package com.rezzobg.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.IM_USED)
public class UsernameExistsException extends Exception {

    private static final long serialVersionUID = 2971549414844160059L;

    public UsernameExistsException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public UsernameExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

    public UsernameExistsException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public UsernameExistsException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public UsernameExistsException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Throwable fillInStackTrace() {
        return null;
    }
}
