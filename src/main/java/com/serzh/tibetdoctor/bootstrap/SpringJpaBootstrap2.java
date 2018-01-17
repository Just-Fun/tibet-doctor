package com.serzh.tibetdoctor.bootstrap;

import com.serzh.tibetdoctor.domain.Appointment;
import com.serzh.tibetdoctor.repositories.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Slf4j
@RequiredArgsConstructor
public class SpringJpaBootstrap2 implements ApplicationListener<ContextRefreshedEvent> {

    private final PatientRepository patientRepository;
    private final DrugsRepository drugsRepository;
    private final AppointmentRepository appointmentRepository;
    private final DosageRepository dosageRepository;
    private final DayTimeRepository dayTimeRepository;
    private final MealRelationRepository mealRelationRepository;
    private final TakeWithRepository takeWithRepository;
    private final DrugTypeRepository drugTypeRepository;
    private final RecipeRepository recipeRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Iterable<Appointment> all = appointmentRepository.findAll();
        System.out.printf("");
    }




}


