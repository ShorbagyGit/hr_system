package com.hr_system.Repository;

import com.hr_system.model.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PayrollRepository extends JpaRepository<Payroll,Long> {
    List<Payroll> findByEmployeeId(Long employeeId);
}
