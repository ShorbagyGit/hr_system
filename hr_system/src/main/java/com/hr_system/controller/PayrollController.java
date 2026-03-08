package com.hr_system.controller;

import com.hr_system.Repository.PayrollRepository;
import com.hr_system.model.Payroll;
import com.hr_system.service.PayrollService;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/payroll")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class PayrollController {

    @Autowired
    private PayrollService payrollService;
    @Autowired
    private PayrollRepository payrollRepository;

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

    //  Ai generated
    @GetMapping("/export")
    public void exportPayroll(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=payroll.xlsx");

        List<Payroll> payrolls = payrollRepository.findAll();

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Payrolls");

        // Header row
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Employee ID");
        header.createCell(1).setCellValue("Name");
        header.createCell(2).setCellValue("Basic Salary");
        header.createCell(3).setCellValue("Deductions");
        header.createCell(4).setCellValue("Net Salary");

        int rowNum = 1;
        for (Payroll p : payrolls) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(p.getEmployee().getId());
            row.createCell(1).setCellValue(p.getEmployee().getFirstName() + " " + p.getEmployee().getLastName());
            row.createCell(2).setCellValue(p.getBasicSalary());
            row.createCell(3).setCellValue(p.getDeductions());
            row.createCell(4).setCellValue(p.getNetSalary());
        }

        workbook.write(response.getOutputStream());
        workbook.close();
    }
}