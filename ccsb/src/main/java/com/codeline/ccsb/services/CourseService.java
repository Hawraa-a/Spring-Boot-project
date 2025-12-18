package com.codeline.ccsb.services;

import com.codeline.ccsb.entities.Course;
import com.codeline.ccsb.entities.Department;
import com.codeline.ccsb.entities.Instructor;
import com.codeline.ccsb.entities.Mark;
import com.codeline.ccsb.helper.Constants;
import com.codeline.ccsb.helper.HelperUtils;
import com.codeline.ccsb.repositories.CourseRepository;
import com.codeline.ccsb.repositories.DepartmentRepository;
import com.codeline.ccsb.repositories.InstructorRepository;
import com.codeline.ccsb.repositories.MarkRepository;
import com.codeline.ccsb.requestObjects.CourseCreateRequest;
import com.codeline.ccsb.responseObjects.CourseCreateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
    MarkRepository markRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public CourseCreateResponse saveCourse(CourseCreateRequest request) throws Exception {
        Course course = CourseCreateRequest.convertToCourse(request);
        course.setCreatedDate(new Date());
        course.setIsActive(Boolean.TRUE);

        Instructor instructor = instructorRepository.getInstructorById(request.getInstructorId());
        if (HelperUtils.isNotNull(instructor)) {
            course.setInstructor(instructor);
        } else {
            throw new Exception(Constants.COURSE_CREATE_REQUEST_INSTRUCTOR_ID_NOT_VALID);
        }

        List<Mark> marks = markRepository.getMarkById(request.getMarkId());
        if (HelperUtils.isNotNull(marks) && HelperUtils.isListNotEmpty(marks)) {
            course.setMarks(marks);

        } else {
            throw new Exception(Constants.COURSE_CREATE_REQUEST_MARK_ID_NOT_VALID);
        }

        return CourseCreateResponse.convertToCourseResponse(courseRepository.save(course));
    }

    public Course updateCourse(Course course) throws Exception {
        Course existingCourse = courseRepository.findById(course.getId()).get();
        if (existingCourse != null && existingCourse.getIsActive()) {
            course.setUpdatedDate(new Date());
            return courseRepository.save(course);
        } else {
            throw new Exception("Bad Request");
        }
    }

    public void deleteCourse(Integer id) throws Exception {
        Course existingCourse = courseRepository.findById(id).get();
        if (existingCourse != null && existingCourse.getIsActive()) {
            existingCourse.setUpdatedDate(new Date());
            existingCourse.setIsActive(Boolean.FALSE);
            courseRepository.save(existingCourse);
        } else {
            throw new Exception("Bad Request");
        }
    }

    public Course getCourseById(Integer id) throws Exception {
        Course existingCourse = courseRepository.findById(id).get();
        if (existingCourse != null && existingCourse.getIsActive()) {
            return existingCourse;
        } else {
            throw new Exception("Bad Request");
        }
    }
}