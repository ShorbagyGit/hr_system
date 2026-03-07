package com.hr_system.service;

import com.hr_system.Repository.PayrollRepository;
import com.hr_system.model.Payroll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayrollService {

    @Autowired
    private PayrollRepository payrollRepository;

    public List<Payroll> getAllPayrolls() {
        return payrollRepository.findAll();
    }

    public Payroll getPayrollById(Long id) {
        return payrollRepository.findById(id).orElse(null);
    }

    public void deletePayroll(Long id) {
        payrollRepository.deleteById(id);
    }


}
