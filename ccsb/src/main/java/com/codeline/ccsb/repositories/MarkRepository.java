package com.codeline.ccsb.repositories;

import com.codeline.ccsb.entities.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarkRepository extends JpaRepository<Mark, Integer> {

    @Query("SELECT m FROM Mark m WHERE m.isActive AND m.id IN (:id) ")
    List<Mark> getMarkById(List<Integer> id);
}
