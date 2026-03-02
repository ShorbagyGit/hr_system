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
@Table(name = "employee_leave")
public class Leave {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private LocalDate startDate;
    private LocalDate endDate;
    private String type;   // Sick, Vacation, etc.
    private String status; // here is it approved the or not

//    @Transient
//    private Long employeeId;
//
//    @Transient
//    private String employeeName;
//
//    @Transient
//    private String employeePhoto;
}
