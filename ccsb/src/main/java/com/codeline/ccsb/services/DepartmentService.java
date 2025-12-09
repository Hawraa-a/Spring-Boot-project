package com.codeline.ccsb.services;

import com.codeline.ccsb.entities.Course;
import com.codeline.ccsb.entities.Department;
import com.codeline.ccsb.entities.Instructor;
import com.codeline.ccsb.helper.Constants;
import com.codeline.ccsb.helper.HelperUtils;
import com.codeline.ccsb.repositories.CourseRepository;
import com.codeline.ccsb.repositories.DepartmentRepository;
import com.codeline.ccsb.repositories.InstructorRepository;
import com.codeline.ccsb.requestObjects.DepartmentCreateRequest;
import com.codeline.ccsb.responseObjects.DepartmentCreateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
    CourseRepository courseRepository;

    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    public DepartmentCreateResponse saveDepartment(DepartmentCreateRequest request) throws Exception {
        Department department = DepartmentCreateRequest.convertToDepartment(request);
        department.setCreatedDate(new Date());
        department.setIsActive(Boolean.TRUE);

        List <Instructor> instructors = instructorRepository.getInstructorById(request.getInstructorsId());
        if (HelperUtils.isNotNull(instructors)) {
            department.setInstructors(instructors);
        } else {
            throw new Exception(Constants.Department_CREATE_REQUEST_INSTRUCTOR_ID_NOT_VALID);
        }

        List <Course> courses = courseRepository.getCourseById(request.getCourseId());
        if (HelperUtils.isNotNull(courses)) {
            department.setCourses(courses);
        } else {
            throw new Exception(Constants.Department_CREATE_REQUEST_COURSE_ID_NOT_VALID);
        }

        return DepartmentCreateResponse.convertToDepartmentResponse(departmentRepository.save(department));
    }

    public Department updateDepartment(Department department) throws Exception {
        Department existingDepartment = departmentRepository.findById(department.getId()).get();
        if (existingDepartment != null && existingDepartment.getIsActive()) {
            department.setUpdatedDate(new Date());
            return departmentRepository.save(department);
        } else {
            throw new Exception("Bad Request");
        }
    }

    public void deleteDepartment(Integer id) throws Exception {
        Department existingDepartment = departmentRepository.findById(id).get();
        if (existingDepartment != null && existingDepartment.getIsActive()) {
            existingDepartment.setUpdatedDate(new Date());
            existingDepartment.setIsActive(Boolean.FALSE);
            departmentRepository.save(existingDepartment);
        } else {
            throw new Exception("Bad Request");
        }
    }

    public Department getDepartmentById(Integer id) throws Exception {
        Department existingDepartment = departmentRepository.findById(id).get();
        if (existingDepartment != null && existingDepartment.getIsActive()) {
            return existingDepartment;
        } else {
            throw new Exception("Bad Request");
        }
    }
}
