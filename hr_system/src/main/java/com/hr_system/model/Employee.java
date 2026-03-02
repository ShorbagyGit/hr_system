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
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department depart;

    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private Integer Phone;
    private String password;
    private String department;
    private Integer salary;
    private String joptype;
    private LocalDate hireDate;
    private String profileImage;

}
