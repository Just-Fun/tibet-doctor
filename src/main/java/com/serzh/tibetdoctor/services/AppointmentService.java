package com.serzh.tibetdoctor.services;

import com.serzh.tibetdoctor.domain.Appointment;

public interface AppointmentService {

//    Iterable<Appointment> listAllAppointments();

    Appointment getAppointmentById(Integer id);

    Appointment saveAppointment(Appointment appointment);

    void deleteAppointment(Integer id);

    Iterable<Appointment> getAllAppointmentsByPatientId(int id);
}
