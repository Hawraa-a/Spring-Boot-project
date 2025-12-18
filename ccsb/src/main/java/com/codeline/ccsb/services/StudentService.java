package com.codeline.ccsb.services;

import com.codeline.ccsb.entities.Address;
import com.codeline.ccsb.entities.PhoneNumber;
import com.codeline.ccsb.entities.Student;
import com.codeline.ccsb.helper.Constants;
import com.codeline.ccsb.helper.HelperUtils;
import com.codeline.ccsb.repositories.AddressRepository;
import com.codeline.ccsb.repositories.PhoneNumberRepository;
import com.codeline.ccsb.repositories.StudentRepository;
import com.codeline.ccsb.requestObjects.StudentCreateRequest;
import com.codeline.ccsb.responseObjects.StudentCreateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    PhoneNumberRepository phoneNumberRepository;

    @Autowired
    AddressRepository addressRepository;

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public StudentCreateResponse saveStudent(StudentCreateRequest request) throws Exception {
        Student student = StudentCreateRequest.convertTostudent(request);
        student.setCreatedDate(new Date());
        student.setIsActive(Boolean.TRUE);

        List<PhoneNumber> phoneNumber = phoneNumberRepository.getPhoneNumberById(request.getPhoneNumberId());
        if (HelperUtils.isNotNull(phoneNumber) && HelperUtils.isListNotEmpty(phoneNumber)) {
            student.setPhoneNumbers(phoneNumber);
        } else {
            throw new Exception(Constants.STUDENT_CREATE_REQUEST_PHONE_NUMBER_ID_NOT_VALID);
        }

        Address address = addressRepository.getAddressById(request.getAddressId());
        if (HelperUtils.isNotNull(address)) {
            student.setAddress(address);
        } else {
            throw new Exception(Constants.STUDENT_CREATE_REQUEST_ADDRESS_ID_NOT_VALID);
        }

        return StudentCreateResponse.convertToStudentResponse(studentRepository.save(student));
    }

    public Student updateStudent(Student student) throws Exception {
        Student existingStudent = studentRepository.findById(student.getId()).get();
        if (existingStudent != null && existingStudent.getIsActive()) {
            student.setUpdatedDate(new Date());
            return studentRepository.save(student);
        } else {
            throw new Exception("Bad Request");
        }
    }

    public void deleteStudent(Integer id) throws Exception {
        Student existingStudent = studentRepository.findById(id).get();
        if (existingStudent != null && existingStudent.getIsActive()) {
            existingStudent.setUpdatedDate(new Date());
            existingStudent.setIsActive(Boolean.FALSE);
            studentRepository.save(existingStudent);
        } else {
            throw new Exception("Bad Request");
        }
    }

    public Student getStudentById(Integer id) throws Exception {
        Student existingStudent = studentRepository.findById(id).get();
        if (existingStudent != null && existingStudent.getIsActive()) {
            return existingStudent;
        } else {
            throw new Exception("Bad Request");
        }
    }
}
