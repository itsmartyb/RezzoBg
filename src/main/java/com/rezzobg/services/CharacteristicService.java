package com.rezzobg.services;

import com.rezzobg.models.Characteristic;
import com.rezzobg.repositories.CharacteristicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacteristicService {
    @Autowired
    private CharacteristicRepository characteristicRepository;

    public boolean isInDatabase(String characteristicName) {
        return this.characteristicRepository.findByName(characteristicName) != null;
    }

    public Characteristic saveCharacteristic(Characteristic characteristic) {
       return this.characteristicRepository.save(characteristic);
    }

    public Characteristic findCharacteristic(String name) {
        return this.characteristicRepository.findByName(name);
    }

    public void saveAll(List<Characteristic> characteristics) {
        this.characteristicRepository.save(characteristics);
    }
}
