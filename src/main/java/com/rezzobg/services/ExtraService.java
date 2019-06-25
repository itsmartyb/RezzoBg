package com.rezzobg.services;

import com.rezzobg.models.Extra;
import com.rezzobg.repositories.ExtraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtraService {
    @Autowired
    private ExtraRepository extraRepository;

    public void saveAll(List<Extra> extras) {
        this.extraRepository.save(extras);
    }

    public Extra findExtra(String name) { return this.extraRepository.findByName(name);}

    public boolean isInDatabase(String name) {
        return this.extraRepository.findByName(name) != null;
    }

    public Extra saveExtra(Extra extra) {
        return this.extraRepository.save(extra);
    }
}
