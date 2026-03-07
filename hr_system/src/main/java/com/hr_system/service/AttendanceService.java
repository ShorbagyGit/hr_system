package com.hr_system.service;

import com.hr_system.Repository.AttendanceRepository;
import com.hr_system.model.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

@Service
public class AttendanceService {

    // Fixed working hours
    private static final LocalTime WORK_START = LocalTime.of(9, 0);
    private static final LocalTime WORK_END = LocalTime.of(17, 0);

    @Autowired
    private AttendanceRepository attendanceRepository;

    // Get all attendances
    public List<Attendance> getAllAttendances() {
        return attendanceRepository.findAll();
    }

    // Get attendance by ID
    public Attendance getAttendanceById(Long id) {
        return attendanceRepository.findById(id).orElse(null);
    }

    // Save or update attendance
    public Attendance saveAttendance(Attendance attendance) {

        calculateAttendance(attendance);

        return attendanceRepository.save(attendance);
    }

    // Delete attendance
    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }

    // Get attendances for a specific employee
    public List<Attendance> getAttendancesByEmployeeId(Long employeeId) {
        return attendanceRepository.findAttendanceByEmployeeId(employeeId);
    }

    // Attendance Calculation Logic
    private void calculateAttendance(Attendance attendance) {

        LocalTime checkIn = attendance.getCheckInTime();
        LocalTime checkOut = attendance.getCheckOutTime();

        if (checkIn == null || checkOut == null) {
            // If times are missing, mark as absent/incomplete
            attendance.setWorkHours(0L);
            attendance.setLateMinutes(0L);
            attendance.setEarlyLeaveMinutes(0L);
            attendance.setStatus("Incomplete");
            return;
        }

        // Calculate total work hours (integer hours only)
        Duration workDuration = Duration.between(checkIn, checkOut);
        long totalMinutes = workDuration.toMinutes();
        long hours = totalMinutes / 60; // full hours only
        attendance.setWorkHours(hours);

        // Initialize
        long lateMinutes = 0;
        long earlyLeaveMinutes = 0;
        String status = "Present";

        // Late arrival
        if (checkIn.isAfter(WORK_START)) {
            lateMinutes = Duration.between(WORK_START, checkIn).toMinutes();
            status = "Late";
        }

        // Early leave
        if (checkOut.isBefore(WORK_END)) {
            earlyLeaveMinutes = Duration.between(checkOut, WORK_END).toMinutes();
            if (status.equals("Late")) {
                status = "Late & Early Leave";
            } else {
                status = "Early Leave";
            }
        }

        attendance.setLateMinutes(lateMinutes);
        attendance.setEarlyLeaveMinutes(earlyLeaveMinutes);
        attendance.setStatus(status);
    }
}