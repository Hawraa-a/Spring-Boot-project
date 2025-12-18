package com.codeline.ccsb.responseObjects;

import com.codeline.ccsb.entities.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateResponse {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Date dateOfBirth;
    private String gender;
    private List<Integer> phoneNumberId;
    private Integer addressId;

    public static StudentCreateResponse convertToStudentResponse(Student entity){
        return StudentCreateResponse.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getFirstName())
                .email(entity.getEmail())
                .dateOfBirth(entity.getDateOfBirth())
                .gender(entity.getGender())
                .phoneNumberId(entity.getPhoneNumbers().stream().map(PhoneNumber -> PhoneNumber.getId()).collect(Collectors.toList()))
                .addressId(entity.getAddress().getId())
                .build();
    }
}
