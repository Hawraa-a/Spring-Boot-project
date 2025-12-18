package com.codeline.ccsb.responseObjects;

import com.codeline.ccsb.entities.Department;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentCreateResponse {
    private Integer id;
    private String departmentName;
    private List<Integer> instructorsId;
    private List<Integer> courseId;

    public static DepartmentCreateResponse convertToDepartmentResponse(Department entity){
        return DepartmentCreateResponse.builder()
                .id(entity.getId())
                .departmentName(entity.getDepartmentName())
                .instructorsId(entity.getInstructors().stream().map(Instructor -> Instructor.getId()).collect(Collectors.toList()))
                .courseId(entity.getCourses().stream().map(Course -> Course.getId()).collect(Collectors.toList()))
                .build();
    }
}
