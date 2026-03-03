package com.hr_system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Link to Employee
    @OneToOne
    @JoinColumn(name = "employee_id", nullable = false, unique = true)
    private Employee employee;

    private String insuranceCompany;   // Name of insurance provider
    private String policyNumber;       // Policy number
    private LocalDate startDate;       // Insurance start date
    private LocalDate endDate;         // Insurance end date
    private Double coverageAmount;     // Coverage amount in currency
    private String insuranceType;      // e.g., Health, Life, Dental
}