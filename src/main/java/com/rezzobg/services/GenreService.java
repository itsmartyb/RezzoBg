package com.rezzobg.services;

import com.rezzobg.models.Genre;
import com.rezzobg.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;

    public Genre saveGenre(Genre genre) {
        return this.genreRepository.save(genre);
    }

    public void saveAll(Set<Genre> kitchens) {
        this.genreRepository.saveAll(kitchens);
    }


    public boolean isInDatabase(Genre genre) {
        return genreRepository.findById(genre.getId()) != null;
    }
}
