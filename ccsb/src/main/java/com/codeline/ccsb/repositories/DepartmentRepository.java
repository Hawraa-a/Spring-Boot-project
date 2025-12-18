package com.codeline.ccsb.repositories;

import com.codeline.ccsb.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    @Query("SELECT d FROM Department d WHERE d.id=:id and d.isActive=true")
    Department getDepartmentById(Integer id);
}