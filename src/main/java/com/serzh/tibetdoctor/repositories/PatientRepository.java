package com.serzh.tibetdoctor.repositories;

import com.serzh.tibetdoctor.domain.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer> {

    Iterable<Patient> findAllByOrderBySurnameDesc();
}
