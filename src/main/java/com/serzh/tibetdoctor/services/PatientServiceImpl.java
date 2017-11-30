package com.serzh.tibetdoctor.services;

import com.serzh.tibetdoctor.domain.Patient;
import com.serzh.tibetdoctor.repositories.PatientRepository;
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
        Iterable<Patient> all = patientRepository.findAll();
        return all;
    }
}