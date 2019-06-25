package com.rezzobg.repositories;

import com.rezzobg.models.Extra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExtraRepository extends JpaRepository<Extra, Long> {
    public Extra save(List<Extra> extras);
    public Extra findByName(String name);
}
