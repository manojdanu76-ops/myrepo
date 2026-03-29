package com.example.hospitalManagSystem.Repository;

import com.example.hospitalManagSystem.Entity.Patient;
import com.example.hospitalManagSystem.Entity.type.BloodGroupType;
import com.example.hospitalManagSystem.dto.bloodGroupCountRespEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("select new com.example.hospitalManagSystem.dto.bloodGroupCountRespEntity(p.bloodgroup, count(p)) from Patient p group by p.bloodgroup")
    List<bloodGroupCountRespEntity> countPatientsByBloodGroup();

    @Query("select p from Patient p where p.bloodgroup = :bloodgroup ")
    List<Object[]> getPatientsOfBloodgroup(BloodGroupType bloodgroup);

    @Modifying
    @Transactional
    @Query("update Patient p set p.name = :name where p.id = :id")
    int updateNameById(long id, String name);
}
