package com.serzh.tibetdoctor.repositories;

import com.serzh.tibetdoctor.domain.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Integer> {
}
