package com.rezzobg.repositories;

import com.rezzobg.models.Offer;
import com.rezzobg.models.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
    public void removeByPlaceId(Long id);
}
