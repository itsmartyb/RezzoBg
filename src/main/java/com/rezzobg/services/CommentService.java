package com.rezzobg.services;

import com.rezzobg.dto.CommentDTO;
import com.rezzobg.exceptions.BadRequestException;
import com.rezzobg.models.Comment;
import com.rezzobg.models.Place;
import com.rezzobg.models.User;
import com.rezzobg.repositories.CommentRepository;
import com.rezzobg.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PlaceRepository placeRepository;

    public Long addComment(CommentDTO commentDTO, Long placeId, HttpServletRequest request) throws BadRequestException {
        Long userId = (Long) request.getSession().getAttribute("userId");
        Optional<User> user = userService.findById(userId);
        java.util.Date today = new java.util.Date();
        Place place = null;
        try {
             place = placeRepository.findById(placeId).get();
        } catch(Exception e) {
            throw new BadRequestException("Invalid page!");
        }
        Comment comment = new Comment(null, commentDTO.getText(), LocalDate.now(),commentDTO.getRating(),
                new java.sql.Time(today.getTime()),user.get(), place);
        Long id = commentRepository.save(comment).getId();
        place = placeRepository.findById(placeId).get();
        place.setRating(PlaceService.calculatePlaceRating(place));
        placeRepository.save(place);
        return id;
    }

}
