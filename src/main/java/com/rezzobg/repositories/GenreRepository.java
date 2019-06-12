package com.rezzobg.repositories;

import com.rezzobg.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    public List<Genre> findByClubId(Long id);
}
