package com.hr_system.controller;

import com.hr_system.model.Attendance;
import com.hr_system.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Attendance")
public class AttendanceController {

@Autowired
    private AttendanceService attendanceService;

    @GetMapping("/getall")
    public List<Attendance> getAttendance()
    {
    return attendanceService.getAllAttendances();
    }

    @PostMapping
    public Attendance addAttendance(@RequestBody Attendance attendance) {
        return attendanceService.saveAttendance(attendance);
    }

    @PutMapping("/update/{id}")
    public Attendance updateAttendance(@PathVariable Long id, @RequestBody Attendance attendance) {
        attendance.setId(id);
        return attendanceService.saveAttendance(attendance);
    }


    @GetMapping("/{id}")
    public Attendance getAttendance(@PathVariable Long id) {
        return attendanceService.getAttendanceById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAttendance(@PathVariable Long id) {
         attendanceService.deleteAttendance(id);
    }

}
