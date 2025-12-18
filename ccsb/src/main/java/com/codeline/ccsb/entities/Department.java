package com.codeline.ccsb.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String departmentName;
    Date createdDate;
    Date updatedDate;
    Boolean isActive;

    @OneToMany(cascade = CascadeType.ALL)
    List<Instructor> instructors;

    @OneToMany(cascade = CascadeType.ALL)
    List<Course> courses;
}
