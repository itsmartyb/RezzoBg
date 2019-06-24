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

    public void savePhotos(List<Photo> photos) {
        photoRepository.save(photos);
    }
}
