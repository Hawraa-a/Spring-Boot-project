package com.codeline.ccsb.requestObjects;

import com.codeline.ccsb.entities.PhoneNumber;
import com.codeline.ccsb.helper.Constants;
import com.codeline.ccsb.helper.HelperUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneNumberCreateRequest {
    private Integer number;
    private String countryCode;
    private Boolean isLandLine;

    public static PhoneNumber convertToPhoneNumber(PhoneNumberCreateRequest request){
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setNumber(request.getNumber());
        phoneNumber.setCountryCode(request.getCountryCode());
        phoneNumber.setIsLandLine(request.getIsLandLine());
        return phoneNumber;
    }

    public static void validCreatePhoneNumberRequest(PhoneNumberCreateRequest request) throws Exception{
        if (HelperUtils.isNull(request.getNumber())){
            throw new Exception(Constants.PHONE_NUMBER_CREATE_REQUEST_Number_NOT_VALID);
        } else if (HelperUtils.isNull(request.getCountryCode()) || request.getCountryCode().isEmpty() || request.getCountryCode().isBlank()) {
            throw new Exception(Constants.PHONE_NUMBER_CREATE_REQUEST_COUNTRY_CODE_NOT_VALID);
        } else if (HelperUtils.isNull(request.getIsLandLine())) {
            throw new Exception(Constants.PHONE_NUMBER_CREATE_REQUEST_IS_LAND_LINE_NOT_VALID);
        }
    }
}
