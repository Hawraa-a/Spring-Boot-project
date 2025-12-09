package com.codeline.ccsb.services;

import com.codeline.ccsb.entities.Course;
import com.codeline.ccsb.entities.Department;
import com.codeline.ccsb.entities.Instructor;
import com.codeline.ccsb.helper.Constants;
import com.codeline.ccsb.helper.HelperUtils;
import com.codeline.ccsb.repositories.CourseRepository;
import com.codeline.ccsb.repositories.DepartmentRepository;
import com.codeline.ccsb.repositories.InstructorRepository;
import com.codeline.ccsb.requestObjects.InstructorCreateRequest;
import com.codeline.ccsb.responseObjects.InstructorCreateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class InstructorService {
    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    public List<Instructor> getAllInstructor() {
        return instructorRepository.findAll();
    }

    public InstructorCreateResponse saveInstructor(InstructorCreateRequest requestObj) throws Exception {
        Instructor instructor = InstructorCreateRequest.convertToInstructor(requestObj);
        instructor.setCreatedDate(new Date());
        instructor.setIsActive(Boolean.TRUE);

        Course course = courseRepository.getCourseById(requestObj.getCourseId());
        if (HelperUtils.isNotNull(course)) {
            instructor.setCourse(course);
        } else {
            throw new Exception(Constants.Instructor_CREATE_REQUEST_COURSE_ID_NOT_VALID);
        }

        Department department = departmentRepository.getDepartmentById(requestObj.getDepartmentId());
        if (HelperUtils.isNotNull(department)) {
            instructor.setDepartment(department);
        } else {
            throw new Exception(Constants.Instructor_CREATE_REQUEST_Department_ID_NOT_VALID);
        }

        return InstructorCreateResponse.convertToInstructorResponse(instructorRepository.save(instructor));
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

    public Instructor getInstructorById(Integer id) throws Exception {
        Instructor existingInstructor = instructorRepository.findById(id).get();
        if (existingInstructor != null && existingInstructor.getIsActive()) {
            return existingInstructor;
        } else {
            throw new Exception("Bad Request");
        }
    }
}
