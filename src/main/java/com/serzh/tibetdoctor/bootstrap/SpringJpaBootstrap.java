package com.serzh.tibetdoctor.bootstrap;

import com.serzh.tibetdoctor.domain.*;
import com.serzh.tibetdoctor.repositories.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final PatientRepository patientRepository;
    private final DrugsRepository drugsRepository;
    private final RecipesRepository recipesRepository;
    private final DosageRepository dosageRepository;
    private final DayTimeRepository dayTimeRepository;
    private final TimeRelativeMealRepository timeRelativeMealRepository;
    private final MealRelationRepository mealRelationRepository;
    private final TakeWithRepository takeWithRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Patient patient1 = Patient.builder()
                .sex(SexEnum.MALE.getSex())
                .name("Владимир")
                .patronymic("Васильевич")
                .surname("Иванов")
                .birthday(LocalDate.of(1980, 3, 11))
                .phone("+380661238923")
                .email("jim@gmail.com")
                .contacts("skype - vladimir.i, facebook - vladimir.ivanov")
                .additionalInfo("Обычно опаздывает на прием.")
                .build();


        List<Drug> drugs = createDrugs();
        List<Dosage> dosages = createDosage();
        List<DayTime> dayTimes = createDayTimes();
        List<MealRelation> mealRelations = createRelativeMeal();
//        List<TimeRelativeMeal> timeRelativeMeals = createTimeRelativeMeal();
        List<TakeWith> takeWiths = createTakeWiths();

        Recipe recipe1 = Recipe.builder()
                .patient(patient1)
                .date(LocalDate.now().minusDays(2))
                .drug(drugs.get(0))
                .dosage(dosages.get(0))
                .dayTime(dayTimes.get(0))
//                .timeRelativeMeal(timeRelativeMeals.get(0))
                .mealRelation(mealRelations.get(0))
                .durationTakingMedicines(15)
                .beginningTakingMedicines(LocalDate.of(2017, 12, 22))
                .takeWith(takeWiths.get(0))
                .additionalInfo("Пить через день")
                .build();

        recipesRepository.save(recipe1);

        Recipe recipe2 = Recipe.builder()
                .patient(patient1)
                .date(LocalDate.now().minusMonths(1))
                .drug(drugs.get(1))
                .dosage(dosages.get(1))
                .dayTime(dayTimes.get(1))
//                .timeRelativeMeal(timeRelativeMeals.get(1))
                .mealRelation(mealRelations.get(1))
                .durationTakingMedicines(7)
                .beginningTakingMedicines(LocalDate.of(2017, 12, 22))
                .takeWith(takeWiths.get(1))
                .additionalInfo("Прописан массаж кунье.")
                .build();

        recipesRepository.save(recipe2);

        Patient patient2 = Patient.builder()
                .name("Jolly")
                .sex(SexEnum.FEMALE.getSex())
                .surname("Vahtangovna")
                .phone("0506784567")
                .build();


        patientRepository.save(patient1);

//        Recipe recipe = recipes.get(0);
//        recipe.setPatient(patient1);
//        recipesRepository.save(recipe);
        log.info("Saved patient - id: " + patient1.getId());
        log.info("Saved patient - id: " + patient1);
        patientRepository.save(patient2);
        log.info("Saved patient - id: " + patient2.getId());



    }

    private List<TakeWith> createTakeWiths() {
        List<TakeWith> takeWiths = new ArrayList<>();
        TakeWith hotWater = TakeWith.builder()
                .value("запивать кипятком")
                .build();
        takeWithRepository.save(hotWater);
        TakeWith milk = TakeWith.builder()
                .value("запивать молоком")
                .build();
        takeWithRepository.save(milk);

        takeWiths.add(hotWater);
        takeWiths.add(milk);
        return takeWiths;
    }

    private List<DayTime> createDayTimes() {
        List<DayTime> dayTimes = new ArrayList<>();
        DayTime morning = DayTime.builder()
                .value("утро")
                .build();
        dayTimeRepository.save(morning);

        DayTime evening = DayTime.builder()
                .value("вечер")
                .build();
        dayTimeRepository.save(evening);

        dayTimes.add(morning);
        dayTimes.add(evening);
        return dayTimes;
    }

    private List<MealRelation> createRelativeMeal() {
        List<MealRelation> mealRelations = new ArrayList<>();
        MealRelation beforeMeal = MealRelation.builder()
                .value("за 15 минут до еды")
                .build();
        mealRelationRepository.save(beforeMeal);

        MealRelation afterMeal = MealRelation.builder()
                .value("через час после еды")
                .build();
        mealRelationRepository.save(afterMeal);

        mealRelations.add(beforeMeal);
        mealRelations.add(afterMeal);

        return mealRelations;
    }
/*
    private List<TimeRelativeMeal> createTimeRelativeMeal() {
        List<TimeRelativeMeal> timeRelativeMeals = new ArrayList<>();
        TimeRelativeMeal minutes = TimeRelativeMeal.builder()
                .value("15 минут")
                .build();

        timeRelativeMealRepository.save(minutes);

        TimeRelativeMeal hour = TimeRelativeMeal.builder()
                .value("1 час")
                .build();

        timeRelativeMealRepository.save(hour);

        timeRelativeMeals.add(minutes);
        timeRelativeMeals.add(hour);
        return timeRelativeMeals;
    }*/

    private List<Dosage> createDosage() {
        List<Dosage> dosages = new ArrayList<>();
        Dosage dosage1 = Dosage.builder()
                .value("1 грамм(чайная ложка)")
                .build();
        dosageRepository.save(dosage1);
        Dosage dosage2 = Dosage.builder()
                .value("2 грамма")
                .build();

        dosageRepository.save(dosage2);
        dosages.add(dosage1);
        dosages.add(dosage2);
        return dosages;
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
                .code("DF5")
                .name("Agar")
                .type("порошек")
                .build();

        drugsRepository.save(drug2);
        log.info("Saved drug - id: " + drug2.getId());

        result.add(drug1);
        result.add(drug2);

        return result;
    }

}


