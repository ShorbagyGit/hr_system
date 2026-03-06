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


@GetMapping("/getall")
    public List<Payroll> getallpayrolls()
{
    return payrollService.getAllPayrolls();
}


@GetMapping("/{id}")
    public Payroll getonepayroll(@PathVariable Long id )
{
    return payrollService.getPayrollById(id);
}

@DeleteMapping ("/delete/{id}")
    public void deletepayroll(@PathVariable Long id )
{
      payrollService.deletePayroll(id);
}

}
