package com.example.hospitalManagSystem.Repository;

import com.example.hospitalManagSystem.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
