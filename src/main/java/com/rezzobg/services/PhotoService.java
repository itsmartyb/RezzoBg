package com.rezzobg.services;

import com.rezzobg.models.Photo;
import com.rezzobg.repositories.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    public List<Photo> saveAll(List<Photo> photos) {
        return this.photoRepository.saveAll(photos);
    }

    public Photo savePhoto(Photo photo) {
        return this.photoRepository.save(photo);
    }
}
