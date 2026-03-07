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

    public List<Attendance> getAllAttendances() {
        return attendanceRepository.findAll();
    }

    public Attendance getAttendanceById(Long id) {
        return attendanceRepository.findById(id).orElse(null);
    }

    public Attendance saveAttendance(Attendance attendance) {

        calculateAttendance(attendance);

        return attendanceRepository.save(attendance);
    }

    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }

    public List<Attendance> getAttendancesByEmployeeId(Long employeeId) {
        return attendanceRepository.findAttendanceByEmployeeId(employeeId);
    }


    // ==============================
    // Attendance Calculation Logic
    // ==============================
    private void calculateAttendance(Attendance attendance) {

        LocalTime checkIn = attendance.getCheckInTime();
        LocalTime checkOut = attendance.getCheckOutTime();

        if (checkIn == null || checkOut == null) {
            return;
        }

        // Calculate Work Hours
        Duration workDuration = Duration.between(checkIn, checkOut);
        attendance.setWorkHours(workDuration.toHours());

        // Calculate Late Minutes
        if (checkIn.isAfter(WORK_START)) {

            long lateMinutes =
                    Duration.between(WORK_START, checkIn).toMinutes();

            attendance.setLateMinutes(lateMinutes);
            attendance.setStatus("Late");

        } else {

            attendance.setLateMinutes(0L);
            attendance.setStatus("Present");
        }

    }

}