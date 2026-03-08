package com.hr_system.service;

import com.hr_system.Repository.AttendanceRepository;
import com.hr_system.Repository.EmployeeRepository;
import com.hr_system.Repository.PayrollRepository;
import com.hr_system.model.Attendance;
import com.hr_system.model.Employee;
import com.hr_system.model.Payroll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PayrollService {

    @Autowired
    private PayrollRepository payrollRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    // Get all saved payrolls
    public List<Payroll> getAllPayrolls() {
        return payrollRepository.findAll();
    }

    // Get payroll by ID
    public Payroll getPayrollById(Long id) {
        return payrollRepository.findById(id).orElse(null);
    }

    // Delete payroll
    public void deletePayroll(Long id) {
        payrollRepository.deleteById(id);
    }

    // Calculate total worked hours for one employee
    public double calculateTotalWorkedHours(Long employeeId) {
        List<Attendance> attendances = attendanceRepository.findAttendanceByEmployeeId(employeeId);
        double totalHours = 0;
        for (Attendance record : attendances) {
            totalHours += record.getWorkHours();
        }
        return totalHours;
    }

    // Generate payroll for all employees AND save to DB
    public List<Payroll> generateAndSavePayrollForAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();
        List<Payroll> payrollList = new ArrayList<>();

        for (Employee emp : employees) {

            double totalHours = calculateTotalWorkedHours(emp.getId());
            double basicSalary = emp.getSalary();
            double expectedHours = 8 * 30; // expected hours per month
            double hourlyRate = basicSalary / expectedHours;
            double deduction = 0;
            if (totalHours < expectedHours) {
                deduction = (expectedHours - totalHours) * hourlyRate;
            }

            double netSalary = basicSalary - deduction;

            Payroll payroll = new Payroll();
            payroll.setEmployee(emp);
            payroll.setBasicSalary(basicSalary);
            payroll.setBonus(0.0);
            payroll.setDeductions(deduction);
            payroll.setNetSalary(netSalary);

            payrollRepository.save(payroll); // <-- save to database
            payrollList.add(payroll);
        }

        return payrollList;
    }
}