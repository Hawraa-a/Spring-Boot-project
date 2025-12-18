package com.codeline.ccsb.controllers;


import com.codeline.ccsb.entities.Course;
import com.codeline.ccsb.requestObjects.CourseCreateRequest;
import com.codeline.ccsb.responseObjects.CourseCreateResponse;
import com.codeline.ccsb.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("courses")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping("create")
    public CourseCreateResponse createCourses(@RequestBody CourseCreateRequest requestObj) throws Exception {
        CourseCreateRequest.validCreateCourseRequest(requestObj);
        return courseService.saveCourse(requestObj);
    }

    @GetMapping("getAll")
    public List<Course> getAllCourses() {
        List<Course> courseList = courseService.getAllCourses();
        return courseList;
    }

    @GetMapping("getById")
    public Course getCourses(@RequestParam int id) throws Exception {
        return courseService.getCourseById(id);
    }

    @PutMapping("update")
    public Course updateCourse(@RequestBody Course updateObjFromUser) throws Exception {
        return courseService.updateCourse(updateObjFromUser);
    }

    @DeleteMapping("delete/{id}")
    public String deleteCourse(@PathVariable int id) throws Exception {
        courseService.deleteCourse(id);
        return "SUCCESS";
    }
}