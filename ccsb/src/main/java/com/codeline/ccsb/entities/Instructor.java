package com.codeline.ccsb.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String name;
    Date createdDate;
    Date updatedDate;
    Boolean isActive;

    @OneToOne
    @JoinColumn(name = "course")
    Course course;

    @ManyToOne(cascade = CascadeType.ALL)
    Department department;
}
