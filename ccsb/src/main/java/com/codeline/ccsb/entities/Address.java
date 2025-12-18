package com.codeline.ccsb.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    Integer houseNumber;
    String street;
    String city;
    String stateOrProvince;
    String country;
    Integer postalCode;
    Boolean isActive;
    Date createdDate;
    Date updatedDate;

}
