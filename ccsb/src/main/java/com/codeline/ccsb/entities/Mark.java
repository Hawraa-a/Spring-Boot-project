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
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    Date createdDate;
    Date updatedDate;
    Boolean isActive;
    String studentName;
    String grade;

    @ManyToOne
    @JoinColumn(name = "course")
    Course course;
}
