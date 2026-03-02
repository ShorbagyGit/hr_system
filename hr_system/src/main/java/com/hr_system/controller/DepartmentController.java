package com.hr_system.controller;

import com.hr_system.Repository.DepartmentRepository;
import com.hr_system.model.Department;
import com.hr_system.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@CrossOrigin(origins = "http://localhost:3000")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/getall")
    public List<Department> getalldepartments()
    {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Department GetOneDepartment(@PathVariable Long id)
    {
        return departmentService.getDepartmentById(id) ;
    }

    @PostMapping
    public Department addDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @PutMapping("/update/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        department.setDep_id(id);
        return departmentService.saveDepartment(department);
    }


    @DeleteMapping("/delete/{id}")
    public void DeleteDepartment(@PathVariable Long id)
    {
         departmentService.deleteDepartment(id); ;
    }
}
