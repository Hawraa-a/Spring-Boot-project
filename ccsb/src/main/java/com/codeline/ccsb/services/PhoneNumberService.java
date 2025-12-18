package com.codeline.ccsb.services;

import com.codeline.ccsb.entities.PhoneNumber;
import com.codeline.ccsb.entities.Student;
import com.codeline.ccsb.helper.Constants;
import com.codeline.ccsb.helper.HelperUtils;
import com.codeline.ccsb.repositories.PhoneNumberRepository;
import com.codeline.ccsb.repositories.StudentRepository;
import com.codeline.ccsb.requestObjects.PhoneNumberCreateRequest;
import com.codeline.ccsb.responseObjects.PhoneNumberCreateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PhoneNumberService {
    @Autowired
    PhoneNumberRepository phoneNumberRepository;
    @Autowired
    StudentRepository studentRepository;

    public List<PhoneNumber> gitAllPhoneNumbers() {
        return phoneNumberRepository.findAll();
    }

    public PhoneNumberCreateResponse savePhoneNumber(PhoneNumberCreateRequest request) throws Exception {
        PhoneNumber phoneNumber = PhoneNumberCreateRequest.convertToPhoneNumber(request);
        phoneNumber.setCreatedDate(new Date());
        phoneNumber.setIsActive(Boolean.TRUE);

//        Student student = studentRepository.getStudentById(request.getStudentId());
//        if (HelperUtils.isNotNull(student)) {
//            phoneNumber.setStudent(student);
//        } else {
//            throw new Exception(Constants.PHONE_NUMBER_CREATE_REQUEST_STUDENT_ID_NOT_VALID);
//        }
        return PhoneNumberCreateResponse.convertToPhoneNumberResponse(phoneNumberRepository.save(phoneNumber));
    }

    public PhoneNumber updatePhoneNumber(PhoneNumber phoneNumber) throws Exception {
        PhoneNumber existingPhoneNumber = phoneNumberRepository.findById(phoneNumber.getId()).get();
        if (existingPhoneNumber != null && existingPhoneNumber.getIsActive()) {
            phoneNumber.setUpdatedDate(new Date());
            return phoneNumberRepository.save(phoneNumber);
        } else {
            throw new Exception(Constants.BAD_REQUEST);
        }
    }

    public void deletePhoneNumber(Integer id) throws Exception {
        PhoneNumber existingPhoneNumber = phoneNumberRepository.findById(id).get();
        if (existingPhoneNumber != null && existingPhoneNumber.getIsActive()) {
            existingPhoneNumber.setUpdatedDate(new Date());
            existingPhoneNumber.setIsActive(Boolean.FALSE);
            phoneNumberRepository.save(existingPhoneNumber);
        } else {
            throw new Exception(Constants.BAD_REQUEST);
        }
    }

    public PhoneNumber getPhoneNumberById(Integer id) throws Exception {
        PhoneNumber existingPhoneNumber = phoneNumberRepository.findById(id).get();
        if (existingPhoneNumber != null && existingPhoneNumber.getIsActive()) {
            return existingPhoneNumber;
        } else {
            throw new Exception(Constants.BAD_REQUEST);
        }
    }
}
