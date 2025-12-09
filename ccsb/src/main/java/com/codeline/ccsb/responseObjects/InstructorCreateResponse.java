package com.codeline.ccsb.responseObjects;

import com.codeline.ccsb.entities.Instructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InstructorCreateResponse {
    private Integer id;
    private String instructorName;
    private Integer courseId;
    private Integer departmentId;

    public static InstructorCreateResponse convertToInstructorResponse(Instructor entity){
        return InstructorCreateResponse.builder()
                .id(entity.getId())
                .instructorName(entity.getInstructorName())
                .courseId(entity.getCourse().getId())
                .departmentId(entity.getDepartment().getId())
                .build();
    }
}