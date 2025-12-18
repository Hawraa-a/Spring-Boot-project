package com.codeline.ccsb.repositories;

import com.codeline.ccsb.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("SELECT s FROM Student s WHERE s.id=:id and s.isActive=true")
    Student getStudentById(Integer id);
}
