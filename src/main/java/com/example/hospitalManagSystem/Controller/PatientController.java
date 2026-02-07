package com.example.hospitalManagSystem.Controller;

import com.example.hospitalManagSystem.Entity.Patient;
import com.example.hospitalManagSystem.Repository.PatientRepository;
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




}




