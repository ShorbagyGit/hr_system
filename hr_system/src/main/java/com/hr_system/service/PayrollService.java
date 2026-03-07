package com.hr_system.service;

import com.hr_system.Repository.AttendanceRepository;
import com.hr_system.Repository.PayrollRepository;
import com.hr_system.model.Attendance;
import com.hr_system.model.Payroll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayrollService {

    @Autowired
    private PayrollRepository payrollRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    public List<Payroll> getAllPayrolls() {
        return payrollRepository.findAll();
    }

    public Payroll getPayrollById(Long id) {
        return payrollRepository.findById(id).orElse(null);
    }

    public void deletePayroll(Long id) {
        payrollRepository.deleteById(id);
    }

    // here to call employee id
    //find attendance by employee id
    // then loop to get all records
    public double calculateTotalWorkedHours(Long employeeId) {
        List<Attendance> attendances = attendanceRepository.findAttendanceByEmployeeId(employeeId);
        double totalHours = 0;

        for (Attendance record : attendances) {
            totalHours += record.getWorkHours(); // add each workHours
        }

        return totalHours;
    }


}
