package com.rezzobg.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.constraints.NotBlank;

@ResponseStatus(HttpStatus.IM_USED)
public class UsernameExistsException extends Throwable {
    public UsernameExistsException(@NotBlank(message = "Username is not long enough") String s) {
    }
}
