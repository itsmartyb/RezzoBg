package com.rezzobg.repositories;

import com.rezzobg.models.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal, Long> {
    public Proposal findByPlaceId(Long id);
}
