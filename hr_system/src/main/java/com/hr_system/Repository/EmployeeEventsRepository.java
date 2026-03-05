package com.hr_system.Repository;


import com.hr_system.model.EmployeeEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeEventsRepository extends JpaRepository<EmployeeEvent,Long> {

    List<EmployeeEvent> findEmployeeEventByEmployeeId(Long employeeId);
}
