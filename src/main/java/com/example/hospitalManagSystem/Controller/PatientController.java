package com.example.hospitalManagSystem.Controller;

import com.example.hospitalManagSystem.Entity.Patient;
import com.example.hospitalManagSystem.Entity.type.BloodGroupType;
import com.example.hospitalManagSystem.Repository.PatientRepository;
import com.example.hospitalManagSystem.dto.bloodGroupCountRespEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;


    @PostMapping("/add")
    public Patient addPatient(@RequestBody Patient patient){
        return patientRepository.save(patient);
    }

    @GetMapping("/get")
    public List<Patient> getPatients(){
        return patientRepository.findAll();
    }

    @GetMapping("/id")
    public Optional<Patient> getPatientsBYId(@RequestParam (name = "id") Long id){
        return patientRepository.findById(id);
    }
    @GetMapping("/PatientsBYBloodGroup")
    public  List<bloodGroupCountRespEntity> getPatientsBYBloodGroup(){
        return patientRepository.countPatientsByBloodGroup();
    }

    @GetMapping("/PatientsOfBloodgroop")
    public List<Object[]> getPatientsOfBloodgroop(@RequestParam (name = "bloodgroup") String bloodgroup){
        return patientRepository.getPatientsOfBloodgroup(BloodGroupType.valueOf(bloodgroup));
    }

    @GetMapping("/updateNameById")
    public int updateNameById(@RequestParam (name = "id") long id,
                                         @RequestParam (name = "name") String name){
        return patientRepository.updateNameById(id,name);
    }








}




