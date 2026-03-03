package com.hr_system.controller;

import com.hr_system.model.Candidate;
import com.hr_system.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidate")
@CrossOrigin(origins = "http://localhost:3000")
public class CandidateController {

    @Autowired
    private CandidateService candidateService ;

    @GetMapping("/getall")
    public List<Candidate> getCandidates()
    {
    return candidateService.GetallCandidates();
    }

    @GetMapping("/{id}")
    public Candidate GetOneDepartment(@PathVariable Long id)
    {
        return candidateService.getCandidateById(id) ;
    }

    @PutMapping("/update/{id}")
    public Candidate updateCandidate(@PathVariable Long id, @RequestBody Candidate candidate) {
        candidate.setId(id);
        return candidateService.saveCandidate(candidate);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCAndidate(@PathVariable Long id)
    {
        candidateService.deleteCandidate(id);
    }


}