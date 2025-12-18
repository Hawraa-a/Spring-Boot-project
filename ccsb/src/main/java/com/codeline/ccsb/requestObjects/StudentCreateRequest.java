package com.codeline.ccsb.requestObjects;

import com.codeline.ccsb.entities.Student;
import com.codeline.ccsb.helper.Constants;
import com.codeline.ccsb.helper.HelperUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateRequest {
    private String firstName;
    private String lastName;
    private String email;
    private Date dateOfBirth;
    private String gender;
    private List<Integer> phoneNumberId;
    private Integer addressId;

    public static Student convertTostudent(StudentCreateRequest request) {
        Student student = new Student();
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());
        student.setDateOfBirth(request.getDateOfBirth());
        student.setGender(request.getGender());
        return student;
    }

    public static void validCreateStudentRequest(StudentCreateRequest request) throws Exception {
        if (HelperUtils.isNull(request.getFirstName()) || request.getFirstName().isEmpty() || request.getFirstName().isBlank()) {
            throw new Exception(Constants.STUDENT_CREATE_REQUEST_NAME_FIRST_NOT_VALID);
        } else if (HelperUtils.isNull(request.getLastName()) || request.getLastName().isEmpty() || request.getLastName().isBlank()) {
            throw new Exception(Constants.STUDENT_CREATE_REQUEST_NAME_LAST_NOT_VALID);
        } else if (HelperUtils.isNull(request.getEmail()) || request.getEmail().isEmpty() || request.getEmail().isBlank()) {
            throw new Exception(Constants.STUDENT_CREATE_REQUEST_EMAIL_NOT_VALID);
        } else if (HelperUtils.isNull(request.getDateOfBirth()) || request.getDateOfBirth().after(new Date())) {
            throw new Exception(Constants.STUDENT_CREATE_REQUEST_DATE_OF_BIRTH_NOT_VALID);
        } else if (HelperUtils.isNull(request.getGender()) || request.getGender().isEmpty() || request.getGender().isBlank()) {
            throw new Exception(Constants.STUDENT_CREATE_REQUEST_GENDER_NOT_VALID);
        } else if (HelperUtils.isNull(request.getPhoneNumberId()) || HelperUtils.isListEmpty(request.getPhoneNumberId())) {
            throw new Exception(Constants.STUDENT_CREATE_REQUEST_PHONE_NUMBER_ID_NOT_VALID);
        } else if (HelperUtils.isNull(request.getAddressId()) || request.getAddressId() <= 0) {
            throw new Exception(Constants.STUDENT_CREATE_REQUEST_ADDRESS_ID_NOT_VALID);
        }
    }
}
