package com.codeline.ccsb.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String firstName;
    String lastName;
    String email;
    Date dateOfBirth;
    String gender;
    Boolean isActive;
    Date createdDate;
    Date updatedDate;

    @OneToMany(cascade = CascadeType.ALL)
    List<PhoneNumber> phoneNumbers;

    @OneToOne(cascade = CascadeType.ALL)
    Address address;
}
