package com.codeline.ccsb.repositories;

import com.codeline.ccsb.entities.Mark;
import com.codeline.ccsb.entities.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Integer> {
    @Query("SELECT p FROM PhoneNumber p WHERE p.isActive = true AND p.id IN (:id) ")
    List<PhoneNumber> getPhoneNumberById(List<Integer> id);
}
