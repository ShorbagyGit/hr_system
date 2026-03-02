package com.hr_system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.YearMonth;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")  //  FK
    private Employee employee;
    private Double basicSalary;
    private Double bonus;
    private Double deductions;
    private Double netSalary; // (basic + bonus)- deduct= net
}
