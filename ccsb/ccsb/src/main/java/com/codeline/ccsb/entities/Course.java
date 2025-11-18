package com.codeline.ccsb.entities;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Course {
    Integer id;
    String name;
    String category;
    Integer duration;
    Date createdDate;
    Date updatedDate;
    Boolean isActive;
}