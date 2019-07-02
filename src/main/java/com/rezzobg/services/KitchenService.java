package com.rezzobg.services;

import com.rezzobg.models.Kitchen;
import com.rezzobg.repositories.KitchenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KitchenService {

    @Autowired
    private KitchenRepository kitchenRepository;

    public Kitchen saveKitchen(Kitchen kitchen) {
        return this.kitchenRepository.save(kitchen);
    }

}
