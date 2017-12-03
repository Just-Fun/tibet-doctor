package com.serzh.tibetdoctor.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author sergii.zagryvyi on 30.11.2017
 */
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Patient patient;
    private LocalDate date;
    @ManyToOne
    private Drug drug;
    @ManyToOne
    private Dosage dosage;
    @ManyToOne
    private DayTime dayTime;
    @ManyToOne
    private MealRelation mealRelation;
    @ManyToOne
    private TimeRelativeMeal timeRelativeMeal;
    private int durationTakingMedicines;
    private LocalDate beginningTakingMedicines;
    @ManyToOne
    private TakeWith takeWith;


    private String additionalInfo;


}