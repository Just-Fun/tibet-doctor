package com.serzh.tibetdoctor.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * @author sergii.zagryvyi on 30.11.2017
 */
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //    @NotNull(message = "Name cannot be null")
    private String sex;
    private String name;
    private String patronymic;
    private String surname;
    //    @Min(value = 18, message = "Age should not be less than 18")
//    @Max(value = 150, message = "Age should not be greater than 150")
//    private int age;
    private LocalDate birthday;
//    @Pattern(regexp = "(^$|[0-9]{10})")
    private String phone;
//    @Email(message = "Email should be valid")
    private String email;
    private String contacts;
    private String additionalInfo;

    /*@OneToMany(fetch = FetchType.LAZY)
    private List<Appointment> appointments;

    public void setAppointments(Appointment appointment) {
        if (CollectionUtils.isEmpty(appointments)) {
            appointments = new ArrayList<>();
        }
        if (appointment.getPatient() == null) {
            appointment.setPatient(this);
            appointments.add(appointment);
        }
    }*/


}
