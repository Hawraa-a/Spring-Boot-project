package com.codeline.ccsb.responseObjects;

import com.codeline.ccsb.entities.Mark;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MarkCreateResponse {
    private Integer id;
    private String studentName;
    private String grade;

    public static MarkCreateResponse convertToMarkResponse(Mark entity){
        return MarkCreateResponse.builder()
                .id(entity.getId())
                .studentName(entity.getStudentName())
                .grade(entity.getGrade())
                .build();
    }
}
