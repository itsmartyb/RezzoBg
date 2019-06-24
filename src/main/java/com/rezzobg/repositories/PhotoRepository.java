package com.rezzobg.repositories;

import com.rezzobg.models.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {
    public void save(List<Photo> photos);
    public Photo findByName(String name);
}
