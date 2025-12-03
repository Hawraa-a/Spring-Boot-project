package com.codeline.ccsb.controllers;

import com.codeline.ccsb.entities.Department;
import com.codeline.ccsb.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @PostMapping("create")
    public Department createDepartment(@RequestBody Department requestObj) {
        Department department = departmentService.saveDepartment(requestObj);
        return department;
    }

    @GetMapping("getAll")
    public List<Department> getAllDepartment() {
        List<Department> departmentList = departmentService.getAllDepartment();
        return departmentList;
    }

    @GetMapping("getById")
    public Department getDepartment(@RequestParam int id) throws Exception {
        return departmentService.getDepartmentById(id);
    }

    @PutMapping("update")
    public Department updateDepartment(@RequestBody Department updateObjFromUser) throws Exception {
        return departmentService.updateDepartment(updateObjFromUser);
    }

    @DeleteMapping("delete/{id}")
    public String deleteDepartment(@PathVariable int id) throws Exception {
        departmentService.deleteDepartment(id);
        return "SUCCESS";
    }
}
