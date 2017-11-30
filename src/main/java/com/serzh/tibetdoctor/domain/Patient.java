package com.serzh.tibetdoctor.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
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
    private String name;
    private String surname;
    private String patronymic;
//    @Min(value = 18, message = "Age should not be less than 18")
//    @Max(value = 150, message = "Age should not be greater than 150")
    private int age;
    private LocalDate birthday;
    @Pattern(regexp="(^$|[0-9]{10})")
    private String phone;
    @Email(message = "Email should be valid")
    private String email;


}