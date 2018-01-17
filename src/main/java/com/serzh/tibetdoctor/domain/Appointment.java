package com.serzh.tibetdoctor.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sergii.zagryvyi on 30.11.2017
 */
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Patient patient;
    private LocalDate date;
//    @OneToOne
//    private Recipes recipes;
//    @OneToMany
//    private Iterable<Recipe> recipes;
    @OneToMany(targetEntity=Recipe.class, mappedBy="appointment")
    private List<Recipe> recipes=new LinkedList<>();
    /*@ManyToOne
    private Drug drug;
    @ManyToOne
    private Dosage dosage;
    @ManyToOne
    private DayTime dayTime;
    @ManyToOne
    private MealRelation mealRelation;
    private int durationTakingMedicines;
    private LocalDate beginningTakingMedicines;
    @ManyToOne
    private TakeWith takeWith;*/

    private String diagnosis;
    private String procedures;
    private String diet;
    private String lifestyle;

    private String additionalInfo;


}
