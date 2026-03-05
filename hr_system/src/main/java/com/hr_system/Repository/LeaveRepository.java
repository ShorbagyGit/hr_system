package com.hr_system.Repository;

import com.hr_system.model.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveRepository extends JpaRepository<Leave,Long>{
    List<Leave> findLeaveByEmployeeId(Long employeeId);
}
