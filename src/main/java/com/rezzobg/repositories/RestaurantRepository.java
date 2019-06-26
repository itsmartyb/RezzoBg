package com.rezzobg.repositories;

import com.rezzobg.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    public List<Restaurant> findByAddressCityId(Long id);
}
