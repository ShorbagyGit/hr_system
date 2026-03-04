package com.hr_system.Repository;

import com.hr_system.model.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance,Long> {
}
