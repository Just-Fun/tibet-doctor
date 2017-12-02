package com.serzh.tibetdoctor.bootstrap;

import com.serzh.tibetdoctor.domain.Drug;
import com.serzh.tibetdoctor.domain.Patient;
import com.serzh.tibetdoctor.repositories.DrugsRepository;
import com.serzh.tibetdoctor.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final PatientRepository patientRepository;
    private final DrugsRepository drugsRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Patient patient1 = Patient.builder()
                .name("Jim")
//                .phone()
                .email("jim@gmail.com")
                .build();

        Patient patient2 = Patient.builder()
                .name("Jolly")
                .phone("0506784567")
                .build();


        patientRepository.save(patient1);
        log.info("Saved patient - id: " + patient1.getId());
        patientRepository.save(patient2);
        log.info("Saved patient - id: " + patient2.getId());


        List<Drug> drugs = createDrugs();


    }

    private List<Drug> createDrugs() {
        List<Drug> result = new ArrayList<>();

        Drug drug1 = Drug.builder()
                .code("AD4")
                .name("adelito")
                .type("порошек")
                .available(500)
                .build();

        drugsRepository.save(drug1);
        log.info("Saved drug - id: " + drug1.getId());

        Drug drug2 = Drug.builder()
                .code("Some Code")
                .name("Agar")
                .type("порошек")
                .build();

        drugsRepository.save(drug2);
        log.info("Saved drug - id: " + drug2.getId());

        result.add(drug1);
        result.add(drug2);

        return result;
    }


    /*    @ManyToOne
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
    private String additionalInfo;*/

}


