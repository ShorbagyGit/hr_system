package com.hr_system.Repository;

import com.hr_system.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findAttendanceByEmployeeId(Long employeeId);

    List<Attendance> findByEmployeeId(Long employeeId);

    Attendance findByEmployeeIdAndDate(Long employeeId, LocalDate date);
}
