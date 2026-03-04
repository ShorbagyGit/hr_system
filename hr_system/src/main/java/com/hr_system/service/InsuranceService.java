package com.hr_system.service;

import com.hr_system.Repository.InsuranceRepository;
import com.hr_system.model.Insurance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class InsuranceService {

    @Autowired
    private InsuranceRepository insuranceRepository;

    public Insurance getInsuranceById(@PathVariable Long id)
    {
        return insuranceRepository.getById(id);
    }

    public List<Insurance> getAllInsurance()
    {
        return insuranceRepository.findAll();
    }
    public void deleteInsurance(@PathVariable Long id )

    {
         insuranceRepository.deleteById(id);
    }

    public Insurance saveInsurance(Insurance insurance) {
        return insuranceRepository.save(insurance);
    }
}
