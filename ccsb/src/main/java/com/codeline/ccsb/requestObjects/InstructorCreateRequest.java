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
    private Integer courseId;
    private Integer departmentId;

    public static Instructor convertToInstructor(InstructorCreateRequest request){
        Instructor instructor = new Instructor();
        instructor.setInstructorName(request.getInstructorName());
        return instructor;
    }

    public static void validCreateInstructorRequest(InstructorCreateRequest request) throws Exception{
        if (HelperUtils.isNull(request.getInstructorName()) || request.getInstructorName().isBlank() || request.getInstructorName().isEmpty()){
            throw new Exception(Constants.Instructor_CRETE_REQUEST_Instructor_NAME_NOT_VALID);
        } else if (HelperUtils.isNull(request.getCourseId()) || request.getCourseId() <= 0) {
            throw new Exception(Constants.Instructor_CREATE_REQUEST_COURSE_ID_NOT_VALID);
        } else if (HelperUtils.isNull(request.getDepartmentId()) || request.getDepartmentId() <= 0) {
            throw new Exception(Constants.Instructor_CREATE_REQUEST_Department_ID_NOT_VALID);
        }
    }
}
