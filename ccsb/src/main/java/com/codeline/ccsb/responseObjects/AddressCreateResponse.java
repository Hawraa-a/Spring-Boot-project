package com.codeline.ccsb.responseObjects;

import com.codeline.ccsb.entities.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressCreateResponse {
    private Integer id;
    private Integer houseNumber;
    private String street;
    private String city;
    private String stateOrProvince;
    private String country;
    private Integer postalCode;

    public static AddressCreateResponse convertToAddressResponse(Address entity){
        return AddressCreateResponse.builder()
                .id(entity.getId())
                .houseNumber(entity.getHouseNumber())
                .street(entity.getStreet())
                .city(entity.getCity())
                .stateOrProvince(entity.getStateOrProvince())
                .country(entity.getCountry())
                .postalCode(entity.getPostalCode())
                .build();
    }
}
