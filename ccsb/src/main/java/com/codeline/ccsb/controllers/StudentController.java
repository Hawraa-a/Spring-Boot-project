package com.codeline.ccsb.controllers;

import com.codeline.ccsb.entities.Student;
import com.codeline.ccsb.requestObjects.StudentCreateRequest;
import com.codeline.ccsb.responseObjects.StudentCreateResponse;
import com.codeline.ccsb.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("create")
    public StudentCreateResponse createCourses(@RequestBody StudentCreateRequest requestObj) throws Exception{
        StudentCreateRequest.validCreateStudentRequest(requestObj);
        return studentService.saveStudent(requestObj);
    }

    @GetMapping("getAll")
    public List<Student> getAllCourses() {
        List<Student> studentList = studentService.getAllStudent();
        return studentList;
    }

    @GetMapping("getById")
    public Student getStudent(@RequestParam int id) throws Exception {
        return studentService.getStudentById(id);
    }

    @PutMapping("update")
    public Student updateStudent(@RequestBody Student updateObjFromUser) throws Exception {
        return studentService.updateStudent(updateObjFromUser);
    }

    @DeleteMapping("delete/{id}")
    public String deleteStudent(@PathVariable int id) throws Exception {
        studentService.deleteStudent(id);
        return "SUCCESS";
    }
}
