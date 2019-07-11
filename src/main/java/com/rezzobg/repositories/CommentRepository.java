package com.rezzobg.repositories;

import com.rezzobg.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    public void removeByPlaceId(Long id);
}
