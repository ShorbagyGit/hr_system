package com.hr_system.controller;

import com.hr_system.model.Payroll;
import com.hr_system.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payroll")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class PayrollController {

    @Autowired
    private PayrollService payrollService;

    // ==================== GENERATE & SAVE PAYROLL ====================
    // This endpoint calculates payroll from attendance and saves to DB
    @GetMapping("/generate")
    public List<Payroll> generatePayroll() {
        return payrollService.generateAndSavePayrollForAllEmployees();
    }

    // ==================== GET ALL PAYROLL ====================
    // Fetch all saved payroll records from DB
    @GetMapping
    public List<Payroll> getAllPayrolls() {
        return payrollService.getAllPayrolls();
    }

    // ==================== GET PAYROLL BY ID ====================
    @GetMapping("/{id}")
    public Payroll getPayrollById(@PathVariable Long id) {
        return payrollService.getPayrollById(id);
    }

    // ==================== DELETE PAYROLL ====================
    @DeleteMapping("/delete/{id}")
    public void deletePayroll(@PathVariable Long id) {
        payrollService.deletePayroll(id);
    }
}