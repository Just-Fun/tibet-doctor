package com.serzh.tibetdoctor.repositories;

import com.serzh.tibetdoctor.domain.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
    Iterable<Appointment> findByPatientIdOrderByDateDesc(int id);
}
