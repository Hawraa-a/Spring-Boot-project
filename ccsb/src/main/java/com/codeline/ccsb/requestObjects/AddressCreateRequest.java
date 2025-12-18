package com.codeline.ccsb.requestObjects;

import com.codeline.ccsb.entities.Address;
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
public class AddressCreateRequest {
    private Integer houseNumber;
    private String street;
    private String city;
    private String stateOrProvince;
    private String country;
    private Integer postalCode;

    public static Address convertToAddressRequest(AddressCreateRequest request){
        Address address = new Address();
        address.setHouseNumber(request.getHouseNumber());
        address.setStreet(request.getStreet());
        address.setCity(request.getCity());
        address.setStateOrProvince(request.getStateOrProvince());
        address.setCountry(request.getCountry());
        address.setPostalCode(request.getPostalCode());
        return address;
    }

    public static void validCreateAddressRequest(AddressCreateRequest request) throws Exception{
        if (HelperUtils.isNull(request.getHouseNumber()) || request.getHouseNumber() <= 0){
            throw new Exception(Constants.ADDRESS_CREATE_REQUEST_HOUSE_NUMBER_NOT_VALID);
        } else if (HelperUtils.isNull(request.getStreet()) || request.getStreet().isEmpty() || request.getStreet().isBlank()) {
            throw new Exception(Constants.ADDRESS_CREATE_REQUEST_STREET_NOT_VALID);
        } else if (HelperUtils.isNull(request.getCity()) || request.getCity().isEmpty() || request.getCity().isBlank()) {
            throw new Exception(Constants.ADDRESS_CREATE_REQUEST_CITY_NOT_VALID);
        } else if (HelperUtils.isNull(request.getStateOrProvince()) || request.getStateOrProvince().isEmpty() || request.getStateOrProvince().isBlank()) {
            throw new Exception(Constants.ADDRESS_CREATE_REQUEST_STATE_OR_PROVINCE_NOT_VALID);
        } else if (HelperUtils.isNull(request.getCountry()) || request.getCountry().isEmpty() || request.getCountry().isBlank()) {
            throw new Exception(Constants.ADDRESS_CREATE_REQUEST_COUNTRY_NOT_VALID);
        } else if (HelperUtils.isNull(request.getPostalCode()) || request.getPostalCode() <= 0) {
            throw new Exception(Constants.ADDRESS_CREATE_REQUEST_POSTAL_CODE_NOT_VALID);
        }
    }
}
