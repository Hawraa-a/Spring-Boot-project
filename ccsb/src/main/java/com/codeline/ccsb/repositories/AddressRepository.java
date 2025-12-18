package com.codeline.ccsb.repositories;

import com.codeline.ccsb.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    @Query("SELECT a FROM Address a WHERE a.id=:id and a.isActive=true")
    Address getAddressById(Integer id);
}
