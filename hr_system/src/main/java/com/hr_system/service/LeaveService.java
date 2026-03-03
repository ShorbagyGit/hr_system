package com.hr_system.service;

import com.hr_system.Repository.LeaveRepository;
import com.hr_system.model.Leave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveService {
    @Autowired
    private LeaveRepository leaveRepository;


    public List<Leave> getAllLeaves() {
        return leaveRepository.findAll();
    }

    public Leave getLeaveById(Long id) {
        return leaveRepository.findById(id).orElse(null);
    }

    public Leave saveLeave(Leave leave) {
        return leaveRepository.save(leave);
    }

    public void deleteLeave(Long id) {
        leaveRepository.deleteById(id);
    }


    public Leave updateStatus(Long id, String status) {

        Leave leave = leaveRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Leave not found"));

        leave.setStatus(status);

        return leaveRepository.save(leave);
    }

}
