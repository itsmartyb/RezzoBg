package com.rezzobg.controllers;

import com.rezzobg.dto.LoginDTO;
import com.rezzobg.dto.SignUpDTO;
import com.rezzobg.exceptions.*;
import com.rezzobg.models.User;
import com.rezzobg.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public void signUp(@Valid @RequestBody SignUpDTO signUpDTO, HttpServletResponse response) throws Exception {
        this.userService.signUp(signUpDTO);
    }

    @PostMapping("/login")
    public void login(@Valid @RequestBody LoginDTO loginDTO, HttpServletRequest request) throws BadRequestException, UserNotExistsException, InvalidPasswordException {
        HttpSession session = request.getSession();
        if (session.getAttribute("userId") != null) {
            throw new BadRequestException("The user is already logged in!");
        }
        User user  = this.userService.login(loginDTO);
        session.setAttribute("userId", user.getId());
        session.setAttribute("isAdmin", user.isAdmin());
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request) throws UserIsLoggedInException {
        HttpSession session = request.getSession();
        if(session.getAttribute("userId") == null) {
            throw new UserIsLoggedInException();
        }
        session.invalidate();
    }
}
