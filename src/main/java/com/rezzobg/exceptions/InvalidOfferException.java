package com.rezzobg.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "There is no such offer")
public class InvalidOfferException extends Exception {
    private static final long serialVersionUID = 297567867614160059L;

    public InvalidOfferException(String s) {
    }

    public InvalidOfferException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public InvalidOfferException(Throwable cause) {
        super(cause);
    }

    public InvalidOfferException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidOfferException() {
    }

    @Override
    public Throwable fillInStackTrace() {
        return null;
    }
}
