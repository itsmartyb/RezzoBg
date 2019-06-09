package com.rezzobg.repositories;

import com.rezzobg.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    public City findByName(String name);
}
