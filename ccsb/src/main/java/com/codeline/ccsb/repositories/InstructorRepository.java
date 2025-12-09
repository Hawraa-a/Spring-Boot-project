package com.codeline.ccsb.repositories;

import com.codeline.ccsb.entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

    @Query("SELECT i FROM Instructor i WHERE i.id=:id and i.isActive=true")
    Instructor getInstructorById(Integer id);

    @Query("SELECT i FROM Instructor i WHERE i.isActive AND i.id IN (:id)")
    List<Instructor> getInstructorById(List<Integer> id);

    @Query("SELECT COUNT(i) FROM Instructor i WHERE i.isActive=true")
    Integer getCountOfAllInstructor();
}