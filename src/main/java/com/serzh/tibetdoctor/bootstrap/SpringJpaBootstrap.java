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
                .age(20)
                .build();

        Patient patient2 = Patient.builder()
                .name("Jolly")
                .age(22)
                .build();


        patientRepository.save(patient1);
        log.info("Saved patient - id: " + patient1.getId());
        patientRepository.save(patient2);
        log.info("Saved patient - id: " + patient2.getId());


        Drug drug = Drug.builder()
                .code("Some Code")
                .name("Agar")
                .type("порошек")
                .build();

        drugsRepository.save(drug);
        log.info("Saved drug - id: " + drug.getId());


    }

}


