package com.hr_system.controller;

import com.hr_system.Repository.EmployeeRepository;
import com.hr_system.model.Employee;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/edit")
public class EditMyDataController {

    private final EmployeeRepository employeeRepository;

    public EditMyDataController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PutMapping("/empData/{id}")
    public Employee editEmpData(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        // Fetch the existing OldEmpData from DB
        Employee OldEmpData = employeeRepository.findById(id).orElse(null);

        OldEmpData.setFirstName(updatedEmployee.getFirstName());
        OldEmpData.setLastName(updatedEmployee.getLastName());
        OldEmpData.setEmail(updatedEmployee.getEmail());
        OldEmpData.setPhone(updatedEmployee.getPhone());
        OldEmpData.setPassword(updatedEmployee.getPassword());
        OldEmpData.setJoptype(updatedEmployee.getJoptype());


        return employeeRepository.save(OldEmpData);
    }

}
