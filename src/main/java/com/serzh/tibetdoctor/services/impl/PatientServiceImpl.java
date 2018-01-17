package com.serzh.tibetdoctor.services.impl;

import com.serzh.tibetdoctor.domain.Patient;
import com.serzh.tibetdoctor.repositories.PatientRepository;
import com.serzh.tibetdoctor.services.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author sergii.zagryvyi on 30.11.2017
 */
@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public Iterable<Patient> listAllPatients() {
        Iterable<Patient> all = patientRepository.findAllByOrderBySurnameDesc();
        return all;
    }

    @Override
    public Patient getPatientById(Integer id) {

        Patient one = patientRepository.findOne(id);
        return one;
    }

    @Override
    public Patient savePatient(Patient patient) {
        Patient save = patientRepository.save(patient);
        return save;
    }

    @Override
    public void deletePatient(Integer id) {
         patientRepository.delete(id);
    }
}
