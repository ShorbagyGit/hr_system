package com.hr_system.service;

import com.hr_system.Repository.CandidateRepository;
import com.hr_system.model.Attendance;
import com.hr_system.model.Candidate;
import com.hr_system.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {

@Autowired
   private CandidateRepository candidateRepository;

    public List<Candidate> GetallCandidates() {
        return candidateRepository.findAll();
    }

    public Candidate getCandidateById(Long id) {
        return candidateRepository.findById(id).orElse(null);
    }


    public Candidate saveCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    public void deleteCandidate(Long id) {
        candidateRepository.deleteById(id);
    }

}
