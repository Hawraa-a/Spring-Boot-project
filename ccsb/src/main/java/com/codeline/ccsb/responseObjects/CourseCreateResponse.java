package com.codeline.ccsb.responseObjects;

import com.codeline.ccsb.entities.Course;
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
public class CourseCreateResponse {
    private Integer id;
    private String courseName;
    private String category;
    private Integer duration;
    private Integer instructorId;
    private List<Integer> markId;

    public static CourseCreateResponse convertToCourseResponse(Course entity){
        return CourseCreateResponse.builder()
                .id(entity.getId())
                .courseName(entity.getCourseName())
                .category(entity.getCategory())
                .duration(entity.getDuration())
                .instructorId(entity.getInstructor().getId())
                .markId(entity.getMarks().stream().map(Mark -> Mark.getId()).collect(Collectors.toList()))
                .build();
    }
}
