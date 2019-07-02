package com.rezzobg.controllers;

import com.rezzobg.dto.CommentDTO;
import com.rezzobg.exceptions.BadRequestException;
import com.rezzobg.exceptions.UserIsNotLoggedInException;
import com.rezzobg.services.CommentService;
import com.rezzobg.services.UserStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("places/{placeId}")
    public Long addComment(@Valid @RequestBody CommentDTO commentDTO,
                           @PathVariable(required = true) Long placeId, HttpServletRequest request) throws
            BadRequestException, UserIsNotLoggedInException {
        if(UserStory.isUserLogged(request)) {
            return commentService.addComment(commentDTO, placeId, request);
        } else {
            throw new UserIsNotLoggedInException("User is not logged in!");
        }
    }
}
