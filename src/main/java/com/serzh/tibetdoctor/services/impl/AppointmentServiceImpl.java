package com.serzh.tibetdoctor.services.impl;

import com.serzh.tibetdoctor.domain.Appointment;
import com.serzh.tibetdoctor.repositories.AppointmentRepository;
import com.serzh.tibetdoctor.services.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * @author sergii.zagryvyi on 30.11.2017
 */
@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

//    @Override
//    public Iterable<Appointment> listAllAppointments() {
//        return null;
//    }

    @Override
    public Appointment getAppointmentById(Integer id) {
        return appointmentRepository.findOne(id);
    }

    @Override
    public Appointment saveAppointment(Appointment appointment) {
        appointment.setDate(LocalDate.now());
        appointmentRepository.save(appointment);
        return appointment;
    }

    @Override
    public void deleteAppointment(Integer id) {
        appointmentRepository.delete(id);

    }

    public Iterable<Appointment> getAllAppointmentsByPatientId(int id) {
        return appointmentRepository.findByPatientIdOrderByDateDesc( id);
    }

}
