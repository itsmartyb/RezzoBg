package com.rezzobg.repositories;

import com.rezzobg.models.Club;
import com.rezzobg.models.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
    public Optional<Place> findById(Long id);
    public Optional<Place> findByProposals(Long id);
}
