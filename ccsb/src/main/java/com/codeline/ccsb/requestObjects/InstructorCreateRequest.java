package com.codeline.ccsb.requestObjects;

import com.codeline.ccsb.entities.Instructor;
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
public class InstructorCreateRequest {
    private String instructorName;

    public static Instructor convertToInstructor(InstructorCreateRequest request){
        Instructor instructor = new Instructor();
        instructor.setInstructorName(request.getInstructorName());
        return instructor;
    }

    public static void validCreateInstructorRequest(InstructorCreateRequest request) throws Exception{
        if (HelperUtils.isNull(request.getInstructorName()) || request.getInstructorName().isBlank() || request.getInstructorName().isEmpty()){
            throw new Exception(Constants.Instructor_CRETE_REQUEST_Instructor_NAME_NOT_VALID);
        }
    }
}
