package com.hr_system.controller;

import com.hr_system.model.Insurance;
import com.hr_system.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insurance")
@CrossOrigin(origins = "http://localhost:3000")
public class InsuranceController {

    @Autowired
    private InsuranceService insuranceService;

    @GetMapping("/getall")
    public List<Insurance> getAllInsurance ()
    {
        return insuranceService.getAllInsurance();
    }

    @GetMapping("/{id}")
    public Insurance getOneInsurance (@PathVariable Long id)
    {
        return insuranceService.getInsuranceById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteInsurande (@PathVariable Long id) {
        insuranceService.deleteInsurance(id);
    }

    @PutMapping("/update/{id}")
    public Insurance updateInsurance(@PathVariable Long id, @RequestBody Insurance insurance) {
        insurance.setId(id);
        return insuranceService.saveInsurance(insurance);
    }
}
