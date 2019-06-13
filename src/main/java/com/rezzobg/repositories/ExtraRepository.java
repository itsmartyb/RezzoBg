package com.rezzobg.repositories;

import com.rezzobg.models.Extra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtraRepository extends JpaRepository<Extra, Long> {
}
