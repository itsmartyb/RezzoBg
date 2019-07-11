package com.rezzobg.repositories;

import com.rezzobg.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    public void removeById(Long id);
}
