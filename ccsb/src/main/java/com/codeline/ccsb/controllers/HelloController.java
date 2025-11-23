package com.codeline.ccsb.controllers;

import com.codeline.ccsb.entities.Course;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*")
@RestController
public class HelloController {
    private List<Course> courseList = new ArrayList<>();
    private int idCounter = 1;

    @PostMapping("create")
    public String createCourses(@RequestBody Course requestObj) {
        requestObj.setId(idCounter);
        requestObj.setCreatedDate(new Date());
        requestObj.setIsActive(true);

        courseList.add(requestObj);
        return "Course created with ID: " + idCounter++;
    }

    @GetMapping("getAll")
    public List<Course> getAllCourses() {
        List<Course> responseList = new ArrayList<>();
        for (Course course : courseList) {
            if (course.getIsActive()) {
                responseList.add(course);
            }
        }
        return responseList;
    }

    @GetMapping("getById")
    public Course getCourses(@RequestParam int id) {
        for (Course course : courseList){
            if (course.getId() == id && course.getIsActive()){
                return course;
            }
        }
        return Course.builder().build();
    }

    @PutMapping("update")
    public String updateCourse(@RequestBody Course updateObjFromUser) {
        if (updateObjFromUser != null && updateObjFromUser.getId() != null) {
            Course existingCourseToUpdate = findCourseById(updateObjFromUser.getId());
            courseList.remove(existingCourseToUpdate);

            existingCourseToUpdate.setName(updateObjFromUser.getName());
            existingCourseToUpdate.setCategory(updateObjFromUser.getCategory());
            existingCourseToUpdate.setDuration(updateObjFromUser.getDuration());
            existingCourseToUpdate.setUpdatedDate(new Date());
            courseList.add(existingCourseToUpdate);
            return "Course updated successfully";
        }
        return "Course not found";
    }

    @DeleteMapping("delete/{id}")
    public String deleteCourse(@PathVariable int id) {
        Course existingCourseToUpdate = findCourseById(id);
        if(existingCourseToUpdate.getId() > 0){
            courseList.remove(existingCourseToUpdate);
            existingCourseToUpdate.setIsActive(false);
            existingCourseToUpdate.setUpdatedDate(new Date());
            return "Course deleted successfully";
        }
        return "Course not found";
    }

    public Course findCourseById(int id) {
        for (Course course : courseList) {
            if (course.getId() == id && course.getIsActive()) {
                return course;
            }
        }
        return Course.builder().id(-1).build();
    }
}