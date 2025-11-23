package com.codeline.ccsb.services;

import com.codeline.ccsb.entities.Course;
import com.codeline.ccsb.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course saveCourse(Course course) {
        course.setCreatedDate(new Date());
        course.setIsActive(Boolean.TRUE);
        return courseRepository.save(course);
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

    public Course getCourseById(Integer id) throws Exception{
        Course existingCourse = courseRepository.findById(id).get();
        if (existingCourse != null && existingCourse.getIsActive()) {
            return existingCourse;
        }else {
            throw new Exception("Bad Request");
        }
    }
}
