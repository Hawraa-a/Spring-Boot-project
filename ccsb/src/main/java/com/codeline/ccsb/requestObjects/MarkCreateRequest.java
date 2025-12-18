package com.codeline.ccsb.requestObjects;

import com.codeline.ccsb.entities.Mark;
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
public class MarkCreateRequest {
    private String studentName;
    private String grade;

    public static Mark convertToMark(MarkCreateRequest request){
        Mark mark = new Mark();
        mark.setStudentName(request.getStudentName());
        mark.setGrade(request.getGrade());
        return mark;
    }

    public static void validCreateMarkRequest(MarkCreateRequest request) throws Exception{
        if (HelperUtils.isNull(request.getStudentName()) || request.getStudentName().isEmpty() || request.getStudentName().isBlank()){
            throw new Exception(Constants.MARK_CREATE_REQUEST_STUDENT_NAME_NOT_VALID);
        } else if (HelperUtils.isNull(request.getGrade()) || request.getGrade().isEmpty() || request.getGrade().isBlank()) {
            throw new Exception(Constants.MARK_CREATE_REQUEST_GRADE_NOT_VALID);
        }
    }
}
