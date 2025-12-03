package com.codeline.ccsb.controllers;

import com.codeline.ccsb.entities.Course;
import com.codeline.ccsb.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*")
@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping("create")
    public Course createCourses(@RequestBody Course requestObj) {
        Course course = courseService.saveCourse(requestObj);
        return course;
    }

    @GetMapping("getAll")
    public List<Course> getAllCourses() {
        List<Course> courseList = courseService.getAllCourses();
        return courseList;
    }

    @GetMapping("getById")
    public Course getCourses(@RequestParam int id) throws Exception{
        return courseService.getCourseById(id);
    }

    @PutMapping("update")
    public Course updateCourse(@RequestBody Course updateObjFromUser) throws Exception{
        return courseService.updateCourse(updateObjFromUser);
    }

    @DeleteMapping("delete/{id}")
    public String deleteCourse(@PathVariable int id) throws Exception{
        courseService.deleteCourse(id);
        return "SUCCESS";
    }
}