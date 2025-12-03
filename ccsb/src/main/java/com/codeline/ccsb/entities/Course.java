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
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String name;
    String category;
    Integer duration;
    Date createdDate;
    Date updatedDate;
    Boolean isActive;

    @OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
    Instructor instructor;
}