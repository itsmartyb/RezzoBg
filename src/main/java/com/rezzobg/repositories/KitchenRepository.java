package com.rezzobg.repositories;

import com.rezzobg.models.Characteristic;
import com.rezzobg.models.Kitchen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KitchenRepository extends JpaRepository<Kitchen, Long> {
}
