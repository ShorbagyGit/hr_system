package com.hr_system.controller;

import com.hr_system.model.Leave;
import com.hr_system.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leave")
@CrossOrigin(origins = "http://localhost:3000")
public class LeaveController {
    @Autowired
    private LeaveService leaveService;

    @GetMapping("/getall")
public List<Leave> getallLeaves()
    {
        return leaveService.getAllLeaves() ;
    }

    @PostMapping
    public Leave addLeave(@RequestBody Leave leave) {
        return leaveService.saveLeave(leave);
    }

    @PutMapping("/update/{id}")
    public Leave updateLeave(@PathVariable Long id, @RequestBody Leave leave) {
        leave.setId(id);
        return leaveService.saveLeave(leave);
    }


    @GetMapping("/{id}")
    public Leave getoneleave(@PathVariable Long id)
    {
        return leaveService.getLeaveById(id) ;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteleave(@PathVariable Long id)
    {
         leaveService.deleteLeave(id); ;
    }

}
