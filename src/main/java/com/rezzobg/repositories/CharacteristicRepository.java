package com.rezzobg.repositories;

import com.rezzobg.models.Characteristic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CharacteristicRepository extends JpaRepository<Characteristic, Long> {
    public Characteristic findByName(String name);
    public void save(List<Characteristic> characteristics);
}
