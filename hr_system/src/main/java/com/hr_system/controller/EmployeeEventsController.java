package com.hr_system.controller;

import com.hr_system.model.EmployeeEvent;
import com.hr_system.service.EmployeeEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("events")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeEventsController {

    @Autowired
    private EmployeeEventsService employeeEventsService;


    // Get all employee events
    @GetMapping("getall")
    public List<EmployeeEvent> getAllEmployeeEvents() {
        return employeeEventsService.getAllEmployeeEvent();
    }


    // Get event by id
    @GetMapping("/{id}")
    public EmployeeEvent getEmployeeEventById(@PathVariable Long id) {
        return employeeEventsService.getEmployeeEventById(id);
    }


    // Get events by employee id
    @GetMapping("/employee/{employeeId}")
    public List<EmployeeEvent> getEventsByEmployeeId(@PathVariable Long employeeId) {
        return employeeEventsService.getEmployeeEventByEmpId(employeeId);
    }


    // Create new event
    @PostMapping
    public EmployeeEvent createEmployeeEvent(@RequestBody EmployeeEvent employeeEvent) {
        return employeeEventsService.saveCandidate(employeeEvent);
    }


    // Delete event
    @DeleteMapping("/{id}")
    public void deleteEmployeeEvent(@PathVariable Long id) {
        employeeEventsService.deleteEmployeeEvent(id);
    }

}