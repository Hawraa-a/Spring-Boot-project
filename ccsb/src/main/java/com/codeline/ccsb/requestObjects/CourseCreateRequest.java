package com.codeline.ccsb.requestObjects;

import com.codeline.ccsb.entities.Course;
import com.codeline.ccsb.helper.Constants;
import com.codeline.ccsb.helper.HelperUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseCreateRequest {
    private String courseName;
    private String category;
    private Integer duration;
    private Integer instructorId;
    private List<Integer> markId;

    public static Course convertToCourse(CourseCreateRequest request) {
        Course course = new Course();
        course.setCourseName(request.getCourseName());
        course.setCategory(request.getCategory());
        course.setDuration(request.getDuration());
        return course;
    }

    public static void validCreateCourseRequest(CourseCreateRequest request) throws Exception {
        if (HelperUtils.isNull(request.getCourseName()) || request.getCourseName().isEmpty() || request.getCourseName().isBlank()) {
            throw new Exception(Constants.COURSE_CREATE_REQUEST_COURSE_NAME_NOT_VALID);
        } else if (HelperUtils.isNull(request.getCategory()) || request.getCategory().isEmpty() || request.getCategory().isBlank()) {
            throw new Exception(Constants.COURSE_CREATE_REQUEST_CATEGORY_NOT_VALID);
        } else if (HelperUtils.isNull(request.getDuration()) || request.getDuration() <= Constants.LOWER_DURATION || request.getDuration() >= Constants.UPPER_DURATION) {
            throw new Exception(Constants.COURSE_CREATE_REQUEST_DURATION_NOT_VALID);
//        } else if (HelperUtils.isNull(request.getInstructorId()) || request.getInstructorId() <= 0) {
//            throw new Exception(Constants.COURSE_CREATE_REQUEST_INSTRUCTOR_ID_NOT_VALID);
//        } else if (HelperUtils.isNull(request.getMarkId()) || HelperUtils.isListEmpty(request.getMarkId())) {
//            throw new Exception(Constants.COURSE_CREATE_REQUEST_MARK_ID_NOT_VALID);
        }
    }
}
