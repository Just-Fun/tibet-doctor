package com.serzh.tibetdoctor.services;

import com.serzh.tibetdoctor.domain.Patient;

/**
 * @author sergii.zagryvyi on 30.11.2017
 */
public interface PatientService {
    Iterable<Patient> listAllPatients();

    Patient getPatientById(Integer id);

    Patient savePatient(Patient patient);

    void deletePatient(Integer id);
}
