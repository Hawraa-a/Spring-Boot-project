package com.codeline.ccsb;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
public class HelloController {
    private Map<Integer, String> courses = new HashMap<>();
    private int idCounter = 1;

    @PostMapping("create")
    public String createCourses(@RequestParam String name) {
        courses.put(idCounter, name);
        return "Course created with ID: " + idCounter++;
    }

    @GetMapping("getAll")
    public Map<Integer, String> getAllCourses() {
        return courses;
    }

    @GetMapping("getById")
    public String getCourses(@RequestParam int id) {
        return courses.getOrDefault(id, "Course not found");
    }

    @PutMapping("update")
    public String updateCourse(@RequestParam int id, @RequestParam String name) {
        if (courses.containsKey(id)) {
            courses.put(id, name);
        }
        return "Course updated successfully";
    }

    @DeleteMapping("delete/{id}")
    public String deleteCourse(@PathVariable int id) {
        if (courses.remove(id) != null) {
            return "Course deleted successfully";
        }
        return "Course not found";
    }
}