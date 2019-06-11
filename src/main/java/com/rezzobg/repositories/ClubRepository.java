package com.rezzobg.repositories;

import com.rezzobg.models.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {
    public List<Club> findByAddressCityId(Long id);
}
