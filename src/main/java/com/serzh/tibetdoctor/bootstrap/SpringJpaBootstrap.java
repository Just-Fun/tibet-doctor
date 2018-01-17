package com.serzh.tibetdoctor.bootstrap;

import com.serzh.tibetdoctor.domain.*;
import com.serzh.tibetdoctor.repositories.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Priority;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
@Priority(1)
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {

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
        List<TakeWith> takeWiths = createTakeWiths();

        Appointment appointment1 = Appointment.builder()
                .patient(patient1)
                .date(LocalDate.now().minusDays(2))
//                .recipes(recipes)
                .diagnosis("Много жара")
                .additionalInfo("Пить через день")
                .procedures("Обливания")
                .diet("Пить много кипятка")
                .lifestyle("Плавать")
                .build();

        Recipe recipe1 = Recipe.builder()
                .appointment(appointment1)
                .drug(drugs.get(0))
                .dosage(dosages.get(0))
                .dayTime(dayTimes.get(0))
                .mealRelation(mealRelations.get(0))
                .durationTakingMedicines(15)
                .beginningTakingMedicines(LocalDate.of(2017, 12, 22))
                .takeWith(takeWiths.get(0))
                .build();
        List<Recipe> recipes = new LinkedList<>();
        recipes.add(recipe1);

        appointment1.setRecipes(recipes);

        appointmentRepository.save(appointment1);
        log.info("save appointment1: " + appointment1);
        recipeRepository.save(recipe1);
        log.info("save recipe1: " + recipe1);

/*        Appointment appointment2 = Appointment.builder()
                .patient(patient1)
                .date(LocalDate.now().minusMonths(1))
                .diagnosis("Много ветра")
                .additionalInfo("Прописан массаж кунье.")
                .procedures("Обливания по утрам")
                .diet("Пить много охлажденного кипятка")
                .lifestyle("бегать")
                .build();

        appointmentRepository.save(appointment2);

        Recipe recipe2 = Recipe.builder()
                .appointment(appointment1)
                .drug(drugs.get(1))
                .dosage(dosages.get(1))
                .dayTime(dayTimes.get(1))
                .mealRelation(mealRelations.get(1))
                .durationTakingMedicines(7)
                .beginningTakingMedicines(LocalDate.of(2017, 12, 22))
                .takeWith(takeWiths.get(1))
                .build();

        recipeRepository.save(recipe2);*/


     /*   Patient patient2 = Patient.builder()
                .name("Jolly")
                .sex(SexEnum.FEMALE.getSex())
                .surname("Vahtangovna")
                .phone("0506784567")
                .build();*/


        patientRepository.save(patient1);
        log.info("Saved patient: " + patient1);

//        patientRepository.save(patient2);
//        log.info("Saved patient: " + patient2);

       /* for (int i = 0; i < 3; i++) {

            Patient patient = Patient.builder()
                    .sex(SexEnum.MALE.getSex())
                    .name("Zed")
                    .patronymic("Васильевич")
                    .surname("Иванов")
                    .birthday(LocalDate.of(1980, 3, 11))
                    .phone(String.valueOf(i))
                    .email("jim@gmail.com")
                    .contacts("skype - vladimir.i, facebook - vladimir.ivanov")
                    .additionalInfo("Обычно опаздывает на прием.")
                    .build();

            patientRepository.save(patient);
        }*/

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

        DrugType drugType = createDrugTypes().get(0);

        Drug drug1 = Drug.builder()
                .code("AD4")
                .name("adelito")
                .type(drugType)
                .available(500)
                .build();

        drugsRepository.save(drug1);
        log.info("Saved drug: " + drug1);

        Drug drug2 = Drug.builder()
                .code("DF5")
                .name("Agar")
                .type(drugType)
                .build();

        drugsRepository.save(drug2);
        log.info("Saved drug: " + drug2);

        result.add(drug1);
        result.add(drug2);

        return result;
    }

    private List<DrugType> createDrugTypes() {
        List<DrugType> result = new ArrayList<>();
        DrugType drugType1 = DrugType.builder()
                .value("порошек")
                .build();
        drugTypeRepository.save(drugType1);

        DrugType drugType2 = DrugType.builder()
                .value("жидкость")
                .build();
        drugTypeRepository.save(drugType2);

        result.add(drugType1);
        result.add(drugType2);

        return result;
    }

}


