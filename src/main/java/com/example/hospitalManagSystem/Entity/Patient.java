package com.example.hospitalManagSystem.Entity;

import com.example.hospitalManagSystem.Entity.type.BloodGroupType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "patient_table",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_patient", columnNames = {"name","email"})
        },
        indexes = {
                @Index(name = "birthdate_index", columnList = "birthdate")
        }
)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String gender;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthdate;

    @Enumerated(value = EnumType.STRING)
    private BloodGroupType bloodgroup;
}

