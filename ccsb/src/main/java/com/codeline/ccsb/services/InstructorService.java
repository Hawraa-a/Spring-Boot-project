package com.codeline.ccsb.services;

import com.codeline.ccsb.entities.Instructor;
import com.codeline.ccsb.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class InstructorService {
    @Autowired
    InstructorRepository instructorRepository;

    public List<Instructor> getAllInstructor() {
        return instructorRepository.findAll();
    }

    public Instructor saveInstructor(Instructor instructor) {
        instructor.setCreatedDate(new Date());
        instructor.setIsActive(Boolean.TRUE);
        return instructorRepository.save(instructor);
    }

    public Instructor updateInstructor(Instructor instructor) throws Exception {
        Instructor existingInstructor = instructorRepository.findById(instructor.getId()).get();
        if (existingInstructor != null && existingInstructor.getIsActive()) {
            instructor.setUpdatedDate(new Date());
            return instructorRepository.save(instructor);
        } else {
            throw new Exception("Bad Request");
        }
    }

    public void deleteInstructor(Integer id) throws Exception {
        Instructor existingInstructor = instructorRepository.findById(id).get();
        if (existingInstructor != null && existingInstructor.getIsActive()) {
            existingInstructor.setUpdatedDate(new Date());
            existingInstructor.setIsActive(Boolean.FALSE);
            instructorRepository.save(existingInstructor);
        } else {
            throw new Exception("Bad Request");
        }
    }

    public Instructor getInstructorById(Integer id) throws Exception{
        Instructor existingInstructor = instructorRepository.findById(id).get();
        if (existingInstructor != null && existingInstructor.getIsActive()) {
            return existingInstructor;
        }else {
            throw new Exception("Bad Request");
        }
    }
}
