package com.rezzobg.services;

import com.rezzobg.models.Kitchen;
import com.rezzobg.repositories.KitchenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class KitchenService {

    @Autowired
    private KitchenRepository kitchenRepository;

    public Kitchen saveKitchen(Kitchen kitchen) {
        return this.kitchenRepository.save(kitchen);
    }

    public void saveAll(Set<Kitchen> kitchens) {
        this.kitchenRepository.saveAll(kitchens);
    }


    public boolean isInDatabase(Kitchen kitchen) {
        return kitchenRepository.findById(kitchen.getId()) != null;
    }
}
