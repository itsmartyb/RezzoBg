package com.rezzobg.services;

import com.rezzobg.models.Extra;
import com.rezzobg.repositories.ExtraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtraService {
    private ExtraRepository extraRepository;

    public void saveExtras(List<Extra> extras) {
        this.extraRepository.save(extras);
    }

    public boolean isInDatabase(Extra extra) {
        return this.extraRepository.findByName(extra.getName()) != null;
    }

    public void saveExtra(Extra extra) {
        this.extraRepository.save(extra);
    }
}
