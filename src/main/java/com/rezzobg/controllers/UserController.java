package com.rezzobg.controllers;

import com.rezzobg.dto.SignUpDTO;
import com.rezzobg.exceptions.UsernameExistsException;
import com.rezzobg.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public void signUp(@RequestBody SignUpDTO signUpDTO) throws UsernameExistsException {
         this.userService.signUp(signUpDTO);
    }

}
