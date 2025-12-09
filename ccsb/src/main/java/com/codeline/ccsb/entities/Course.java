package com.codeline.ccsb.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String courseName;
    String category;
    Integer duration;
    Date createdDate;
    Date updatedDate;
    Boolean isActive;

    @OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
    Instructor instructor;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    List<Mark> marks;

    @ManyToOne
    Department department;
}