package com.codeline.ccsb.services;

import com.codeline.ccsb.entities.Address;
import com.codeline.ccsb.entities.Student;
import com.codeline.ccsb.helper.Constants;
import com.codeline.ccsb.helper.HelperUtils;
import com.codeline.ccsb.repositories.AddressRepository;
import com.codeline.ccsb.repositories.StudentRepository;
import com.codeline.ccsb.requestObjects.AddressCreateRequest;
import com.codeline.ccsb.responseObjects.AddressCreateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    StudentRepository studentRepository;

    public AddressCreateResponse saveAddress(AddressCreateRequest request) throws Exception {
        Address address = AddressCreateRequest.convertToAddressRequest(request);
        address.setCreatedDate(new Date());
        address.setIsActive(Boolean.TRUE);

//        Student student = studentRepository.getStudentById(request.getStudentId());
//        if (HelperUtils.isNotNull(student)) {
//            address.setStudent(student);
//        } else {
//            throw new Exception(Constants.PHONE_NUMBER_CREATE_REQUEST_STUDENT_ID_NOT_VALID);
//        }
        return AddressCreateResponse.convertToAddressResponse(addressRepository.save(address));
    }

    public Address updateAddress(Address address) throws Exception {
        Address existingAddress = addressRepository.findById(address.getId()).get();
        if (existingAddress != null && existingAddress.getIsActive()) {
            address.setUpdatedDate(new Date());
            return addressRepository.save(address);
        } else {
            throw new Exception(Constants.BAD_REQUEST);
        }
    }
}

