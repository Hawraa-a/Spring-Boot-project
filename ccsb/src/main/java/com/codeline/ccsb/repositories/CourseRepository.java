package com.codeline.ccsb.repositories;

import com.codeline.ccsb.entities.Course;
import com.codeline.ccsb.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Query("SELECT c FROM Course c WHERE c.isActive AND c.id IN (:id)")
    List<Course> getCourseById(List<Integer> id);

    @Query("SELECT c FROM Course c WHERE c.id=:id and c.isActive=true")
    Course getCourseById(Integer id);
}