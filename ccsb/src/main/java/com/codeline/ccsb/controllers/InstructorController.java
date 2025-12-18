package com.codeline.ccsb.controllers;

import com.codeline.ccsb.entities.Instructor;
import com.codeline.ccsb.requestObjects.InstructorCreateRequest;
import com.codeline.ccsb.responseObjects.InstructorCreateResponse;
import com.codeline.ccsb.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/instructor")
public class InstructorController {
    @Autowired
    InstructorService instructorService;

    @PostMapping("create")
    public InstructorCreateResponse createInstructor(@RequestBody InstructorCreateRequest requestObj) throws Exception{
        InstructorCreateRequest.validCreateInstructorRequest(requestObj);
        return instructorService.saveInstructor(requestObj);
    }

    @GetMapping("getAll")
    public List<Instructor> getAllInstructor() {
        List<Instructor> instructorList = instructorService.getAllInstructor();
        return instructorList;
    }

    @GetMapping("getById")
    public Instructor getInstructor(@RequestParam int id) throws Exception {
        return instructorService.getInstructorById(id);
    }

    @PutMapping("update")
    public Instructor updateInstructor(@RequestBody Instructor updateObjFromUser) throws Exception {
        return instructorService.updateInstructor(updateObjFromUser);
    }

    @DeleteMapping("delete/{id}")
    public String deleteInstructor(@PathVariable int id) throws Exception {
        instructorService.deleteInstructor(id);
        return "SUCCESS";
    }
}
