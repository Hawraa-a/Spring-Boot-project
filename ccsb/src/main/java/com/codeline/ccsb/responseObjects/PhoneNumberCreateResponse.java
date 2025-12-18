package com.codeline.ccsb.responseObjects;

import com.codeline.ccsb.entities.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneNumberCreateResponse {
    private Integer id;
    private Integer number;
    private String countryCode;
    private Boolean isLandLine;

    public static PhoneNumberCreateResponse convertToPhoneNumberResponse(PhoneNumber entity){
        return PhoneNumberCreateResponse.builder()
                .id(entity.getId())
                .number(entity.getNumber())
                .countryCode(entity.getCountryCode())
                .isLandLine(entity.getIsLandLine())
                .build();
    }
}
