package com.hr_system.service;

import com.hr_system.Repository.EmployeeEventsRepository;
import com.hr_system.model.EmployeeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class EmployeeEventsService {

    @Autowired
    private EmployeeEventsRepository employeeEventsRepository;

    public List<EmployeeEvent> getAllEmployeeEvent() {
        return employeeEventsRepository.findAll();
    }

    public EmployeeEvent getEmployeeEventById(Long id) {
        return employeeEventsRepository.getById(id);
    }

    public EmployeeEvent saveCandidate(EmployeeEvent employeeEvent) {
        return employeeEventsRepository.save(employeeEvent);
    }

    public void deleteEmployeeEvent(Long id) {
        employeeEventsRepository.deleteById(id);
    }

    public List<EmployeeEvent> getEmployeeEventByEmpId(Long employeeId) {
        return employeeEventsRepository.findEmployeeEventByEmployeeId(employeeId);
    }
}
